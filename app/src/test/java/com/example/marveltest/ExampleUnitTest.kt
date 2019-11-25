package com.example.marveltest

import org.junit.Test

import org.junit.Assert.*
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun zoned_datetime_test() {
        val d = DateTimeFormatter.ofPattern("MMM dd, YYYY")
        val z = ZonedDateTime.parse("2019-11-30T00:00:00Z")
        System.out.println(z.format(d))
    }
}
