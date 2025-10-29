package com.example.jmmparser;

import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolTable {
    
    private final SymbolTable parent;
    private final String scopeName;
    private final Map<String, SymbolAttributes> symbols;

    public SymbolTable(String scopeName, SymbolTable parent) {
        this.scopeName = scopeName;
        this.parent = parent;
        this.symbols = new LinkedHashMap<>();
    }

    public boolean insert(String identName, SymbolAttributes attributes) {
        if (symbols.containsKey(identName)) {
            return false;
        }
        symbols.put(identName, attributes);
        return true;
    }

    public SymbolAttributes lookup(String identName) {
        if (symbols.containsKey(identName)) {
            return symbols.get(identName);
        }
        if (parent != null) {
            return parent.lookup(identName);
        }
        return null;
    }

    public SymbolAttributes lookupCurrentScope(String identName) {
        return symbols.get(identName);
    }
    
    public SymbolTable getParent() { return parent; }
    public String getScopeName() { return scopeName; }
    public Map<String, SymbolAttributes> getSymbols() { return symbols; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Symbol Table for Scope: ").append(scopeName).append(" ---\n");
        for (Map.Entry<String, SymbolAttributes> entry : symbols.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}