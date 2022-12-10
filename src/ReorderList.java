import java.util.ArrayList;

public class ReorderList {
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

	public static ListNode reorderList(ListNode head) {

		ListNode rev = reverseList(head);

	}

	public static ListNode reverseList(ListNode l1) {

		ListNode rev = new ListNode();
		ListNode l = l1;

		ArrayList<ListNode> nodes = new ArrayList<>();

		while (l != null) {
			nodes.add(l);
			l = l.next;
		}

		l = rev;

		for (int i = nodes.size() - 1; i >= 0; i--) {
			l.next = nodes.get(i);
			l = l.next;
		}

		l.next = null;

		return rev.next;

	}

	public static void main(String[] args) {

		String num = "12345";

		ListNode l = new ListNode();
		ListNode cur = new ListNode();

		cur = l;

		for (int i = 0; i < num.length(); i++) {
			cur.val = Integer.parseInt(num.substring(i, i + 1));
			if (i < num.length() - 1) {
				cur.next = new ListNode();
			} else {
				cur.next = null;
			}
			cur = cur.next;
		}

		ListNode ans = reverseList(l);

		cur = ans;

		System.out.println("List: ");
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

}
