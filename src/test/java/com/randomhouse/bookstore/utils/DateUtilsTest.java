package com.randomhouse.bookstore.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class DateUtilsTest {


    @Test
    void testCompare(){

      assertEquals("10-12-2019", DateUtils.compareDates("10-12-2019","12-10-2019"));

    }

    @Test
    void testCompare2(){

        assertEquals("21-03-2022", DateUtils.compareDates("10-12-2019","21-03-2022"));

    }

}
