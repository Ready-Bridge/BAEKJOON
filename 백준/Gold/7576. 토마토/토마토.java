import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int m, n, day;
    static int [][] map;
    static int [] dx = {0, 0, -1, 1}; // 좌우
    static int [] dy = {-1, 1, 0, 0}; // 상하
    static int [][] visited_cnt;
    static Queue<int []> toVisit = new LinkedList<>(); // 방문할 노드 (bfs 를 위한 FIFO)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited_cnt = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < m; k++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][k] = temp;
                if (temp == 1) {
                    toVisit.add(new int[]{i, k}); // 만약 익은 토마토라면 Visit에 추가해서 bfs 시작
                    visited_cnt[i][k] = 1; // 1일차 부터 시작 (결과값에서는 day - 1일 해줘야함)
                }
            }
        }

        if(checkFinish()) {
            System.out.println(0);
        } else {
            find();
        }

    }

    public static void find() {

        while(!toVisit.isEmpty()) {
            int [] now = toVisit.poll();


            for(int i = 0; i < 4; i++) {
                int x = now[1] + dx[i];
                int y = now[0] + dy[i];

                if(y < 0 || y >= n || x < 0 || x >= m)
                    continue;


                // 처음 방문하고 익지 않은 토마토(0)이라면 Visit에 추가해줌
                if(map[y][x] == 0){
                    map[y][x] = 1;
                    visited_cnt[y][x] = visited_cnt[now[0]][now[1]] + 1;
                    toVisit.add(new int[] {y, x});
                }
            }
        }

        if(checkFinish()) {
            for(int i = 0; i < n; i++) {
                for(int k = 0; k < m; k++) {
                    day = Math.max(day, visited_cnt[i][k]);
                }
            }
            System.out.println(day - 1);
        } else {
            System.out.println(-1);
        }
    }

    public static boolean checkFinish() {
        for(int i = 0; i < n; i++) {
            for(int k = 0; k < m; k++) {
                if(map[i][k] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}