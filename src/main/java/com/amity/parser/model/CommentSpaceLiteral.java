package com.amity.parser.model;

import com.amity.parser.AppConstant;
import com.amity.parser.tokenizer.Tokenizer;

/**
 * Comment Literal class for digesting  comments
 */
public class CommentSpaceLiteral implements Literal<String> {

    String value;

    public CommentSpaceLiteral(ASTNode<String> predictedToken, Tokenizer tokenizer) {
        value = digest(predictedToken, AppConstant.COMMENTS, tokenizer);
    }

    @Override
    public String getValue() {
        return null;
    }
}
