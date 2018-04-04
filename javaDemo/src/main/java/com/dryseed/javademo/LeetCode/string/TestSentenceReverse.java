package com.dryseed.javademo.LeetCode.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 一个句子单词间反序
 */
public class TestSentenceReverse {
    public static void main(String args[]) {
        String sentence = "The quick brown fox jumps over a lazy dog";
        String reverseSentence = reverseSentence2(sentence);
        System.out.println(reverseSentence);
    }

    private static String reverseSentence2(String sentence) {
        String[] words = sentence.split(" ");
        StringBuffer sb = new StringBuffer();
        int size = words.length;
        for (int i = size - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    /*private static String reverseSentence(String sentence) {
        ArrayList<String> words = new ArrayList<>();
        char[] chars = sentence.trim().toCharArray();
        int size = chars.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            if (chars[i] != ' ') {
                sb.append(chars[i]);
            } else {
                words.add(sb.toString());
                sb.setLength(0);
            }
        }

        sb.setLength(0);
        Collections.reverse(words);
        size = words.size();
        for (int i = 0; i < size; i++) {
            sb.append(words.get(i)).append(" ");
        }

        return sb.toString().substring(0, sb.toString().length() - 1);
    }*/
}
