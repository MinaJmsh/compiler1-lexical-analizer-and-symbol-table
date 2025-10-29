package com.example.jmmlexer;

/**
 * A lexical token with type, lexeme text, and source position.
 */
public final class Token {
    public final TokenType type;
    public final String lexeme;
    public final int line;
    public final int column;
    public final String message; // optional, for ERROR or diagnostics

    public Token(TokenType type, String lexeme, int line, int column) {
        this(type, lexeme, line, column, null);
    }

    public Token(TokenType type, String lexeme, int line, int column, String message) {
        this.type = type;
        this.lexeme = lexeme;
        this.line = line;
        this.column = column;
        this.message = message;
    }

    @Override
    public String toString() {
        if (message != null && type == TokenType.ERROR) {
            return String.format("[%d:%d] %-10s %-12s  // %s",
                    line, column, type.name(), show(lexeme), message);
        }
        return String.format("[%d:%d] %-10s %s", line, column, type.name(), show(lexeme));
    }

    private static String show(String s) {
        if (s == null) return "";
        return s.replace("\n", "\\n").replace("\t", "\\t").replace("\r", "\\r");
    }
}
