import java.util.Stack;

public class validParentheses {

	public static boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);

			if (cur == '{' || cur == '(' || cur == '[') {
				stack.add(cur);
			}

			if (stack.isEmpty()) {
				return false;
			}

			if (cur == '}') {
				if (stack.pop() != '{') {
					return false;
				}
			}

			if (cur == ')') {
				if (stack.pop() != '(') {
					return false;
				}
			}

			if (cur == ']') {
				if (stack.pop() != '[') {
					return false;
				}
			}

		}

		if (stack.isEmpty()) {
			return true;
		}

		return false;

	}

	public static void main(String[] args) {
		System.out.println(isValid("]"));
	}

}
