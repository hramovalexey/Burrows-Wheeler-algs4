// LSD for Nodes & Nodes with char & just chars array
public class LSDext {
    public static void sort(Node[] a, int W) {
        int R = 256;
        int N = a.length;
        Node[] aux = new Node[N];
        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++)
                count[a[i].st.charAt(d) + 1]++;
            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];
            for (int i = 0; i < N; i++)
                aux[count[a[i].st.charAt(d)]++] = a[i];
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }

    public static void sort(NodeCh[] a) {
        int R = 256;
        int N = a.length;
        NodeCh[] aux = new NodeCh[N];
        int[] count = new int[R + 1];
        for (int i = 0; i < N; i++)
            count[a[i].st + 1]++;
        for (int r = 0; r < R; r++)
            count[r + 1] += count[r];
        for (int i = 0; i < N; i++)
            aux[count[a[i].st]++] = a[i];
        for (int i = 0; i < N; i++)
            a[i] = aux[i];
    }

    public static void sort(char[] a) {
        int R = 256;
        int N = a.length;
        char[] aux = new char[N];
        int[] count = new int[R + 1];
        for (int i = 0; i < N; i++)
            count[a[i] + 1]++;
        for (int r = 0; r < R; r++)
            count[r + 1] += count[r];
        for (int i = 0; i < N; i++)
            aux[count[a[i]]++] = a[i];
        for (int i = 0; i < N; i++)
            a[i] = aux[i];
    }

}
