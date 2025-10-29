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
        // Identifier() در MainClassContext یک لیست برمی‌گرداند.
        String className = ctx.Identifier().get(0).getText(); 
        enterScope("Class_" + className);
        
        SymbolAttributes classAttr = new SymbolAttributes(Kind.CLASS, "public", false, null, Collections.emptyList());
        globalScope.insert(className, classAttr); 
    }

    @Override
    public void exitMainClass(javaMinusMinus2Parser.MainClassContext ctx) {
        exitScope(); 
        exitScope(); 
    }

    @Override
    public void enterClassDecl(javaMinusMinus2Parser.ClassDeclContext ctx) {
        // Identifier() در ClassDeclContext یک لیست برمی‌گرداند.
        String className = ctx.Identifier().get(0).getText();
        
        enterScope("Class_" + className);

        boolean isAbstract = isLiteralPresent(ctx, "abstract");
        String parentName = null;
        List<String> interfaces = new ArrayList<>();
        
        if (isLiteralPresent(ctx, "extends")) {
            // منطق استخراج
        }
        
        String access = getAccessModifier(null); 

        SymbolAttributes classAttr = new SymbolAttributes(Kind.CLASS, access, isAbstract, parentName, interfaces);
        globalScope.insert(className, classAttr); 
    }

    @Override
    public void exitClassDecl(javaMinusMinus2Parser.ClassDeclContext ctx) {
        exitScope(); 
    }
    
    @Override
    public void enterInterfaceDecl(javaMinusMinus2Parser.InterfaceDeclContext ctx) {
        // Identifier() در InterfaceDeclContext یک لیست برمی‌گرداند.
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
        // اصلاح نهایی: Identifier() در MethodDeclContext یک TerminalNode برمی‌گرداند.
        String methodName = ctx.Identifier().getText();
        enterScope("Method_" + methodName);

        boolean isOverride = isLiteralPresent(ctx, "@Override");
        
        String returnType = ctx.type() != null ? getType(ctx.type()) : "void";
        String access = getAccessModifier(ctx.accessModifier());
        
        Map<String, String> params = extractParameters(ctx.parameterList());

        SymbolAttributes methodAttr = new SymbolAttributes(methodName, returnType, access, params, false, isOverride);
        currentScope.getParent().insert(methodName, methodAttr);
    }

    @Override
    public void exitMethodDecl(javaMinusMinus2Parser.MethodDeclContext ctx) {
        exitScope(); 
    }
    
    @Override
    public void enterCtorDecl(javaMinusMinus2Parser.CtorDeclContext ctx) {
        // Identifier() در CtorDeclContext یک TerminalNode برمی‌گرداند.
        String ctorName = ctx.Identifier().getText();
        enterScope("Method_" + ctorName + "_CTOR");
        
        boolean isOverride = isLiteralPresent(ctx, "@Override");

        String access = getAccessModifier(ctx.accessModifier());
        Map<String, String> params = extractParameters(ctx.parameterList());

        SymbolAttributes ctorAttr = new SymbolAttributes("CTOR", ctorName, access, params, false, isOverride);
        currentScope.getParent().insert(ctorName, ctorAttr);
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
        
        SymbolAttributes paramAttr = new SymbolAttributes(Kind.PARAMETER, paramType, "private", "Method");
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
        
        SymbolAttributes varAttr = new SymbolAttributes(Kind.VARIABLE, varType, "private", currentScope.getScopeName().startsWith("Block") ? "Block" : "Method");
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