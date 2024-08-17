import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;


public class Main {

    static int n, m, k, cnt;
    static boolean [][] arr; // 전체 map (쓰레기가 있는 곳은 true 나머지는 false)
    static boolean [][] visited; // 방문했던 노드 확인
    static int result; // 최종 결과값을 저장
    static int [] dx = {0, 0, -1, 1}; // 좌우
    static int [] dy = {-1, 1, 0, 0}; // 상하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];

        for(int i = 0; i < k; i++) {

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[r - 1][c - 1] = true; // 실제 index로 바꿔서 계산
        }

        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int k = 0; k < m; k++) {

                // 현재 위치에 쓰레기가 있고 방문하지 않았던 노드라면 bfs 탐색
                if(arr[i][k] & !visited[i][k]) {
                    cnt = 0;
                    bfs(i, k);
                    result = Math.max(result, cnt); // 기존에 저장된 쓰레기랑 현재 탐색한 쓰레기 중 큰 값을 저장
                }
            }
        }

        System.out.println(result);
    }

    public static void bfs(int r, int c) {
        ArrayDeque<int []> toVisit = new ArrayDeque<>(); // 방문할 노드 순서
        toVisit.add(new int[] {r,c});
        visited[r][c] = true;
        cnt ++;

        while(!toVisit.isEmpty()) {
            int[] now = toVisit.poll(); // FIFO를 위해 poll
            // 상하좌우 탐색
            for(int i =0; i < 4; i++) {
                int posx = now[1] + dx[i]; // 가로
                int posy = now[0] + dy[i]; // 세로

                // 상하좌우중 map을 벗어난 경우가 있으면 탐색 x
                if(posx < 0 || posx >= m || posy < 0 || posy >=n)
                    continue;

                // 상하좌우중 쓰레기가 있고 방문하지 않았던 곳이라면 다음 방문할 곳에 추가하고 cnt 증가
                if(arr[posy][posx] & !visited[posy][posx]) {
                    toVisit.add(new int[]{posy, posx});
                    visited[posy][posx] = true;
                    cnt ++;
                }
            }
        }
    }

}