package com.wade.adam.antlr;

import grammars.ArrayInitLexer;
import grammars.ArrayInitParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class StringArrayToUnicodeConverter {

    public String convert(String source) {
        CodePointCharStream input = CharStreams.fromString(source);
        return compile(input);
    }

    private String compile(CharStream source) {
        ArrayInitLexer lexer = new ArrayInitLexer(source);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ArrayInitParser parser = new ArrayInitParser(tokenStream);
        ParseTree tree = parser.init();
        ArrayInitVisitor visitor = new ArrayInitVisitor();
        return visitor.visit(tree);
    }

}
