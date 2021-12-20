package com.amity.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OneNumberRecursiveDescentParserTest {
    private static OneNumberRecursiveDescentParser parser;

    @BeforeAll
    public static void before() {
        parser = new OneNumberRecursiveDescentParser("03");
    }

    @Test
    void singleNumberTest() {
        String ast = parser.parse();
        System.out.println(ast);
        Assertions.assertNotNull(ast);
    }
}
