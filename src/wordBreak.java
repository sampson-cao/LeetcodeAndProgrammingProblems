import java.util.Arrays;
import java.util.List;

public class wordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {

        return recursiveWordBreak(new String[] {s}, wordDict);
    }

    public static boolean recursiveWordBreak(String[] workingWords, List<String> wordDict) {
        System.out.println("Checking word matches for " + Arrays.toString(workingWords) + " with " + wordDict);

        if (workingWords.length == 0) {
            System.out.println("match by default");
            return true;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            for (String workingWord : workingWords) {
                if (workingWord.isEmpty())
                    continue;
                System.out.println("Checking " + workingWord + " with " + wordDict.get(i));
                if (workingWord.contains(wordDict.get(i))) {
                    System.out.println("Found " + wordDict.get(i) + " in " + workingWord);
                    if (recursiveWordBreak(workingWord.split(wordDict.get(i)), wordDict)) {
                        return true;
                    }
                }
                else {
                    System.out.println(wordDict + " was not found in " + workingWord );
                    return false;
                }
            }
        }
        System.out.println("Found valid match");
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("catsandog", List.of("cats","dog","sand","and","cat")));
    }
}
