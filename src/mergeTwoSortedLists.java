public class mergeTwoSortedLists {
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

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		int val1;
		int val2;
		ListNode head = new ListNode();
		ListNode cur = head;

		while (l1 != null || l2 != null) {
			// default val, if val isn't changed because l1 or l2 is null, we know that val
			// here is invalid and we shouldn't use it
			val1 = 101;
			val2 = 101;

			// grab l1 and l2 values
			if (l1 != null) {
				val1 = l1.val;
			}

			if (l2 != null) {
				val2 = l2.val;
			}

			// put the smallest one in the sorted list and increment that list
			if (val1 < val2) {
				l1 = l1.next;
				cur.next = new ListNode(val1);
			} else {
				l2 = l2.next;
				cur.next = new ListNode(val2);
			}

			cur = cur.next;

		}

		return head.next;
	}

	public static void main(String[] args) {
		String num1 = "135";
		String num2 = "246";

		ListNode l1 = new ListNode();
		ListNode l2 = new ListNode();
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
		System.out.println("starting");

		ListNode sum = mergeTwoLists(l1, l2);

		cur1 = sum;
		System.out.println("Sorted List: ");
		while (cur1 != null) {
			System.out.print(cur1.val + " ");
			cur1 = cur1.next;
		}

	}

}
