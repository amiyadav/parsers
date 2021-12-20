package com.amity.parser.specs;

import com.amity.parser.AppConstant;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Regex pattern specification for parser
 */
public class PatternSpecifications {
    final static String COMMENTS_PATTERN =
            "((['\"])(?:(?!\\2|\\\\).|\\\\.)*\\2)|\\/\\/[^\\n]*|\\/\\*(?:[^*]|\\*(?!\\/))*\\*\\/";

    public static final Map<String, String> PATTERN_SPECS = new LinkedHashMap<>() {{
        // String
        put("^\"[^\"]*\"", AppConstant.STRING);
        // Numbers
        put("\\d+", AppConstant.NUMBER);
        // single line comment
        put(COMMENTS_PATTERN, AppConstant.NULL);
        // whitespace (greedy matching of all space in contiguous memory)
        put("\\s+", AppConstant.NULL);
    }};


//    /**
//     *
//     * @param args
//     */
//    public static void main(String[] args) {
//
//        System.out.println(Pattern.compile("\\d+").matcher("45").matches());
//        System.out.println(Pattern.compile("^\"[^\"]*\"").matcher("\"aaa\"").matches());
//
//        System.out.println(Pattern.compile(COMMENTS_PATTERN).matcher("/**\n" +
//                "     *\n" +
//                "     * @param args\n" +
//                "     */").matches());
//
////         comment
//        System.out.println(Pattern.compile(COMMENTS_PATTERN).matcher("// comment \n" +
//                " \"string\"").matches());
//
//        System.out.println(Pattern.compile(COMMENTS_PATTERN).matcher(" \"hello\" ").matches());
//    }
}
