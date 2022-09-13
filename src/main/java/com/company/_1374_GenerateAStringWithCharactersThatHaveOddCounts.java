package com.company;

public class _1374_GenerateAStringWithCharactersThatHaveOddCounts {
    public String generateTheString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a".repeat(Math.max(0, n)));
        if (n%2==0)
            stringBuilder.replace(n-2,n-1,"b");
        return stringBuilder.toString();
    }
}
