package org.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class URLifyTest {

    private URLify urLify;

    @BeforeEach
    public void setUp() {
        urLify = new URLify();
    }

    @Test
    public void test1() {
        String s = "Mr John Smith    ";
        assertEquals("Mr%20John%20Smith", urLify.urLify(s, 13));
    }

    @Test
    public void test2() {
        String s = "Mr John  Smith      ";
        assertEquals("Mr%20John%20%20Smith", urLify.urLify(s, 14));
    }

    @Test
    public void test1urLify2() {
        String s = "Mr John Smith    ";
        assertEquals("Mr%20John%20Smith", urLify.urLify2(s, 13));
    }

    @Test
    public void test2urLify2() {
        String s = "Mr John  Smith      ";
        assertEquals("Mr%20John%20%20Smith", urLify.urLify2(s, 14));
    }
}
