import java.util.ArrayList;

public class reverseLinkedList {
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

	public static ListNode reverseList(ListNode l1) {

		ArrayList<Integer> values = new ArrayList<>();

		while (l1 != null) {
			values.add(l1.val);
			l1 = l1.next;
		}

		ListNode head = new ListNode();
		ListNode cur = head;

		for (int i = values.size() - 1; i >= 0; i--) {
			cur.next = new ListNode(values.get(i));
			cur = cur.next;
		}

		return head.next;

	}

	public static void main(String[] args) {
		String num1 = "12345";

		ListNode l1 = new ListNode();
		ListNode cur1 = new ListNode();

		cur1 = l1;

		for (int i = 0; i < num1.length(); i++) {
			cur1.val = Integer.parseInt(num1.substring(i, i + 1));
			if (i < num1.length() - 1) {
				cur1.next = new ListNode();
			} else {
				cur1.next = null;
			}
			cur1 = cur1.next;
		}

		System.out.println("starting");

		ListNode sum = reverseList(l1);

		cur1 = sum;
		System.out.println("Reversed List: ");
		while (cur1 != null) {
			System.out.print(cur1.val + " ");
			cur1 = cur1.next;
		}

	}
}
