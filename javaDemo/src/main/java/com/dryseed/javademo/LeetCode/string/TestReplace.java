package com.dryseed.javademo.LeetCode.string;

/**
 * 实现一个函数，将字符串p中的所有空格都替换成为指定的字符串r。
 */
public class TestReplace {
    public static void main(String args[]) {
        String sentence = "The quick brown fox jumps over a lazy dog he dfd ofdf df he";
        //String reverseSentence = replaceStr(sentence, "o", "123");
        String reverseSentence = replaceStr2(sentence, "he", "123");
        System.out.println(reverseSentence);
    }

    private static String replaceStr(String sentence, String oldChar, String newChar) {
        return sentence.replace(oldChar, newChar);
    }

    private static String replaceStr2(String sentence, String oldChar, String newChar) {
        char[] chars = sentence.toCharArray();
        char[] oldChars = oldChar.toCharArray();
        int num = 0;
        int sentenceSize = chars.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sentenceSize; i++) {
            boolean find = true;
            for (int j = 0; j < oldChars.length; j++) {
                if (oldChars[j] != chars[i + j]) {
                    find = false;
                    break;
                }
            }
            if (find) {
                num++;
                sb.append(newChar);
                i = i + oldChars.length - 1;
            } else {
                sb.append(chars[i]);
            }
        }

        System.out.println("num:" + num);

        return sb.toString();
    }
}
