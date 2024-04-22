import java.io.*;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }

        this.tail = node;
    }
}

class DoublyLinkedListPrintHelper {
    public static void printList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class Result_ReverseDoublyLinkedList {

    /*
     * Complete the 'reverse' function below.
     *
     * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
     * The function accepts INTEGER_DOUBLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */


    private static DoublyLinkedListNode head = null;
    public static void reverse_recursive(DoublyLinkedListNode p) {
        if(p.next == null) {
            head = p;
            head.prev = null;
            return;
        }
        reverse_recursive(p.next);
        DoublyLinkedListNode q = p.next;

        q.next = p;
        p.next = null;
        p.prev = q;

    }
    public static DoublyLinkedListNode reverse_RecursiveVersion(DoublyLinkedListNode llist) {
        // Write your code here
        reverse_recursive(llist);
        return head;
    }

    public static DoublyLinkedListNode reverse_StackedVersion(DoublyLinkedListNode llist) {
        // Write your code here

        Stack<Integer> reverseData = new Stack<>();
        reverseData.push(llist.data);
        DoublyLinkedListNode next = llist.next;
        while (next != null) {
            reverseData.push(next.data);
            next = next.next;
        }

        DoublyLinkedList rlist = new DoublyLinkedList();
        try {
            while (true) {
                rlist.insertNode(reverseData.pop());
            }
        } catch (EmptyStackException emptyStackException) {

        }
        return rlist.head;

    }

}

public class Solution_ReverseDoublyLinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                DoublyLinkedList llist = new DoublyLinkedList();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                DoublyLinkedListNode llist1 = Result_ReverseDoublyLinkedList.reverse_StackedVersion(llist.head);
                DoublyLinkedListPrintHelper.printList(llist1, " ", bufferedWriter);
                bufferedWriter.newLine();


                DoublyLinkedListNode llist2 = Result_ReverseDoublyLinkedList.reverse_RecursiveVersion(llist.head);
                DoublyLinkedListPrintHelper.printList(llist2, " ", bufferedWriter);
                bufferedWriter.newLine();
                
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}