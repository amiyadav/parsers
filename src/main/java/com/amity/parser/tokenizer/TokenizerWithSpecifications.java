package com.amity.parser.tokenizer;

import com.amity.parser.AppConstant;
import com.amity.parser.specs.PatternSpecifications;
import com.amity.parser.exceptions.ParserError;
import com.amity.parser.model.ASTNode;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenizerWithSpecifications implements Tokenizer {

    private String _tokenString;
    private int cursor = 0;

    public TokenizerWithSpecifications(String _tokenString) {
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
        String literals = _tokenString.substring(cursor);
        String tokenValue = "";
        String tokenType = "";
        //
        for (Map.Entry<String, String> entry : PatternSpecifications.PATTERN_SPECS.entrySet()) {
          tokenValue = match(entry.getKey(), literals);
          tokenType = entry.getValue();
          if(tokenValue == null){
              continue;
          }
          if(tokenType.equals(AppConstant.NULL)){
              return getNextToken();
          }
          return new ASTNode(tokenType, tokenValue);
//            if (!hasTokensAvailable()) {
//                break;
//            }
//            CharSequence literals = _tokenString.substring(cursor);
//
//            Matcher matcher = Pattern.compile(entry.getKey()).matcher(literals);
//
//            if (matcher.find()) {
//                tokenValue = matcher.group();
//                tokenType = entry.getValue();
//                if (tokenType.equals("")) {
//                    throw new ParserError(500, " not matched type in parser string");
//                }
//            }
//
//            //if pattern is comment ignore and continue for next token
//            if (tokenType.equals(AppConstant.COMMENTS)) {
//                cursor = matcher.end();
//                tokenValue = "";
//                continue;
//            }
//            //if pattern whitespace ignore
//            if (tokenType.equals(AppConstant.NULL)) {
//                cursor += 1;
//            }


        }

        throw new ParserError(500, " not matched type in parser string");

//        return new ASTNode<>(tokenType, tokenValue);
    }

    /**
     * @param regExp
     * @param string
     * @return
     */
    String match(String regExp, String string) {
        Matcher matcher = Pattern.compile(regExp).matcher(string);
        if (matcher.find()) {
            this.cursor += matcher.group(0).length();
            return matcher.group(0);
        } else {
            return null;
        }
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
