package com.amity.parser.model;

/**
 * Program or root of AST
 */
public class Program {
    /**
     * type of node
     */
    private String type;
    /**
     * value
     */
    private ASTNode body;

    public Program(String type, ASTNode body) {
        this.type = type;
        this.body = body;
    }

}