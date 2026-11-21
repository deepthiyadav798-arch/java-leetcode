class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;

        // Check if there are k nodes
        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        // If fewer than k nodes, leave them unchanged
        if (count < k) {
            return head;
        }

        // Reverse the first k nodes
        ListNode prev = null;
        current = head;

        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Connect with the remaining nodes
        head.next = reverseKGroup(current, k);

        return prev;
    }
}
