package com.example.jmmparser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SymbolAttributes {
    public enum Kind {
        CLASS, INTERFACE, METHOD, CONSTRUCTOR, FIELD, PARAMETER, VARIABLE
    }

    public final Kind kind;
    public final String type;
    public final String accessModifier;
    public final Map<String, String> parameters;
    public final boolean isAbstract;
    public final boolean isOverride;
    public final String parentName;
    public final List<String> implementedInterfaces;
    public final String scope;

    // --- 1. سازنده برای CLASS/INTERFACE ---
    // (استفاده شده در: enterMainClass, enterClassDecl, enterInterfaceDecl)
    public SymbolAttributes(Kind kind, String accessModifier, boolean isAbstract, String parentName, List<String> implementedInterfaces) {
        this.kind = kind;
        this.type = null;
        this.accessModifier = accessModifier;
        this.isAbstract = isAbstract;
        this.parentName = parentName;
        this.implementedInterfaces = implementedInterfaces;
        this.parameters = null;
        this.isOverride = false;
        this.scope = "Global";
    }

    // --- 2. سازنده برای متدها (روش صریح تر) ---
    // این سازنده قبلی را برای متدها بازنویسی می کند
    // (استفاده شده در: enterMethodDecl)
    public SymbolAttributes(Kind kind, String name, String returnType, String accessModifier, Map<String, String> parameters, boolean isAbstract, boolean isOverride) {
        this.kind = kind; // METHOD یا CONSTRUCTOR
        this.type = returnType;
        this.accessModifier = accessModifier;
        this.parameters = parameters;
        this.isAbstract = isAbstract;
        this.isOverride = isOverride;
        this.parentName = name; // برای متدها، name می تواند نام متد باشد (یا نام سازنده)
        this.implementedInterfaces = null;
        this.scope = "Method"; 
    }
    
    // **<<< سازنده جدید 1: متغیرهای محلی و پارامترها (Kind, Type, Scope) >>>**
    // (استفاده شده در: exitParameter, exitLocalDecl - برای رفع خطای 85, 203, 225)
    public SymbolAttributes(Kind kind, String type, String scope) {
        this.kind = kind;
        this.type = type;
        this.scope = scope;
        this.accessModifier = null;
        this.parameters = null;
        this.isAbstract = false;
        this.isOverride = false;
        this.parentName = null;
        this.implementedInterfaces = null;
    }

    // **<<< سازنده جدید 2: متدهای مین و دیگر متدهای خاص (Kind, Type, Access, Params, Abstract, Override) >>>**
    // (استفاده شده در: enterMainClass - برای رفع خطای 77)
    public SymbolAttributes(Kind kind, String returnType, String accessModifier, Map<String, String> parameters, boolean isAbstract, boolean isOverride) {
        this.kind = kind; // METHOD یا CONSTRUCTOR
        this.type = returnType;
        this.accessModifier = accessModifier;
        this.parameters = parameters;
        this.isAbstract = isAbstract;
        this.isOverride = isOverride;
        this.parentName = null; 
        this.implementedInterfaces = null;
        this.scope = "Method"; 
    }

    // **<<< سازنده جدید 3: فیلدها (Kind, Type, Access, Scope) >>>**
    // (استفاده شده در: exitFieldDecl - این در واقع همان سازنده قدیمی شماست، فقط دسترسی را null نکردم)
    public SymbolAttributes(Kind kind, String type, String accessModifier, String scope) {
        this.kind = kind;
        this.type = type;
        this.accessModifier = accessModifier;
        this.scope = scope;
        this.parameters = null;
        this.isAbstract = false;
        this.isOverride = false;
        this.parentName = null;
        this.implementedInterfaces = null;
    }
    
    // --- پیاده‌سازی toString ---
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{kind: ").append(kind.name());
        
        // فیلدهای مشترک
        if (type != null) sb.append(", type: ").append(type);
        if (accessModifier != null && !accessModifier.isEmpty()) sb.append(", access: ").append(accessModifier);
        
        // فیلدهای خاص متد/کلاس
        if (kind == Kind.CLASS && parentName != null) sb.append(", extends: ").append(parentName);
        if (isAbstract) sb.append(", abstract: true");
        if (isOverride) sb.append(", override: true");

        // پارامترها
        if (parameters != null && !parameters.isEmpty()) {
            String params = parameters.entrySet().stream()
                .map(e -> e.getValue() + " " + e.getKey())
                .collect(Collectors.joining(", "));
            sb.append(", params: (").append(params).append(")");
        }
        
        sb.append(", scope: ").append(scope);
        sb.append("}");
        return sb.toString();
    }
}