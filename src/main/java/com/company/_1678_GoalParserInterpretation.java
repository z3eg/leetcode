package com.company;

//https://leetcode.com/problems/goal-parser-interpretation/
public class _1678_GoalParserInterpretation {

    public String interpret(String command) {

        //TODO optimize
        return command.replaceAll("\\(\\)","o").replaceAll("\\(al\\)", "al");
    }
}
