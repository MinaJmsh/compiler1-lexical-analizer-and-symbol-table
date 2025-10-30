package com.example.jmmparser;

import com.example.jmmparser.SymbolAttributes.Kind;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.*;
import java.util.stream.Collectors;

public class SymbolTableBuilder extends javaMinusMinus2BaseListener {

    private SymbolTable currentScope;
    private final SymbolTable globalScope;
    private int blockCounter = 0; 

    private final Map<String, SymbolTable> allScopes = new LinkedHashMap<>(); 

    public SymbolTableBuilder() {
        this.globalScope = new SymbolTable("Global", null); 
        this.currentScope = globalScope;
        allScopes.put("Global", globalScope);
    }
    
    public SymbolTable getGlobalScope() {
        return globalScope;
    }
    
    public Map<String, SymbolTable> getAllScopes() {
        return allScopes;
    }

    // --- Scope Management ---

    private void enterScope(String name) {
        SymbolTable newScope = new SymbolTable(name, currentScope);
        currentScope = newScope;
        allScopes.put(name, newScope);
    }

    private void exitScope() {
        if (currentScope.getParent() != null) {
            currentScope = currentScope.getParent();
        }
    }

    // --- Helper for Literal Tokens ---

    private boolean isLiteralPresent(org.antlr.v4.runtime.ParserRuleContext ctx, String literal) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i).getText().equals(literal)) {
                return true;
            }
        }
        return false;
    }
    
    // --- Rule Enter/Exit Handlers ---

    @Override
    public void enterMainClass(javaMinusMinus2Parser.MainClassContext ctx) {
        // 1. ثبت کلاس در اسکوپ Global
        String className = ctx.Identifier().get(0).getText(); 
        SymbolAttributes classAttr = new SymbolAttributes(Kind.CLASS, "public", false, null, Collections.emptyList());
        globalScope.insert(className, classAttr); 
        
        // 2. ورود به اسکوپ کلاس
        enterScope("Class_" + className);
        
        // 3. ثبت متد main در اسکوپ کلاس (currentScope = Class scope)
        String methodName = "main";
        String returnType = "void"; 
        String access = "public static"; // متد main public static است.

        // پارامتر String[] args را استخراج می کنیم.
        Map<String, String> params = new LinkedHashMap<>();
        // فرض می‌کنیم در MainClassContext، آرگومان‌ها همیشه String[] args باشند.
        params.put("args", "String[]"); 

        SymbolAttributes methodAttr = new SymbolAttributes(Kind.METHOD, methodName, returnType, access, params, false, false);
        currentScope.insert(methodName, methodAttr);
        
        // 4. ورود به اسکوپ متد main
        enterScope("Method_" + methodName);
        
        // 5. ثبت پارامتر args در اسکوپ متد
        // چون enterMainClassContext شامل پارامترها نیست، باید دستی اینجا ثبت شود.
        SymbolAttributes paramAttr = new SymbolAttributes(Kind.PARAMETER, "String[]", "Method"); // متغیر محلی/پارامتر سطح دسترسی ندارد.
        currentScope.insert("args", paramAttr);
    }

    @Override
    public void exitMainClass(javaMinusMinus2Parser.MainClassContext ctx) {
        exitScope(); // خروج از اسکوپ متد (main)
        exitScope(); // خروج از اسکوپ کلاس (Class_A)
        // این دو exitScope برای مطابقت با دو enterScope در enterMainClass نیاز است.
    }

    @Override
    public void enterClassDecl(javaMinusMinus2Parser.ClassDeclContext ctx) {
        String className = ctx.Identifier().get(0).getText();
        
        enterScope("Class_" + className);

        boolean isAbstract = isLiteralPresent(ctx, "abstract");
        String parentName = null;
        List<String> interfaces = new ArrayList<>();
        
        if (isLiteralPresent(ctx, "extends")) {
            // منطق استخراج
        }
        
        String access = getAccessModifier(null); // فرض کنیم اگر دسترسی مشخص نشده، internal است.

        SymbolAttributes classAttr = new SymbolAttributes(Kind.CLASS, access, isAbstract, parentName, interfaces);
        globalScope.insert(className, classAttr); 
    }

    @Override
    public void exitClassDecl(javaMinusMinus2Parser.ClassDeclContext ctx) {
        exitScope(); 
    }
    
    @Override
    public void enterInterfaceDecl(javaMinusMinus2Parser.InterfaceDeclContext ctx) {
        String interfaceName = ctx.Identifier().getText();
        enterScope("Interface_" + interfaceName);
        
        SymbolAttributes interfaceAttr = new SymbolAttributes(Kind.INTERFACE, null, true, null, Collections.emptyList());
        globalScope.insert(interfaceName, interfaceAttr);
    }
    
    @Override
    public void exitInterfaceDecl(javaMinusMinus2Parser.InterfaceDeclContext ctx) {
        exitScope(); 
    }

    @Override
    public void enterMethodDecl(javaMinusMinus2Parser.MethodDeclContext ctx) {
        String methodName = ctx.Identifier().getText();
        
        // 1. ثبت متد در اسکوپ والد (اسکوپ کلاس)
        String returnType = ctx.type() != null ? getType(ctx.type()) : "void";
        String access = getAccessModifier(ctx.accessModifier());
        boolean isAbstract = isLiteralPresent(ctx, "abstract");
        boolean isOverride = isLiteralPresent(ctx, "@Override");

        Map<String, String> params = extractParameters(ctx.parameterList());

        SymbolAttributes methodAttr = new SymbolAttributes(Kind.METHOD, methodName, returnType, access, params, isAbstract, isOverride);
        currentScope.insert(methodName, methodAttr); // currentScope در اینجا اسکوپ کلاس است.
        
        // 2. ورود به اسکوپ متد
        enterScope("Method_" + methodName);
        
        // 3. ثبت پارامترها (جداگانه از متد extractParameters)
        // ANTLR Listener به‌طور خودکار به enter/exitParameter می‌رود، پس ثبت پارامترها را در آنجا انجام می‌دهیم.
    }

    @Override
    public void exitMethodDecl(javaMinusMinus2Parser.MethodDeclContext ctx) {
        exitScope(); 
    }
    
    @Override
    public void enterCtorDecl(javaMinusMinus2Parser.CtorDeclContext ctx) {
        String ctorName = ctx.Identifier().getText();
        
        // 1. ثبت سازنده در اسکوپ والد (اسکوپ کلاس)
        String access = getAccessModifier(ctx.accessModifier());
        Map<String, String> params = extractParameters(ctx.parameterList());
        
        SymbolAttributes ctorAttr = new SymbolAttributes(Kind.CONSTRUCTOR, ctorName, ctorName, access, params, false, false); // نوع بازگشتی هم نام کلاس است
        currentScope.insert(ctorName, ctorAttr);

        // 2. ورود به اسکوپ سازنده
        enterScope("Constructor_" + ctorName);
        
        // ثبت پارامترها توسط exitParameter انجام می‌شود.
    }

    @Override
    public void exitCtorDecl(javaMinusMinus2Parser.CtorDeclContext ctx) {
        exitScope(); 
    }
    
    @Override
    public void enterBlockStmt(javaMinusMinus2Parser.BlockStmtContext ctx) {
        blockCounter++;
        enterScope("Block_" + blockCounter);
    }

    @Override
    public void exitBlockStmt(javaMinusMinus2Parser.BlockStmtContext ctx) {
        exitScope(); 
    }

    // --- Variable/Field/Parameter Handlers ---

    @Override
    public void exitParameter(javaMinusMinus2Parser.ParameterContext ctx) {
        String paramName = ctx.Identifier().getText();
        String paramType = getType(ctx.type());
        
        // اصلاح: حذف سطح دسترسی (پارامترها و متغیرهای محلی سطح دسترسی ندارند)
        SymbolAttributes paramAttr = new SymbolAttributes(Kind.PARAMETER, paramType, "Method"); 
        currentScope.insert(paramName, paramAttr);
    }
    
    @Override
    public void exitFieldDecl(javaMinusMinus2Parser.FieldDeclContext ctx) {
        String fieldName = ctx.varDecl().Identifier().getText();
        String fieldType = getType(ctx.varDecl().type());
        String access = getAccessModifier(ctx.varDecl().accessModifier());
        
        SymbolAttributes fieldAttr = new SymbolAttributes(Kind.FIELD, fieldType, access, "Class");
        currentScope.insert(fieldName, fieldAttr);
    }
    
    @Override
    public void exitLocalDecl(javaMinusMinus2Parser.LocalDeclContext ctx) {
        String varName = ctx.Identifier().getText();
        String varType = getType(ctx.type());
        
        // اصلاح: حذف سطح دسترسی (متغیرهای محلی سطح دسترسی ندارند)
        // نوع اسکوپ: اگر Block باشد Block وگرنه Method (اگر در متد اما بیرون از Block باشد)
        String scopeType = currentScope.getScopeName().startsWith("Block") ? "Block" : "Method";
        SymbolAttributes varAttr = new SymbolAttributes(Kind.VARIABLE, varType, scopeType); 
        currentScope.insert(varName, varAttr);
    }

    // --- Utility Methods ---

    private String getType(javaMinusMinus2Parser.TypeContext ctx) {
        if (ctx == null) return "Unknown";
        
        String baseType;
        if (ctx.javaType() != null) {
            baseType = ctx.javaType().getText();
        } else {
            baseType = ctx.Identifier().getText(); 
        }
        
        if (ctx.LSB() != null) {
            return baseType + "[]"; 
        }
        return baseType;
    }

    private String getAccessModifier(javaMinusMinus2Parser.AccessModifierContext ctx) {
        if (ctx == null) return "internal"; 
        return ctx.getText();
    }
    
    private Map<String, String> extractParameters(javaMinusMinus2Parser.ParameterListContext ctx) {
        Map<String, String> params = new LinkedHashMap<>();
        if (ctx != null) {
            for (javaMinusMinus2Parser.ParameterContext param : ctx.parameter()) {
                String type = getType(param.type());
                String name = param.Identifier().getText();
                params.put(name, type);
            }
        }
        return params;
    }
}