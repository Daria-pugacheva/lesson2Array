package ru.gb.pugacheva.lesson5;

import java.util.LinkedHashSet;
import java.util.Set;

public class Anagram {

    private char[] chars;
    private Set <String > result = new LinkedHashSet<>();

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        Set <String> anagrams =  anagram.findAll("cat");
        System.out.println(anagrams);
    }

    private Set <String> findAll (String word){
        result.clear();
        this.chars=word.toCharArray();
        find (chars.length);
        return result;
    }

    private void find (int length){
        if (length==1){
            return;
        }

        for (int i = 0; i < length; i++) {
            find(length-1);
            result.add(String.valueOf(chars));
            rotate (length);
        }
    }

    private void rotate(int length){
        int position = chars.length-length;
        char temp = chars[position];
        for (int i = position+1; i < chars.length; i++) {
            chars[i-1] = chars[i];
        }
        chars[length-1]=temp;
    }
}

