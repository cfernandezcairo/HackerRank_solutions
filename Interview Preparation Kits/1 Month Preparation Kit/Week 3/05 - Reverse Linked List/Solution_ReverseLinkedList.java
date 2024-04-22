import java.io.*;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.IntStream;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}
class Result_ReverseLinkedList {
    /*
     * Complete the 'reverse' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    private static SinglyLinkedListNode head = null;
    public static void reverse(SinglyLinkedListNode p) {
        if(p.next == null) {
            head = p;
            return;
        }
        reverse(p.next);
        SinglyLinkedListNode q = p.next;
        q.next = p;
        p.next = null;
    }
    public static SinglyLinkedListNode reverse_RecursiveVersion(SinglyLinkedListNode llist) {
        // Write your code here
        reverse(llist);
        return head;
    }

    public static SinglyLinkedListNode reverse_StackVersion(SinglyLinkedListNode llist) {
        // Write your code here

        Stack<Integer> reverseData = new Stack<>();
        reverseData.push(llist.data);
        SinglyLinkedListNode next = llist.next;
        while (next != null) {
            reverseData.push(next.data);
            next = next.next;
        }

        SinglyLinkedList rlist = new SinglyLinkedList();
        try {
            while (true) {
                rlist.insertNode(reverseData.pop());
            }
        } catch (EmptyStackException emptyStackException) {

        }
        return rlist.head;
    }
}

public class Solution_ReverseLinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int tests = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, tests).forEach(testsItr -> {
            try {
                SinglyLinkedList llist = new SinglyLinkedList();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                SinglyLinkedListNode llist1 = Result_ReverseLinkedList.reverse_StackVersion(llist.head);
                SinglyLinkedListPrintHelper.printList(llist1, " ", bufferedWriter);
                bufferedWriter.newLine();

                SinglyLinkedListNode llistrecursive = Result_ReverseLinkedList.reverse_RecursiveVersion(llist.head);
                SinglyLinkedListPrintHelper.printList(llistrecursive, " ", bufferedWriter);
                bufferedWriter.newLine();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}