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

    // Constructors (مانند کد بخش دوم که قبلاً ارائه شد)
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
    
    public SymbolAttributes(String name, String type, String accessModifier, Map<String, String> parameters, boolean isAbstract, boolean isOverride) {
        this.kind = (name.equals("CTOR")) ? Kind.CONSTRUCTOR : Kind.METHOD;
        this.type = type;
        this.accessModifier = accessModifier;
        this.parameters = parameters;
        this.isAbstract = isAbstract;
        this.isOverride = isOverride;
        this.parentName = null;
        this.implementedInterfaces = null;
        this.scope = "Method";
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{kind: ").append(kind.name());
        if (type != null) sb.append(", type: ").append(type);
        if (accessModifier != null) sb.append(", access: ").append(accessModifier);
        if (isAbstract) sb.append(", abstract: true");
        // ... (ادامه پیاده‌سازی toString مطابق کد قبلی) ...
        if (parameters != null) {
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