import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        String word;
        int idx;

        public Node(String word, int idx) {
            this.word = word;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            if (this.word.equals(o.word)) {
                return this.idx - o.idx;
            }
            return this.word.compareTo(o.word);
        }
    }

    public static int getLcp(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) return i;
        }
        return len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] origin = new String[N];
        Node[] sortedArr = new Node[N];

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            origin[i] = word;
            sortedArr[i] = new Node(word, i);
        }

        Arrays.sort(sortedArr);

        int[] maxLcpForNode = new int[N];
        int maxLen = -1;

        for (int i = 0; i < N - 1; i++) {
            int lcp = getLcp(sortedArr[i].word, sortedArr[i + 1].word);

            maxLcpForNode[sortedArr[i].idx] = Math.max(maxLcpForNode[sortedArr[i].idx], lcp);
            maxLcpForNode[sortedArr[i + 1].idx] = Math.max(maxLcpForNode[sortedArr[i + 1].idx], lcp);

            maxLen = Math.max(maxLen, lcp);
        }

        for (int i = 0; i < N; i++) {
            if (maxLcpForNode[i] == maxLen) {
                String s1 = origin[i];
                for (int j = i + 1; j < N; j++) {
                    String s2 = origin[j];
                    if (getLcp(s1, s2) == maxLen) {
                        System.out.println(s1);
                        System.out.println(s2);
                        return;
                    }
                }
            }
        }
    }
}