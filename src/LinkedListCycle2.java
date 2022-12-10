import java.util.ArrayList;

public class LinkedListCycle2 {
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

	public static ListNode detectCycle(ListNode head) {

		ArrayList<ListNode> values = new ArrayList<>();

		while (head != null) {

			if (values.contains(head)) {
				return head;
			}

			values.add(head);

			head = head.next;
		}

		return null;

	}

	public static void main(String[] args) throws InterruptedException {
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

		ListNode sum = detectCycle(l1);

		cur1 = sum;
		System.out.println("Reversed List: ");
		while (cur1 != null) {
			System.out.print(cur1.val + " ");
			cur1 = cur1.next;
		}

		ListNode a = new ListNode(3);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(0);
		ListNode d = new ListNode(4, b);

		a.next = b;
		b.next = c;
		c.next = d;

		ListNode cur = a;

		while (cur != null) {
			System.out.print(cur + " " + cur.val + " -> ");
			cur = cur.next;
			Thread.sleep(500);
		}

	}
}
