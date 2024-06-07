package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        return "";
    }

    @Test
    public void test() {
        assertEquals("the cat was rat by the bat", replaceWords(Arrays.asList("cat","bat","rat"), "the cattle was rattled by the battery"));
        assertEquals("a a b c", replaceWords(Arrays.asList("a","b","c"), "aadsfasf absbs bbab cadsfafs"));
    }

}
