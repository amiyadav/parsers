package com.amity.parser;

import com.amity.parser.model.ASTNode;
import com.amity.parser.model.Program;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Single number recursive descent parser
 */
public class OneNumberRecursiveDescentParser {
    static ObjectMapper mapper = new ObjectMapper();


    private String string;

    public OneNumberRecursiveDescentParser(String string) {
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        this.string = string;
    }

    // Get in to entry point and parse recursively until reaches end
    public String parse() {
        return entryPointForProgram(this.string);
    }

    /**
     * Main Entry for program
     * <p>
     * Program
     * : NumericalLiteral
     * ;
     *
     * @param string program
     */
    private String entryPointForProgram(String string) {
        try {
            Program program = new Program("Program", this.NumericLiteral(string));
            return mapper.writeValueAsString(program);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("exception while stringify object... ");
        }
    }

    private ASTNode NumericLiteral(String string) {
        return new ASTNode("NumericLiteral", Double.parseDouble(string));
    }

}
