// Linked list with navigating over Nodes
public class LinkedListMTF {
    private static final char R = 256; //
    private final Node[] nodes;
    private Node first;
    private Node last;

    // create LinkedList of ASCII characters
    public LinkedListMTF() {
        this.nodes = new Node[R];
        for (char i = 0; i < R; i++) {
            addLast(i, i);
            nodes[i] = last;
        }
    }

    public char moveToFront(char character) {
        Node unlinked = unlink(character);
        char returnId = unlinked.id;
        if (returnId != 0) {
            Node temp = unlinked.prev;
            while (temp != null) {
                temp.id++;
                temp = temp.prev;
            }
            linkFirst(unlinked);
            unlinked.id = 0;
        }
        return returnId;
    }

    public char moveToFrontDecode(char id) {
        Node unlinked = getNode(id);
        unlinked = unlink(unlinked);
        char returnChar = unlinked.ch;
        if (unlinked.id != 0) {
            Node temp = unlinked.prev;
            while (temp != null) {
                temp.id++;
                temp = temp.prev;
            }
            linkFirst(unlinked);
            unlinked.id = 0;
        }
        return returnChar;
    }


    // get Node by id
    private Node getNode(char id) {
        Node returnNode = first;
        for (char i = 1; i <= id; i++) {
            returnNode = returnNode.next;
        }
        return returnNode;
    }

    private void addLast(char character, char idNum) {
        Node l = last;
        Node newNode = new Node(character, idNum, l, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
    }

    private void linkFirst(Node n) {
        Node f = first;
        first = n;
        if (f == null)
            last = n;
        else {
            f.prev = n;
            n.next = f;
            n.prev = null;
        }
    }


    private Node unlink(Node n) {
        char character = n.ch;
        Node toUnlinkNode = nodes[character];
        if (toUnlinkNode != first) {
            Node nextNode = toUnlinkNode.next;
            Node prevNode = toUnlinkNode.prev;
            if (prevNode != null) prevNode.next = nextNode;
            if (nextNode != null) nextNode.prev = prevNode;
        }
        return toUnlinkNode;
    }

    private Node unlink(char character) {
        Node toUnlinkNode = nodes[character];
        toUnlinkNode = unlink(toUnlinkNode);
        return toUnlinkNode;
    }


    private class Node {
        private Node next;
        private Node prev;
        private final char ch;
        private char id;


        public Node(char character, char idNum, Node prevNode, Node nextNode) {
            this.ch = character;
            this.id = idNum;
            this.prev = prevNode;
            this.next = nextNode;
        }
    }


    public static void main(String[] args) {
        LinkedListMTF llm = new LinkedListMTF();
        llm.moveToFront((char) 3);

        return;
    }
}
