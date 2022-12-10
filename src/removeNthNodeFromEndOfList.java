public class removeNthNodeFromEndOfList {
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

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		int size = 0;

		ListNode l = head;
		ListNode ans = new ListNode();

		while (l != null) {
			size++;
			l = l.next;
		}

		if (size == 1) {
			return null;
		}

		ans.next = head;

		System.out.println(size);

		int idxRemove = size - n;

		System.out.println(idxRemove);

		l = ans;

		for (int i = 0; i < idxRemove; i++) {
			l = l.next;
		}

		l.next = l.next.next;

		return ans.next;
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
		
		ListNode ans = removeNthFromEnd(l, 2);

		cur = ans;

		System.out.println("List: ");
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

	}

}
