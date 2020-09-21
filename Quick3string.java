import edu.princeton.cs.algs4.StdRandom;

public class Quick3string {

    private static final int CUTOFF = 15;   // cutoff to insertion sort

    // do not instantiate
    private Quick3string() {
    }

    /**
     * Rearranges the array of strings in ascending order.
     *
     * @param a the array to be sorted
     */
    public static void sort(NodeCh[] a, NodeCh[] aOriginal) {
        StdRandom.shuffle(a);
        sort(aOriginal, a, 0, a.length - 1, 0);
        // assert isSorted(a);
    }

    // return the dth character of s, -1 if d = length of s
    public static int charAt(NodeCh s, int d, NodeCh[] a) {
        assert d >= 0 && d <= a.length;
        if (d == a.length) return -1;
        int index = s.id + d - ((s.id + d) / a.length) * a.length;
        return a[index].st;
    }


    // 3-way string quicksort a[lo..hi] starting at dth character
    private static void sort(NodeCh[] aOriginal, NodeCh[] a, int lo, int hi, int d) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int v = charAt(a[lo], d, aOriginal);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d, aOriginal);
            if (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(aOriginal, a, lo, lt - 1, d);
        if (v >= 0) sort(aOriginal, a, lt, gt, d + 1);
        sort(aOriginal, a, gt + 1, hi, d);
    }


    // exchange a[i] and a[j]
    private static void exch(NodeCh[] a, int i, int j) {
        NodeCh temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // is v less than w, starting at character d
    // DEPRECATED BECAUSE OF SLOW SUBSTRING EXTRACTION IN JAVA 7
    // private static boolean less(String v, String w, int d) {
    //    assert v.substring(0, d).equals(w.substring(0, d));
    //    return v.substring(d).compareTo(w.substring(d)) < 0;
    // }


    public static void main(String[] args) {

    }
}
