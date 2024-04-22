import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class InsertAtSpecificPositionLinkedList_SinglyLinkedListNode {
    public int data;
    public InsertAtSpecificPositionLinkedList_SinglyLinkedListNode next;

    public InsertAtSpecificPositionLinkedList_SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class InsertAtSpecificPositionLinkedList_SinglyLinkedList {
    public InsertAtSpecificPositionLinkedList_SinglyLinkedListNode head;
    public InsertAtSpecificPositionLinkedList_SinglyLinkedListNode tail;

    public InsertAtSpecificPositionLinkedList_SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        InsertAtSpecificPositionLinkedList_SinglyLinkedListNode node = new InsertAtSpecificPositionLinkedList_SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class InsertAtSpecificPositionLinkedList_SinglyLinkedListPrintHelper {
    public static void printList(InsertAtSpecificPositionLinkedList_SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}
class Result_InsertAtSpecificPositionLinkedList {

    /*
     * Complete the 'insertNodeAtPosition' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST llist
     *  2. INTEGER data
     *  3. INTEGER position
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

    public static InsertAtSpecificPositionLinkedList_SinglyLinkedListNode insertNodeAtPosition(InsertAtSpecificPositionLinkedList_SinglyLinkedListNode llist, int data, int position) {
        // Write your code here

        int currentPosition = 0;
        InsertAtSpecificPositionLinkedList_SinglyLinkedListNode currentNode = llist;
        InsertAtSpecificPositionLinkedList_SinglyLinkedListNode prevNode = null;
        while (true) {
            if(position == currentPosition) {
                InsertAtSpecificPositionLinkedList_SinglyLinkedListNode insertNode = new InsertAtSpecificPositionLinkedList_SinglyLinkedListNode(data);
                insertNode.next = currentNode;

                if(prevNode != null)
                    prevNode.next = insertNode;

                return llist;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
                currentPosition++;
            }
        }
    }

}

public class Solution_InsertAtSpecificPositionLinkedList {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        InsertAtSpecificPositionLinkedList_SinglyLinkedList llist = new InsertAtSpecificPositionLinkedList_SinglyLinkedList();

        int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, llistCount).forEach(i -> {
            try {
                int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                llist.insertNode(llistItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int data = Integer.parseInt(bufferedReader.readLine().trim());

        int position = Integer.parseInt(bufferedReader.readLine().trim());

        InsertAtSpecificPositionLinkedList_SinglyLinkedListNode llist_head = Result_InsertAtSpecificPositionLinkedList.insertNodeAtPosition(llist.head, data, position);

        InsertAtSpecificPositionLinkedList_SinglyLinkedListPrintHelper.printList(llist_head, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}