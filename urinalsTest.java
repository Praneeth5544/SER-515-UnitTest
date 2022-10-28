package org.example;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {
    urinals u=new urinals();

    @org.junit.jupiter.api.Test
    void countUrinals() {
        assertEquals(2,u.countUrinals("10000"));
        assertEquals(0,u.countUrinals("1001"));
        assertEquals(3,u.countUrinals("00000"));
        assertEquals(2,u.countUrinals("0000"));
        assertEquals(1,u.countUrinals("01000"));
        assertEquals(-1,u.countUrinals("011"));
    }

    @org.junit.jupiter.api.Test
    void goodString() {
        assertEquals(true,u.goodString("10000"));
        assertEquals(false,u.goodString("1081"));
        assertEquals(true,u.goodString("00000"));
    }
}