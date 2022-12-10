
class addTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode sum = new ListNode();
		ListNode cur = sum;
		int num1 = 0;
		int num2 = 0;
		int numToAdd = 0;
		int carry = 0;

		/*
		 * while l1, l2 still have elements or if there's a carry (for if the most
		 * significant digit is a 9 and it carries to a 10)
		 */
		while (l1 != null || l2 != null) {
			System.out.println("in loop");

			num1 = 0;
			num2 = 0;

			// debug statements
//			if (l1 != null) {
//				System.out.println("list 1: " + l1.val + " " + l1.next);
//				System.out.println(l1);
//			}
//			if (l2 != null) {
//				System.out.println("list 2: " + l2.val + " " + l2.next);
//				System.out.println(l2);
//			}

			// if non null, assign val to num
			if (l1 != null) {
				System.out.println("l1: " + l1.val);
				num1 = l1.val;
			}

			if (l2 != null) {
				System.out.println("l2: " + l2.val);
				num2 = l2.val;
			}

			numToAdd = num1 + num2 + carry;

			carry = numToAdd / 10;
			numToAdd %= 10;


			if (numToAdd >= 0 && numToAdd <= 9) {
				cur.val = numToAdd;
			}

			System.out.println("Num added:" + cur.val);

			if (l1 != null || l2 != null) {
				cur.next = new ListNode(-1);
				cur = cur.next;
			} else {
				cur.next = null;
			}

			// increment linked list if next one is non-null
			if (l1 != null) {
				l1 = l1.next;
			}

			if (l2 != null) {
				l2 = l2.next;
			}

		}

		// Add the additional carry element if applicable
		if (carry == 1) {
			cur.val = 1;
			cur.next = null;
		}

		// Strip leading zeros
		cur = sum;
		while (cur.next != null) {
			if (cur.next.val == -1) {
				cur.next = null;
				break;
			}
			cur = cur.next;
		}

		cur = sum;
		System.out.println("Sum list:");
		while (cur != null) {
			System.out.println(cur);
			System.out.println(cur.val);
			cur = cur.next;
		}

//		// Strip trailing ListNode from the list
//		cur = sum;
//		while (cur != null) {
//			System.out.println(cur);
//			System.out.println(cur.val);
//			if (cur.next.val == 0 && cur.next.next == null) {
//				cur.next = null;
//				break;
//			}
//			cur = cur.next;
//		}

		return sum;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode();
		ListNode l2 = new ListNode();

		String num1 = "9999999";
		String num2 = "9999";

		ListNode cur1 = new ListNode();
		ListNode cur2 = new ListNode();

		cur1 = l1;
		cur2 = l2;

		for (int i = 0; i < num1.length(); i++) {
			cur1.val = Integer.parseInt(num1.substring(i, i + 1));
			if (i < num1.length() - 1) {
				cur1.next = new ListNode();
			} else {
				cur1.next = null;
			}
			cur1 = cur1.next;
		}

		for (int i = 0; i < num2.length(); i++) {
			cur2.val = Integer.parseInt(num2.substring(i, i + 1));
			if (i < num2.length() - 1) {
				cur2.next = new ListNode();
			} else {
				cur2.next = null;
			}
			cur2 = cur2.next;
		}

		cur1 = l1;
		System.out.println("l1: ");
		while (cur1 != null) {
			System.out.println(cur1.val);
			cur1 = cur1.next;
		}
		System.out.println();
		cur2 = l2;
		System.out.println("l2: ");
		while (cur2 != null) {
			System.out.println(cur2.val);
			cur2 = cur2.next;
		}
		System.out.println();

		ListNode sum = addTwoNumbers(l1, l2);

		cur1 = sum;
		System.out.println("Sum: ");
		while (cur1 != null) {
			System.out.print(cur1.val);
			cur1 = cur1.next;
		}

	}

}