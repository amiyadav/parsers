package com.amity.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PredictiveOneNumberRecursiveDescentParserTest {
    private static PredictiveOneNumberRecursiveDescentParser parser;

    @BeforeAll
    public static void before() {
        parser = new PredictiveOneNumberRecursiveDescentParser();
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

}
