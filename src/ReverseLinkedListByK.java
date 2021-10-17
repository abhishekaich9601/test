import java.util.Scanner;

public class ReverseLinkedListByK {

    private static final int MAX_SIZE = 11;

    public static void main(String[] args) {
        System.out.println("Enter reverse bucket size");
        int reverseBucketSize = (new Scanner(System.in)).nextInt();
        Node head = createInput();
        printNodes(head);
        printNodes(kReverse(head, reverseBucketSize));
    }

    public static Node kReverse(Node head, int k) {
        Node nHead = null;

        if (k==0 || k==1 || head == null) return head;

        Node cHead = null;
        Node kTail = null;
        Node pkTail = null;
        int count = 0;
        Node curr = head;

        while(curr != null) {
            count++;
            if (count==k) {
                if (nHead==null) {
                    nHead = curr;
                }
                kTail = curr;
                curr = curr.next;
                reverse(cHead, kTail);
                if (pkTail != null) {
                    pkTail.next = kTail;
                }
                if (kTail != null) {
                    kTail = cHead;
                    kTail.next = curr;
                    pkTail = kTail;
                }
                count = 0;
                cHead = null;
            }
            else {
                if (cHead==null) cHead = curr;
                curr = curr.next;
            }

        }

        return nHead;
    }

    public static void reverse(Node head, Node tail) {
        Node curr = head;
        Node prev = null;

        while (prev != tail) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    private static void printNodes(Node head) {
        Node currNode = head;
        StringBuilder nodesAsString = new StringBuilder();
        nodesAsString.append(String.valueOf(head.value));
        while (currNode.next!=null) {
            nodesAsString.append("->" + String.valueOf(currNode.next.value));
            currNode = currNode.next;
        }
        System.out.println(nodesAsString.toString());
    }

    private static Node createInput() {
        Node head = new Node(1);
        Node tmpNode = head;
        for (int i=2; i<=MAX_SIZE; i++) {
            tmpNode.next = new Node(i);
            tmpNode = tmpNode.next;
        }
        return head;
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
