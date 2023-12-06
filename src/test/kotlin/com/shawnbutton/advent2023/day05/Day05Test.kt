package com.shawnbutton.advent2023.day05

import com.shawnbutton.advent2023.loadFile
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day05Test {

    val lines = loadFile("/day05_sample.txt");

    @Test
    fun `should get planted seeds`() {
        assertEquals(getSeeds(lines), listOf(79, 14, 55, 13));
    }


    fun `should make range map`() {
        val range = makeRange("50 98 2");

        assertEquals(range, RangeMap(98, 99, -48));
    }


    /**///
//            describe('should convert from source to destination', () => {
//                fun 'should convert when found in range'() {
//                    val sut = new Advent();
//
//                    assertEquals(sut.transform(sut.makeRangeM(), 98)).toEqual(50)
//                });
//            });
//
//            fun 'should get various structures'() {
//                // val maps = sut.parseMaps(lines);
//                // assertEquals(maps).
//            });
//        });
//    });


}
