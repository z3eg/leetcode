package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {

    WordDictionary wordDictionary = new WordDictionary();

    @Test
    public void testTaskExample() {
        wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
    @Test
    public void test9() {
        wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a")); //false
        System.out.println(wordDictionary.search(".at")); //false
    }

    @Test
    public void test7() {
        wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("ab");
        assertTrue(wordDictionary.search("a")); //true,
        assertTrue(wordDictionary.search("a.")); //true,
        assertTrue(wordDictionary.search("ab")); //true,
        assertFalse(wordDictionary.search(".a")); //false,
        assertTrue(wordDictionary.search(".b")); //true,
        assertFalse(wordDictionary.search("ab.")); //false,
        assertTrue(wordDictionary.search(".")); //true,
        assertTrue(wordDictionary.search("..")); //true
        /*// System.out.println(wordDictionary.search("a")); //true,
        System.out.println(wordDictionary.search("a.")); //true,
        System.out.println(wordDictionary.search("ab")); //true,
        System.out.println(wordDictionary.search(".a")); //false,
        System.out.println(wordDictionary.search(".b")); //true,
        System.out.println(wordDictionary.search("ab.")); //false,
        System.out.println(wordDictionary.search(".")); //true,
        System.out.println(wordDictionary.search("..")); //true*/
    }

    //https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
    @Test
    public void testfindMaximumXOR() {
//        System.out.println(getDecimalNotation("1010100111"));
//        System.out.println(binaryToDecimal(biggest(decimalToBinary(0), decimalToBinary(0))));
//        System.out.println(binaryToDecimal(biggest(decimalToBinary(9),decimalToBinary(26))));
        /*System.out.println(binaryToString(XOR(decimalToBinary(25), decimalToBinary(20))));
        System.out.println(binaryToString(decimalToBinary(25)));
        System.out.println(binaryToString(decimalToBinary(20)));*/
        assertEquals(28,findMaximumXOR(new int[]{3,10,5,25,2,8}));
        assertEquals(findMaximumXOR(new int[]{14,70,53,83,49,91,36,80,92,51,66,70}),127);
//        assertEquals(findMaximumXOR(),127);
        assertEquals(0,findMaximumXOR(new int[]{14}));
    }

    public int findMaximumXOR(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int biggestXOR = nums[0] ^ nums[nums.length-1];
        for (int i = 0; i < nums.length/2+1; i++) {
            if (nums[i]==nums[i+1]) {
                continue;
            }
            for (int j =0; j < nums.length/2+1; j++) {
                if (nums[nums.length-j-1]==nums[nums.length-j-2]) {
                    continue;
                }
                biggestXOR = Math.max(biggestXOR, nums[i]^nums[nums.length-j-1]);
            }
        }
        return biggestXOR;
    }

    //I just had to try. pretty close, but not exact
    /*public int findMaximumXOR(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        return binaryToDecimal(XOR(decimalToBinary(max),decimalToBinary(min)));
    }*/

    //better, but still time limit exceeded
    /*public int findMaximumXOR(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        Deque<Boolean> biggestXOR = XOR(decimalToBinary(nums[0]), decimalToBinary(nums[1]));
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i!=j) {
                    Deque<Boolean> xor = XOR(decimalToBinary(nums[i]), decimalToBinary(nums[j]));
                    biggestXOR = biggest(biggestXOR, xor);
                }
            }
        }
        return binaryToDecimal(biggestXOR);
    }*/

    public Boolean XOR(Boolean b1, Boolean b2) {
        return b1 != b2;
    }

    public Deque<Boolean> XOR(Deque<Boolean> n1, Deque<Boolean> n2) {
        LinkedList<Boolean> res = new LinkedList<>();
        Deque<Boolean> longest = n2;
        Deque<Boolean> shortest = n1;
        if (n1.size() > n2.size()) {
            longest = n1;
            shortest = n2;
        }
        Iterator<Boolean> longestIt = longest.descendingIterator();
        Iterator<Boolean> shortestIt = shortest.descendingIterator();
        while (shortestIt.hasNext()) {
            res.addFirst(XOR(shortestIt.next(),longestIt.next()));
        }
        while (longestIt.hasNext()) {
            res.addFirst(longestIt.next());
        }
        return res;
    }

    private Deque<Boolean> biggest(Deque<Boolean> n1, Deque<Boolean> n2) {
        if (n1.size() > n2.size()) {
            return n1;
        }
        if (n2.size() > n1.size()) {
            return n2;
        }
        Iterator<Boolean> n1Iterator = n1.iterator();
        Iterator<Boolean> n2Iterator = n2.iterator();
        while (n1Iterator.hasNext()) {
            Boolean curN1 = n1Iterator.next();
            Boolean curN2 = n2Iterator.next();
            if (curN1!=curN2) {
                return curN1 ? n1 : n2;
            }
        }
        return n1;
    }

    private Deque<Boolean> decimalToBinary(int n) {
        Deque<Boolean> decimalNotation = new LinkedList<>();
        while (n>=1) {
            decimalNotation.addFirst(n%2!=0);
            n/=2;
        }
        return decimalNotation;
    }

    private int binaryToDecimal(Deque<Boolean> binary) {
        int res = 0;
        int pow = 0;
        Boolean isOne = binary.pollLast();
        while (isOne != null) {
            res += isOne ? Math.pow(2,pow) : 0;
            pow++;
            isOne = binary.pollLast();
        }
        return res;
    }

    private String binaryToString(Deque<Boolean> binaryNotation) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Boolean isOne : binaryNotation) {
            stringBuilder.append(isOne ? '1' : '0');
        }
        return stringBuilder.toString();
    }

    //string-based binary implementation, extremely inefficient
    /*public int findMaximumXOR(int[] nums) {
        Set<String> XORs = new TreeSet<String>((n1, n2) -> {
            if (n1.length()>n2.length()) {
                return -1;
            }
            if (n1.length()<n2.length()) {
                return 1;
            }
            for (int i = 0; i < n1.length(); i++) {
                char n1CurChar = n1.charAt(i);
                char n2CurChar = n2.charAt(i);
                if (n1CurChar != n2CurChar) {
                    if (n1CurChar=='1')
                        return -1;
                    return 1;
                }
            }
            return 0;
        });
        for (int j : nums) {
            for (int num : nums) {
                XORs.add(findXOR(getBinaryNotation(j), getBinaryNotation(num)));
            }
        }
        return getDecimalNotation(XORs.iterator().next());
    }

    private int getDecimalNotation(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='1') {
                res+=Math.pow(2,(s.length()-1)-i);
            }
        }
        return res;
    }

    private String findXOR(String n1, String n2) {
        String longest;
        String shortest;
        if (n1.length() > n2.length()) {
             longest = n1;
             shortest = n2;
        }
        else {
            longest = n2;
            shortest = n1;
        }
        int diff = longest.length() - shortest.length();
        String unchanged = longest.substring(0, diff);
        StringBuilder stringBuilder = new StringBuilder(unchanged);
        for (int i = 0; i < shortest.length(); i++) {
            if (shortest.charAt(i) == longest.charAt(i+diff)) {
                stringBuilder.append("0");
            }
            else {
                stringBuilder.append("1");
            }
        }
        return stringBuilder.toString();
    }

    private String getBinaryNotation(int number) {
        StringBuilder sb = new StringBuilder();
        while (number >= 1) {
            sb.append(number%2);
            number/=2;
        }
        String s = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            sb2.append(s.charAt(i));
        }
        return sb2.toString();
    }*/


