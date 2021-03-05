package com.lm.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode-0030 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * level 2 94.53%
 * @author limin
 * @date 2021/2/28
 */
public class Code0030FindSubstringTest {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> r = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        int size = words.length;
        int wordLen = words[0].length();
        for (int offset = 0; offset < wordLen; offset++) {
            Map<String, Integer> subMap = new HashMap<>();
            for (int start = offset, last = offset; last <= s.length() - wordLen; last += wordLen) {
                String word = s.substring(last, last + wordLen);
                if (!wordsMap.containsKey(word)) {
                    subMap.clear();
                    start = last + wordLen;
                    continue;
                }
                int count = subMap.getOrDefault(word, 0);
                if (count >= wordsMap.get(word)) {
                    for (; ; ) {
                        String delete = s.substring(start, start + wordLen);
                        start += wordLen;
                        int cnt = subMap.get(delete);
                        if (cnt == 1) {
                            subMap.remove(delete);
                        } else {
                            subMap.put(delete, cnt - 1);
                        }
                        if (delete.equals(word)) {
                            break;
                        }
                    }
                    count--;
                }
                subMap.put(word, count + 1);
                int wordCount = (last - start) / wordLen + 1;
                if (wordCount == size) {
                    r.add(start);
                }
            }
        }
        return r;
    }
}
