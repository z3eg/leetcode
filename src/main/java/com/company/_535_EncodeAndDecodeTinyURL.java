package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

//https://leetcode.com/problems/encode-and-decode-tinyurl/
public class _535_EncodeAndDecodeTinyURL {

    public class Codec {

        Map<String, String> hashMap = new HashMap<>();

        private int counter = 0;

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (!hashMap.containsKey(longUrl)) {
                String shortUrl = Integer.toHexString(counter);
                hashMap.put(longUrl,shortUrl);
                counter++;
                return shortUrl;
            }
            else
                return hashMap.get(longUrl);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return hashMap.entrySet()
                    .stream()
                    .filter(entry -> Objects.equals(entry.getValue(), shortUrl))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList()).get(0);
        }
    }
}
