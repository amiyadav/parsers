package com.amity.parser;

import com.amity.parser.exceptions.ParserError;
import com.amity.parser.model.*;
import com.amity.parser.tokenizer.TokenizerWithSpecifications;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.amity.parser.AppConstant.*;

/**
 * Predictive number parser with specified regex patterns needed in tokenizer
 */
public class PredictiveSpecifiedPatternsRecursiveDescentParser {
    static ObjectMapper mapper = new ObjectMapper()
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    private TokenizerWithSpecifications tokenizer;
    private ASTNode _predictedNextToken;

    public PredictiveSpecifiedPatternsRecursiveDescentParser() {
    }

    // Get in to entry point and parse recursively until reaches end
    public String parse(String stringToParse) {
        this.tokenizer = new TokenizerWithSpecifications(stringToParse);
        _predictedNextToken = tokenizer.getNextToken();
        return entryPointForProgram();
    }

    /**
     * Main Entry for program
     * <p>
     * Program
     * : NumericalLiteral
     * ;
     */
    private String entryPointForProgram() {
        try {
            switch (this._predictedNextToken.getType()) {
                case NUMBER:
                    new NumericLiteral(_predictedNextToken, tokenizer);
                    break;
                case STRING:
                    new StringLiteral(_predictedNextToken, tokenizer);
                    break;
                case COMMENTS:
                case NULL:
                    new CommentSpaceLiteral(_predictedNextToken, tokenizer);
                    break;
                default:
                    throw new ParserError(400, "unknown type");
            }
            Program program = new Program("Program", _predictedNextToken);
            return mapper.writeValueAsString(program);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("exception while stringify object... ");
        }
    }
}
