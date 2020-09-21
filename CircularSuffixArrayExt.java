public class CircularSuffixArrayExt {
    // private final String[] a;
    private final NodeCh[] a;
    private final NodeCh[] aOriginal;
    private final int l; // number of chars at input


    // circular suffix array of s
    public CircularSuffixArrayExt(String s) {
        if (s == null) throw new IllegalArgumentException();
        char[] in = s.toCharArray();
        l = in.length;
        a = new NodeCh[l];
        aOriginal = new NodeCh[l];
        for (int i = 0; i < l; i++) {
            a[i] = new NodeCh(in[i], i);
            aOriginal[i] = new NodeCh(in[i], i);
        }
        Quick3string.sort(a, aOriginal);
    }


    // length of s
    public int length() {
        return l;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i > l - 1) throw new IllegalArgumentException();

        return a[i].id;
    }

    // find position of first string at sorted array
    public int findFirst() {
        for (int i = 0; i < l; i++) {
            if (index(i) == 0) return i;
        }
        return -1;
    }

    // get last column of sorted suffix array
    public char[] lastCol() {
        char[] lastCol = new char[l];
        int i = 0;
        for (NodeCh n : a) {
            lastCol[i] = (char) Quick3string.charAt(n, l - 1, aOriginal);
            i++;
        }
        return lastCol;
    }

    public static void main(String[] args) {
        CircularSuffixArrayExt csa = new CircularSuffixArrayExt("ABRACADABRA!");
        System.out.println(csa.index(11));
        return;
    }
}

