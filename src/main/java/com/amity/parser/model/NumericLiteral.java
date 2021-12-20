package com.amity.parser.model;

import com.amity.parser.AppConstant;
import com.amity.parser.tokenizer.ManualTokenizer;
import com.amity.parser.tokenizer.Tokenizer;

/**
 * Numeric literal
 */
public class NumericLiteral implements Literal<String> {
    String value;

    public NumericLiteral(ASTNode<String> predictedToken, Tokenizer tokenizer) {
        value = digest(predictedToken, AppConstant.NUMBER, tokenizer);
    }

    /**
     * result after processing numeric literal
     *
     * @return numeric literal
     */
    @Override
    public String getValue() {
        return value;
    }
}
