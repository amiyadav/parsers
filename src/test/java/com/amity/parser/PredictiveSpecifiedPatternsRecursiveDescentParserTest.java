package com.amity.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 */
public class PredictiveSpecifiedPatternsRecursiveDescentParserTest {
    private static PredictiveSpecifiedPatternsRecursiveDescentParser parser;

    @BeforeAll
    public static void before() {
        parser = new PredictiveSpecifiedPatternsRecursiveDescentParser();
    }

    @Test
    void singleNumberTest() {
        String ast = parser.parse("03");
        System.out.println(ast);
        Assertions.assertNotNull(ast);
    }

    @Test
    void singleStringTest() {
        String ast = parser.parse("\"hello\"");
        System.out.println(ast);
        Assertions.assertNotNull(ast);
    }

    @Test
    void singleNumberWithSpaceTest() {
        String ast = parser.parse(" 03 ");
        System.out.println(ast);
        Assertions.assertNotNull(ast);
    }

    @Test
    void multiLineCommentWithStringTest() {
        String ast = parser.parse("/**\n" +
                "     *\n" +
                "     * @param args\n" +
                "     */ 03 ");
        System.out.println(ast);
        Assertions.assertNotNull(ast);
    }

    @Test
    void singleLineCommentWithTest() {
        String ast = parser.parse("// comment 03");
        System.out.println(ast);
        Assertions.assertNotNull(ast);
    }

    @Test
    void singleLineCommentWithStringTest() {
        String ast = parser.parse("// comment 03 \n \"hey ami\"");
        System.out.println(ast);
        Assertions.assertNotNull(ast);
    }

    @Test
    void singleLineCommentWithNumberTest() {
        String ast = parser.parse("// comment 03 \n 12345");
        System.out.println(ast);
        Assertions.assertNotNull(ast);
    }

    @Test
    void singleStringSpaceTest() {
        String ast = parser.parse(" \"hello\" ");
        System.out.println(ast);
        Assertions.assertNotNull(ast);
    }
}
