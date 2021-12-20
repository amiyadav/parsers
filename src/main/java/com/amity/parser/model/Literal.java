package com.amity.parser.model;

import com.amity.parser.exceptions.ParserError;
import com.amity.parser.tokenizer.Tokenizer;

/**
 * Represents any literal and digest/process
 *
 * @param <T>
 */
public interface Literal<T> {


    String getValue();

    /**
     * Digest the string
     *
     * @param predictedToken predicted next token
     * @param tokenType      type of the token
     * @param tokenizer      tokenizer to break tokens
     * @return type
     */
    default T digest(ASTNode<T> predictedToken, String tokenType, Tokenizer tokenizer) {
        if (null == predictedToken.getValue()) {
            throw new ParserError(500, "token is empty");
        }
        if (!predictedToken.getType().equals(tokenType)) {
            throw new ParserError(500, "un-expected token type" + tokenType);
        }
        return predictedToken.getValue();
    }
}
