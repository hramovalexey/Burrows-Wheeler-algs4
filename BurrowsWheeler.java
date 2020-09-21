import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.Queue;

import java.util.Arrays;

public class BurrowsWheeler {
    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    public static void transform() {
        String s = BinaryStdIn.readString();
        CircularSuffixArrayExt cf = new CircularSuffixArrayExt(s);
        int first = cf.findFirst();
        BinaryStdOut.write(first);
        char[] lastCol = cf.lastCol();
        for (char ch : lastCol) BinaryStdOut.write(ch);

        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        String s = BinaryStdIn.readString();
        char[] lastCol = s.toCharArray();

        char[] firstCol = Arrays.copyOf(lastCol, lastCol.length);
        LSDext.sort(firstCol);


        // fill in IDs of every char at last column
        Queue<Integer>[] idsQueue;
        idsQueue = idsQueue(lastCol);

        // next array constructor
        int[] next;
        next = createNext(idsQueue, firstCol);

        // reconstruct string
        String reconsr = reconstruct(next, lastCol, first);
        BinaryStdOut.write(reconsr);
        BinaryStdOut.close();
    }

    // fill in IDs of every char at last column
    private static Queue<Integer>[] idsQueue(char[] lastCol) {
        Queue<Integer>[] idsQueue = (Queue<Integer>[]) new Queue[256];
        for (int i = 0; i < lastCol.length; i++) {

            int thisChar = lastCol[i];
            if (idsQueue[thisChar] == null) {
                idsQueue[thisChar] = new Queue<Integer>();
            }
            idsQueue[thisChar].enqueue(i);
        }
        return idsQueue;
    }

    // next array constructor
    private static int[] createNext(Queue<Integer>[] idsQueue,
                                    char[] firstCol) {
        int[] next = new int[firstCol.length];
        for (int i = 0; i < firstCol.length; i++) {
            char rightChar = firstCol[i];
            int leftId = idsQueue[rightChar].dequeue();
            if (leftId == i) {
                idsQueue[rightChar].enqueue(leftId);
                leftId = idsQueue[rightChar].dequeue();
            }
            next[i] = leftId;
        }
        return next;
    }

    // reconstruct String
    private static String reconstruct(int[] next, char[] lastCol, int first) {
        StringBuilder st = new StringBuilder(lastCol.length);
        int l = lastCol.length;
        int counter = 1;
        for (int i = next[first]; ; i = next[i]) {
            char thisChar = lastCol[i];
            st.append(thisChar);
            if (counter++ == l) break;
        }
        return st.toString();
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args[0].equals("-")) transform();
        else if (args[0].equals("+")) inverseTransform();
        else throw new IllegalArgumentException("Illegal command line argument");

    }
}
