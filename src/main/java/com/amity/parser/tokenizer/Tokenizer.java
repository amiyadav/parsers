package com.amity.parser.tokenizer;

import com.amity.parser.model.ASTNode;

public interface Tokenizer {

    ASTNode getNextToken();

}
