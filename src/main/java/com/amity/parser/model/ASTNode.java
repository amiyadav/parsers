package com.amity.parser.model;

/**
 * Abstract syntax tree node consist type (number, string ...) and its value
 * @param <T>
 */
public class ASTNode<T> {

    private String type;
    private T value;

    public ASTNode(String type, T value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public T getValue() {
        return value;
    }
}