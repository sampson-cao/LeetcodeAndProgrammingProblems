import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class wordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {

        Map<String, Boolean> validMatches = new HashMap<>();
        List<Boolean> validWordAtIdx = new ArrayList<>();
        Set<String> matches = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {

            boolean found = false;
            for (int j = i + 1; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                //System.out.println(substring);
                for (String word : wordDict) {
                    if (substring.equals(word)) {

                        found = true;
                        validMatches.put(word, true);
                        matches.add(word);

                    }
                }
            }
            validWordAtIdx.add(found);
        }
        System.out.println(validMatches);
        System.out.println(validWordAtIdx);
        System.out.println(matches);

        return true;
    }

    public static boolean findSubstrings(String s, List<String> wordDict, int startIdx, int endIdx) {

        Map<String, Boolean> validMatches = new HashMap<>();
        Set<String> matches = new HashSet<>();
        for (int i = startIdx; i < endIdx; i++) {
            String substring = s.substring(startIdx, i + 1);
            //System.out.println(substring);
            for (String word : wordDict) {
                if (substring.equals(word)) {
                    validMatches.put(word, true);
                    matches.add(word);

                }
            }
        }
        return false;
        //return validMatches;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("aaaaaaa", List.of("aaaa", "aa")));
        //System.out.println(wordBreak("leetcode", List.of("leet", "code")));
        //System.out.println(wordBreak("a", List.of("b")));
        System.out.println(wordBreak("applepenapple", List.of("apple", "pen")));
    }

    public static boolean recursiveWordBreak(String target, List<String> wordDict, String workingWord) {

        String temp = workingWord;
        boolean found = true;
        for (String word : wordDict) {
            System.out.println("Testing word " + word + " working word " + workingWord);

            temp = workingWord.concat(word);
            if (target.equals(temp)) {
                System.out.println("Match found");
                return true;
            }

            if (target.startsWith(temp)) {
                if (recursiveWordBreak(target, wordDict, temp)) {
                    return true;
                }
            }
            else {
                found = false;
            }

        }

        if (!target.equals(temp)) {
            return false;
        }

        return found;
    }

    public static boolean recursiveWordBreakFail(String workingWord, List<String> wordDict) {
        System.out.println("Checking word matches for " + workingWord + " with " + wordDict);

        // removed in the split so it's found by default
        if (workingWord.isEmpty()) {
            System.out.println("Working word is empty, true by default");
            return true;
        }

        boolean matchForCurrentWord = false;

        for (String wordDictEntry : wordDict) {
            System.out.println("wordDictEntry " + wordDictEntry + " for " + workingWord);
            if (workingWord.length() < wordDictEntry.length()) {
                continue;
            }

            if (workingWord.equals(wordDictEntry)) {
                System.out.println("Found exact match " + workingWord);
                matchForCurrentWord = true;
                break;
            }

            if (workingWord.startsWith(wordDictEntry) && recursiveWordBreakFail(workingWord.substring(wordDictEntry.length()), wordDict)) {
                matchForCurrentWord = true;
            }

        }

        System.out.println(matchForCurrentWord);
        return matchForCurrentWord;
    }
}
