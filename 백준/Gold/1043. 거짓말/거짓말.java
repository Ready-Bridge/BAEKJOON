import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        // disjoint set
        // 진실을 아는 사람 다 묶어서 루트 통일
        // 만약 파티 인원 순회하면서 진실을 아는 사람 관련 그룹에 묶인 사람 나오면 해당 인원 전부 같은 그룹으로 묶음
        // 마지막에 나눠진 그룹 수 - 1 하면 말할 수 있는 파티가 나옴

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        int truth = Integer.parseInt(st.nextToken());

        int prev = 0;
        int baseline = -1;

        if(truth != 0) {
            prev = Integer.parseInt(st.nextToken());
            baseline = prev;
        }

        // 진실 아는 사람끼리 그룹 만들기
        for(int i = 1; i < truth; i++) {

            int person = Integer.parseInt(st.nextToken());

            union(prev, person);
            prev = person;
        }

        ArrayList<Integer>[] listArr = new ArrayList[M];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int people = Integer.parseInt(st.nextToken());

            listArr[i] = new ArrayList<Integer>();

            int pre = Integer.parseInt(st.nextToken());

            listArr[i].add(pre);

            for(int j = 1; j < people; j++) {

                int person = Integer.parseInt(st.nextToken());
                listArr[i].add(person);
                union(pre, person);
                pre = person;
            }
        }

        // 각 파티별로 가능한지 여부 확인

        if(baseline != -1){

            int cnt = M;
            int baselineRoot = find(baseline);

            for(int i = 0; i < M; i++) {

                for(int j = 0; j < listArr[i].size(); j++) {

                    if(find(listArr[i].get(j)) == baselineRoot) {
                        cnt -= 1;
                        break;
                    }
                }
            }

            System.out.println(cnt);

        } else {
            System.out.println(M);
        }


    }

    static void union(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);

        if(root1 == root2) {
            return;
        }

        if(root1 <= root2) {
            parent[root2] = root1;
        } else {
            parent[root1] = root2;
        }

    }

    static int find(int p) {
        if(p != parent[p]) {
            parent[p] = find(parent[p]);
        }

        return parent[p];
    }
}