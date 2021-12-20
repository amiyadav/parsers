package com.amity.parser;

import com.amity.parser.exceptions.ParserError;
import com.amity.parser.model.ASTNode;
import com.amity.parser.model.NumericLiteral;
import com.amity.parser.model.Program;
import com.amity.parser.model.StringLiteral;
import com.amity.parser.tokenizer.ManualTokenizer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.amity.parser.AppConstant.NUMBER;
import static com.amity.parser.AppConstant.STRING;

/**
 * Predictive number parser
 */
public class PredictiveOneNumberRecursiveDescentParser {
    static ObjectMapper mapper = new ObjectMapper()
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    private ManualTokenizer tokenizer;
    private ASTNode _predictedNextToken;

    public PredictiveOneNumberRecursiveDescentParser() {
    }

    // Get in to entry point and parse recursively until reaches end
    public String parse(String stringToParse) {
        this.tokenizer = new ManualTokenizer(stringToParse);
        _predictedNextToken = tokenizer.getNextToken();
        return entryPointForProgram();
    }

    /**
     * Main Entry for program
     * <p>
     * Program
     * : NumericalLiteral
     * ;
     *
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
