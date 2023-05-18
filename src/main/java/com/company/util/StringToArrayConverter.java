package com.company.util;

public class StringToArrayConverter {

    public static String[] convert(String arrayString) {
//        [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        arrayString = arrayString.replaceAll("\\[","");
        arrayString = arrayString.replaceAll("]","");
        return arrayString.split(",");
    }

}
