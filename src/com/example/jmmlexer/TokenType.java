package com.example.jmmlexer;

/**
 * Token kinds for the hand-written lexer (JavaMinusMinus2 subset).
 * No external libraries. Only Java SE.
 */
public enum TokenType {
    // Keywords
    CLASS, INTERFACE, EXTENDS, IMPLEMENTS,
    PUBLIC, PRIVATE, PROTECTED, INTERNAL, STATIC, VOID, ABSTRACT,
    IF, ELSE, WHILE, FOR, BREAK, CONTINUE, RETURN, NEW, THIS, IMPORT,
    INT, CHAR, BOOLEAN, STRING, READ, PRINT,
    TRUE, FALSE, NULL,

    // Identifiers & Literals
    IDENTIFIER, INT_LITERAL, STRING_LITERAL, CHAR_LITERAL,

    // Operators (multi-char)
    EQ_EQ,        // ==
    BANG_EQ,      // !=
    LT_EQ,        // <=
    GT_EQ,        // >=
    AND_AND,      // &&
    OR_OR,        // ||
    POWER,        // **

    // Operators (single-char)
    PLUS, MINUS, STAR, SLASH, PERCENT,
    LT, GT, EQ, BANG, DOT,
    AT, // @

    // Delimiters
    LPAREN, RPAREN, LBRACE, RBRACE, LBRACK, RBRACK, COMMA, SEMI,

    // Special composite token
    DOTLENGTH,    // ".length"

    // Meta
    EOF, ERROR
}
