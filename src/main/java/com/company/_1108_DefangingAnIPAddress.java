package com.company;

//https://leetcode.com/problems/defanging-an-ip-address/
public class _1108_DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.","[.]");
    }
}
