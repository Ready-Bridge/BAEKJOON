import java.util.*;
import java.io.*;

class Node {
    int x, y, cnt;
    int broken; // 0: 안 부숨, 1: 부숨

    public Node(int x, int y, int cnt, int broken) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.broken = broken;
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    // visited[x][y][0]: 벽 안 부수고 도달, visited[x][y][1]: 벽 부수고 도달
    static boolean[][][] visited; 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2]; // 핵심! 3차원 배열

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        // 시작점: (0, 0), 거리 1, 벽 안 부숨(0)
        q.offer(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();

            // 도착 지점 도달 시 거리 반환
            if (current.x == N - 1 && current.y == M - 1) {
                return current.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 1. 다음 칸이 벽(1)인 경우
                if (map[nx][ny] == 1) {
                    // 현재까지 벽을 부순 적이 없어야만 부수고 이동 가능
                    if (current.broken == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true; // 벽 부순 상태로 방문 처리
                        q.offer(new Node(nx, ny, current.cnt + 1, 1));
                    }
                }
                // 2. 다음 칸이 빈 칸(0)인 경우
                else {
                    // 현재 상태(부쉈든 안 부쉈든) 그대로 이동
                    if (!visited[nx][ny][current.broken]) {
                        visited[nx][ny][current.broken] = true;
                        q.offer(new Node(nx, ny, current.cnt + 1, current.broken));
                    }
                }
            }
        }
        return -1; // 도달 불가
    }
}