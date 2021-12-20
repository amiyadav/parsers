package com.amity.parser.tokenizer;

import com.amity.parser.model.ASTNode;

import static com.amity.parser.AppConstant.*;

/**
 * Tokenizer fo recursive descent parse
 */
public class ManualTokenizer implements Tokenizer{

    private String _tokenString;
    private int cursor = 0;

    public ManualTokenizer(String _tokenString) {
        this._tokenString = _tokenString;
        this.cursor = 0;
    }

    boolean hasTokensAvailable() {
        return this.cursor < this._tokenString.length();
    }

    @Override
    public ASTNode getNextToken() {
        if (!hasTokensAvailable()) {
            return null;
        }

        char literal = _tokenString.charAt(cursor);

        if (isNumeric(Character.toString(literal))) {
            StringBuilder finalNumberString = new StringBuilder();
            while (hasTokensAvailable()) {
                literal = _tokenString.charAt(cursor);
                finalNumberString.append(literal);
                cursor++;
            }
            return new ASTNode<>(NUMBER, finalNumberString.toString());
        }

        if (ESCAPE_DOUBLE_QUOTES_DELIMITER.equals(Character.toString(literal))) {
            StringBuilder finalString = new StringBuilder();
            //chopped double qoutes
            _tokenString = _tokenString.replace(ESCAPE_DOUBLE_QUOTES_DELIMITER, EMPTY);
            while (hasTokensAvailable()) {
                literal = _tokenString.charAt(cursor);
                String str = Character.toString(literal);
                finalString.append(str);
                cursor++;
            }
            return new ASTNode<>(STRING, finalString.toString());
        }

        return null;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
