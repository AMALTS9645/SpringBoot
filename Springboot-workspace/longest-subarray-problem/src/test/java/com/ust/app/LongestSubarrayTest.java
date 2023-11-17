package com.ust.app;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongestSubarrayTest {

    @Test
    public void testLongestSubarray1() {
        int[] array = {1, 2, -5, 4, 5, -6, 7, 8};
        int[] expectedSubarray = {4, 5, -6, 7, 8};
        int expectedStartIndex = 3;
        int expectedEndIndex = 7;

        LongestSubarray longestSubarray = new LongestSubarray();
        SubarrayResult result = longestSubarray.findLongestSubarray(array);

        assertArrayEquals(expectedSubarray, result.getSubarray());
        assertEquals(expectedStartIndex, result.getStartIndex());
        assertEquals(expectedEndIndex, result.getEndIndex());
    }

    @Test
    public void testLongestSubarray2() {
        int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] expectedSubarray = {4, -1, -2, 1, 5};
        int expectedStartIndex = 2;
        int expectedEndIndex = 6;

        LongestSubarray longestSubarray = new LongestSubarray();
        SubarrayResult result = longestSubarray.findLongestSubarray(array);

        assertArrayEquals(expectedSubarray, result.getSubarray());
        assertEquals(expectedStartIndex, result.getStartIndex());
        assertEquals(expectedEndIndex, result.getEndIndex());
    }

    @Test
    public void testLongestSubarray3() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expectedSubarray = {1, 2, 3, 4, 5};
        int expectedStartIndex = 0;
        int expectedEndIndex = 4;

        LongestSubarray longestSubarray = new LongestSubarray();
        SubarrayResult result = longestSubarray.findLongestSubarray(array);

        assertArrayEquals(expectedSubarray, result.getSubarray());
        assertEquals(expectedStartIndex, result.getStartIndex());
        assertEquals(expectedEndIndex, result.getEndIndex());
    }

    @Test
    public void testLongestSubarray4() {
        int[] array = {-1, -2, -3, -4, -5};
        int[] expectedSubarray = {-1};
        int expectedStartIndex = 0;
        int expectedEndIndex = 0;

        LongestSubarray longestSubarray = new LongestSubarray();
        SubarrayResult result = longestSubarray.findLongestSubarray(array);

        assertArrayEquals(expectedSubarray, result.getSubarray());
        assertEquals(expectedStartIndex, result.getStartIndex());
        assertEquals(expectedEndIndex, result.getEndIndex());
    }

    @Test
    public void testLongestSubarray5() {
        int[] array = {2, -1, 3, -4, 2, 1};
        int[] expectedSubarray = {2, -1, 3};
        int expectedStartIndex = 0;
        int expectedEndIndex = 2;

        LongestSubarray longestSubarray = new LongestSubarray();
        SubarrayResult result = longestSubarray.findLongestSubarray(array);

        assertArrayEquals(expectedSubarray, result.getSubarray());
        assertEquals(expectedStartIndex, result.getStartIndex());
        assertEquals(expectedEndIndex, result.getEndIndex());
    }

    @Test
    public void testLongestSubarray6() {
        int[] array = {0, 0, 0, 0, 0};
        int[] expectedSubarray = {0, 0, 0, 0, 0};
        int expectedStartIndex = 0;
        int expectedEndIndex = 4;

        LongestSubarray longestSubarray = new LongestSubarray();
        SubarrayResult result = longestSubarray.findLongestSubarray(array);

        assertArrayEquals(expectedSubarray, result.getSubarray());
        assertEquals(expectedStartIndex, result.getStartIndex());
        assertEquals(expectedEndIndex, result.getEndIndex());
    }

    @Test
    public void testLongestSubarrayEmptyArray() {
        int[] array = {};
        int[] expectedSubarray = {};
        int expectedStartIndex = -1; // or any invalid value
        int expectedEndIndex = -1; // or any invalid value

        LongestSubarray longestSubarray = new LongestSubarray();
        SubarrayResult result = longestSubarray.findLongestSubarray(array);

        assertArrayEquals(expectedSubarray, result.getSubarray());
        assertEquals(expectedStartIndex, result.getStartIndex());
        assertEquals(expectedEndIndex, result.getEndIndex());
    }
}

