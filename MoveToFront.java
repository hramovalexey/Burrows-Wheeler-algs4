import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {

    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();
        LinkedListMTF list = new LinkedListMTF();
        for (int i = 0; i < input.length; i++) {
            char ch = list.moveToFront(input[i]);
            BinaryStdOut.write(ch);
        }
        BinaryStdOut.close();

    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();
        LinkedListMTF list = new LinkedListMTF();
        for (int i = 0; i < input.length; i++) {
            char ch = list.moveToFrontDecode(input[i]);
            BinaryStdOut.write(ch);
        }
        BinaryStdOut.close();
    }


    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-")) encode();
        else if (args[0].equals("+")) decode();
        else throw new IllegalArgumentException("Illegal command line argument");

    }
}
