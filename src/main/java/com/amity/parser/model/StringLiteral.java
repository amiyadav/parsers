package com.amity.parser.model;

import com.amity.parser.AppConstant;
import com.amity.parser.tokenizer.Tokenizer;

/**
 * String literla
 */
public class StringLiteral implements Literal<String> {
    String value;

    public StringLiteral(ASTNode<String> predictedToken, Tokenizer tokenizer) {
        value = digest(predictedToken, AppConstant.STRING, tokenizer);
    }

    /**
     *
     * @return value after digest
     */
    @Override
    public String getValue() {
        return value;
    }
}

