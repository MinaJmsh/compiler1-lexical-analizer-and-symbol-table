package com.example.jmmparser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public final class Main {
    
    private static String readAll(String path) throws IOException {
        // ... (تابع readAll) ...
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            char[] buf = new char[8192];
            int n;
            while ((n = br.read(buf)) != -1) sb.append(buf, 0, n);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java com.example.jmmparser.Main <source-file>");
            return;
        }

        String source = readAll(args[0]);

        // 1. ANTLR Lexer and Parser
        CharStream input = CharStreams.fromString(source);
        javaMinusMinus2Lexer lexer = new javaMinusMinus2Lexer(input); // Lexer ANTLR
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        javaMinusMinus2Parser parser = new javaMinusMinus2Parser(tokens); // Parser ANTLR
        
        // تنظیمات خطا: حذف ErrorListener پیش فرض برای گزارش خطای بهتر
        parser.removeErrorListeners(); 
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                System.err.println("Parser Error: [" + line + ":" + charPositionInLine + "] " + msg);
            }
        });
        
        // 2. شروع فرآیند تجزیه
        javaMinusMinus2Parser.ProgramContext tree = parser.program();

        // 3. پیمایش درخت و ساخت Symbol Table
        ParseTreeWalker walker = new ParseTreeWalker();
        SymbolTableBuilder builder = new SymbolTableBuilder();
        walker.walk(builder, tree);

        // 4. نمایش خروجی
        System.out.println("\n====================================");
        System.out.println("✅ Symbol Table Construction Complete");
        System.out.println("====================================\n");

        for (Map.Entry<String, SymbolTable> entry : builder.getAllScopes().entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}