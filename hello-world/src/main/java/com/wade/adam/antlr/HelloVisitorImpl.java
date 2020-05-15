package com.wade.adam.antlr;

import grammars.HelloBaseVisitor;
import grammars.HelloParser;

public class HelloVisitorImpl extends HelloBaseVisitor<String> {

    @Override
    public String visitR(HelloParser.RContext ctx){
        if(ctx.ID() == null){
            throw new RuntimeException("ID must not be null!");
        }

        return ctx.ID().getText();
    }

}
