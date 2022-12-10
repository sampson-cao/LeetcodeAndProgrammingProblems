import java.util.ArrayList;

public class middleOfLinkedList {
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
	public static ListNode middleNode(ListNode head) {

		ArrayList<ListNode> nodes = new ArrayList<>();

		while (head != null) {
			nodes.add(head);
			head = head.next;
		}

		return nodes.get(nodes.size() / 2);

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

		ListNode sum = middleNode(l1);

		cur1 = sum;
		System.out.println("Reversed List: ");
		while (cur1 != null) {
			System.out.print(cur1.val + " ");
			cur1 = cur1.next;
		}

	}

}
