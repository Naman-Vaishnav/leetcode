class Solution {
    /**
     * Adds two numbers represented by two linked lists, where each node contains a single digit.
     * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
     *
     * @param l1 First linked list representing the first number.
     * @param l2 Second linked list representing the second number.
     * @return A linked list representing the sum of the two numbers.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Stacks to store the digits of the two numbers
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        // Push all digits of l1 into stack1
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        // Push all digits of l2 into stack2
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        // 'dummyHead' is the placeholder for the result linked list 
        ListNode dummyHead = null;
        int carry = 0; // Initialize carry to zero

        // Loop until both stacks are empty and there is no carry left
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            // If a stack is empty, use 0 as the digit, otherwise pop the top digit
            int sum = (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop()) + carry;
          
            // Create a new node with the sum's least significant digit and add it to the front of the linked list 'dummyHead'
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = dummyHead;
            dummyHead = newNode;

            // Calculate the new carry value
            carry = sum / 10;
        }
      
        // Return the sum linked list, which is 'dummyHead.next' because 'dummyHead' is a dummy node
        return dummyHead;
    }
}
