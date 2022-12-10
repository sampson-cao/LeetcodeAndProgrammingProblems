import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {

		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		int[] set1 = new int[s.length()];
		int[] set2 = new int[t.length()];

		for (int i = 0; i < s.length(); i++) {

			map1.putIfAbsent(s.charAt(i), map1.size());

			set1[i] = map1.get(s.charAt(i));

			map2.putIfAbsent(t.charAt(i), map2.size());

			set2[i] = map2.get(t.charAt(i));

			if (set1[i] == set2[i]) {
				continue;
			} else {
				return false;
			}

		}

		return true;

	}
}
