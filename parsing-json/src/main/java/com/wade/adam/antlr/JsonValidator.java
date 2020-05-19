package com.wade.adam.antlr;

import grammars.JSONBaseVisitor;
import grammars.JSONLexer;
import grammars.JSONParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class JsonValidator {

    public void validate(String source) {
        CodePointCharStream input = CharStreams.fromString(source);
        compile(input);
    }

    private void compile(CharStream source) {
        JSONLexer lexer = new JSONLexer(source);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokenStream);
        ParseTree tree = parser.json();
        JSONBaseVisitor<Object> visitor = new JSONBaseVisitor<>();
        visitor.visit(tree);
    }

}
