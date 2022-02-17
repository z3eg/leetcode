package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

//https://leetcode.com/problems/word-ladder/
public class _127_WordLadder_TREE_LAYER_BY_LAYER {

    //BUILD A TREE LEVEL BY LEVEL (WITHOUT RECURSION PERHAPS)
    private class Node {
        public String val;
        public List<String> wordList;

        public Node(String val) {
            this.val = val;
        }

        public Node(String val, List<String> wordList) {
            this.val = val;
            this.wordList = wordList;
        }
    }

    //stolen here: https://leetcode.com/problems/word-ladder/discuss/1764371/A-very-highly-detailed-EXPLANATION
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        queue.add(beginWord);

        int changes = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                if(word.equals(endWord)) return changes;

                for(int j = 0; j < word.length(); j++){
                    for(int k = 'a'; k <= 'z'; k++){
                        char arr[] = word.toCharArray();
                        arr[j] = (char) k;

                        String str = new String(arr);
                        if(set.contains(str) && !visited.contains(str)){
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            ++changes;
        }
        return 0;
    }

    public int laddersLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        wordList.remove(beginWord);
        Node root = new Node(beginWord, wordList);
        Set<Node> bottomLevel = new HashSet<>();
        List<String> newNodeWordList;
        bottomLevel.add(root);
        int levels = 1;
        boolean stillBuilding = true;
        while (stillBuilding) {
            stillBuilding = false;
            levels++;
            Set<Node> newBottomLevel = new HashSet<>();
            for (Node node: bottomLevel) {
                List<String> nodeWordList = node.wordList;
                nodeWordList.remove(node.val);
                for (String word: nodeWordList) {
                    if (wordsCanTransit(word, node.val) /*&& isNotWorse(word, node.val, endWord)*/) {
                        if (word.equals(endWord)) {
                            return levels;
                        }
                        stillBuilding = true;
                        newNodeWordList = new LinkedList<>(nodeWordList);
                        newNodeWordList.remove(word);
                        Node newNode = new Node(word, newNodeWordList);
                        newBottomLevel.add(newNode);
                    }
                }
            }
            bottomLevel = newBottomLevel;
        }
        return 0;
    }

    private boolean isNotWorse(String s1, String s2, String example) {
        return countMatches(s1,example)>=countMatches(s2,example);
    }

    private int countMatches(String s1, String s2) {
        if (s1.length()!=s2.length()) {
            return 0;
        }
        int matchCounter = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i)==s2.charAt(i)) {
                matchCounter++;
            }
        }
        return matchCounter;
    }

    private boolean wordsCanTransit(String s1, String s2) {
        return (countMatches(s1,s2)==s1.length()-1);
    }

    @Test
    public void testWordsCanTransit() {
        assertTrue(wordsCanTransit("miss","mist"));
        assertTrue(wordsCanTransit("mist","miss"));
        assertTrue(wordsCanTransit("hit","hot"));
        assertTrue(wordsCanTransit("hot","dot"));
        assertTrue(wordsCanTransit("dog","dot"));
        assertFalse(wordsCanTransit("dog","lot"));
        assertTrue(wordsCanTransit("dog","log"));
        assertTrue(wordsCanTransit("dog","cog"));
        assertTrue(wordsCanTransit("log","cog"));
    }


    @Test
    public void testBuild() {
        List<String> wordList = new ArrayList<>(Arrays.asList("sq"
                , "go", "se", "cm", "so", "ph", "mt", "db", "mb"
                , "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo"
                , "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt"/*
                , "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz"
                , "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc"
                , "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq"
                , "ye"*/));
        System.out.println(wordList.size());
        wordList.remove("qa");
        Node globalRoot = new Node("qa");
//        buildATree(globalRoot, wordList, "sq");
    }

    @Test
    public void test() {
        ArrayList<String> wordList25 = new ArrayList<>(Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"));
        System.out.println(wordList25.size());
        assertNotEquals(987, ladderLength("cet", "ism", wordList25));

        assertNotEquals(987, ladderLength("hit", "cog",
                new LinkedList<>(Arrays.asList("hot","dot","tog","cog"))));
//        assertNotEquals(3,ladderLength("hot","dog", new ArrayList<>(Arrays.asList("hot","dog","vay"))));
        //TLE
        /*HashSet<String> stringsSet = new HashSet<>(stringsList);
        assertEquals(stringsSet.size(),stringsList.size());*/
        /*ArrayList<String> wordList = new ArrayList<>(Arrays.asList("si"
                , "go", "se", "cm", "so", "ph", "mt", "db", "mb"
                , "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo"
                , "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt"
                , "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz"
                , "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc"
                , "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq"
                , "ye"));*/
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList("sq"
                , "go", "se", "cm", "so", "ph", "mt", "db", "mb"
                , "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo"
                , "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt"
                , "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz"
                , "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc"
                , "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq"
                , "ye"));
//        System.out.println(wordList.size());
        assertNotEquals(987, ladderLength("qa", "sq", wordList));
        assertEquals(0,ladderLength("hit","cog", new LinkedList<>(Arrays.asList("hot","dot","dog","lot","log"))));
        assertEquals(3,ladderLength("hot","dog", new ArrayList<>(Arrays.asList("hot","dog","dot"))));
        assertEquals(2,ladderLength("a","c", new ArrayList<>(Arrays.asList("a","b","c"))));
        assertEquals(6,ladderLength("leet","code",
                new ArrayList<>(Arrays.asList("lest","leet","lose","code","lode","robe","lost"))));
        assertEquals(4,ladderLength("lost","miss",
                new ArrayList<>(Arrays.asList("most","mist","miss","lost","fist","fish"))));
        assertEquals(5,ladderLength("hit","cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }

    /*private int findShortestPath(int i, Node root, String stopWord) {
        if (root!=null) {
            if (root.val.equals(stopWord)) {
                return i;
            }
            else {
                for (Node child : root.children) {
                    i++;
                    return findShortestPath(i, child, stopWord);
                }
            }
        }
        return i;
    }*/

    //actually working whole tree, but i need to stop if i reach stopWord
    /*private void buildATree(Node root, List<String> wordList) {
        for (String word : wordList) {
            if (mapsCanTransit(getFrequencyMap(root.val), getFrequencyMap(word))) {
                Node child = new Node(word);
                root.children.add(child);
                List<String> newList = new LinkedList<>(wordList);
                newList.remove(word);
                buildATree(child, newList);
            }
        }
//        return root;
    }*/

    /*Example 1:

    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    Output: 5
    Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
    Example 2:

    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    Output: 0
    Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.*/
}
