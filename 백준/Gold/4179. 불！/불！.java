import java.io.*;
import java.util.*;

public class Main {

    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};
    static int cnt = 0;
    static boolean isAnswer = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Queue<int[]> user = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();

        char[][] map = new char[R][C];

        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();

            for(int k = 0; k < C; k++) {
                if(map[i][k] == 'J') {
                    user.add(new int[] {i, k});
                } else if(map[i][k] == 'F') {
                    fire.add(new int[] {i, k});
                }
            }
        }

        while(!user.isEmpty()) {

            cnt++;

            int fireSize = fire.size();
            int userSize = user.size();

            // 불 확산
            for(int i = 0; i < fireSize; i++) {

                int[] arr = fire.poll();

                for(int d = 0; d < 4; d++) {

                    int newRow = arr[0] + drow[d];
                    int newCol = arr[1] + dcol[d];

                    if(!(newRow < 0 || newRow >= R || newCol < 0 || newCol >= C)) {
                        if(map[newRow][newCol] == '.' || map[newRow][newCol] == 'J') {
                            map[newRow][newCol] = 'F';
                            fire.add(new int[] {newRow, newCol});
                        }
                    }
                }
            }

            // 유저 이동
            for(int i = 0; i < userSize; i++) {

                int[] arr = user.poll();

                for(int d = 0; d < 4; d++) {

                    int newRow = arr[0] + drow[d];
                    int newCol = arr[1] + dcol[d];

                    if(!(newRow < 0 || newRow >= R || newCol < 0 || newCol >= C)) {
                        if(map[newRow][newCol] == '.') {
                            map[newRow][newCol] = 'J';
                            user.add(new int[] {newRow, newCol});
                        }
                    } else {
                        System.out.println(cnt);
                        return;
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}