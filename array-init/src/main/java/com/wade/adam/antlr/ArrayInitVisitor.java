package com.wade.adam.antlr;

import grammars.ArrayInitBaseVisitor;
import grammars.ArrayInitParser;

import java.util.ArrayList;
import java.util.List;

public class ArrayInitVisitor extends ArrayInitBaseVisitor<String> {

    @Override
    public String visitInit(ArrayInitParser.InitContext ctx){
        List<String> values = new ArrayList<>();
        for (ArrayInitParser.ValueContext value : ctx.value()) {
            values.add(visit(value));
        }
        return "\"" + String.join(",", values) + "\"";
    }

    @Override
    public String visitValue(ArrayInitParser.ValueContext ctx) {
        if(ctx.INT() != null){
            int value = Integer.parseInt(ctx.INT().getText());
            return String.format("\\u%04x", value);
        }
        return visit(ctx.init());
    }

}