//    https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void elementsInTrees() {
        //case 1
        TreeNode root1 = new TreeNode(2);
        root1.left =  new TreeNode(1);
        root1.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.left =  new TreeNode(0);
        root2.right = new TreeNode(3);
        //case 2
        /*TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(8);
        TreeNode root2 = new TreeNode(8);
        root2.left =  new TreeNode(1);*/
        LinkedList<Integer> integers = new LinkedList<>();
        addElements(root1,root2,integers);
        System.out.println(integers);
        /*List<Integer> allElements = getAllElements(root1, root2);
        System.out.println(allElements);*/
    }
    private void addElements(TreeNode root, LinkedList<Integer> numbers) {
        if (root!=null) {
            if (root.left!=null) {
                addElements(root.left, numbers);
            }
            if (root.right!=null) {
                addElements(root.right, numbers);
            }
            numbers.add(root.val);
        }
    }

    private void insert(TreeNode what, TreeNode node) {
        if (what.val < node.val) {
            if (node.left != null) {
                node = node.left;
                insert(what, node);
            }
            else {
                node.left = what;
            }
        }
        else {
            if (node.right != null) {
                node = node.right;
                insert(what, node);
            }
            else {
                node.right = what;
            }
        }
    }

    private void addElements(TreeNode root1, TreeNode root2, LinkedList<Integer> numbers) {
        /*if (root1.val < root2.val) {
            insert(root2, root1);
            addElements(root1,numbers);
        }
        else {*/
            insert(root1, root2);
            addElements(root2,numbers);
//        }
    }


//    https://leetcode.com/problems/valid-mountain-array/
    @Test
    public void validMountainArray() {
        assertFalse(validMountainArray(new int[]{2,1}));
        assertFalse(validMountainArray(new int[]{3,5,5}));
        assertFalse(validMountainArray(new int[]{0,1,2,3,4,5,6,7,8,9}));
        assertTrue(validMountainArray(new int[]{0,3,2,1}));
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        else {
            int i =0;
            while (i<arr.length-1 && arr[i]<arr[i+1]) {
                i++;
            }
            if (i==0 || i==arr.length-1) {
                return false;
            }
            else {
                while (i < arr.length-1) {
                    if (arr[i] <= arr[i+1]) {
                        return false;
                    }
                    i++;
                }
            }
        }
        return true;
    }


    //https://leetcode.com/problems/detect-capital/
    @Test
    public void detectCapital() {
        assertTrue(detectCapitalUse("USA"));
        assertFalse(detectCapitalUse("FlaG"));
        assertTrue(detectCapitalUse("leetcode"));
        assertTrue(detectCapitalUse("Google"));
    }

    public boolean detectCapitalUse(String word) {
        if (word.length()==1) {
            return true;
        }
        char c = word.charAt(0);
        if (Character.isLowerCase(c)) {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        else {
            c = word.charAt(1);
            if (Character.isLowerCase(c)) {
                for (int i = 1; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }
            }
            else {
                for (int i = 1; i < word.length(); i++) {
                    if (Character.isLowerCase(word.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
