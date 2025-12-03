import java.awt.desktop.SystemEventListener;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];
        int[] head = new int[]{n, n};

        for(int i = 0; i < n; i++){
            arr[i] = br.readLine().toCharArray();

            for(int j = 0; j < n; j++) {
                // 가장 위에있는 *이 머리임
                if(arr[i][j] == '*' && i < head[0]) {
                    head[0] = i;
                    head[1] = j;
                }
            }
        }

        // 머리 한칸 밑이 심장
        int[] heart = new int[]{head[0] + 1, head[1]}; // 좌표가 1부터 시작하므로 출력시에는 각 값에 + 1

        int rightarm = 0;
        int leftarm = 0;
        int rightleg = 0;
        int leftleg = 0;
        int waist = 0;

        // 왼쪽팔 길이 -> 심장의 왼쪽까지 *의 개수
        for(int i = 0; i < heart[1]; i++) {
            if(arr[heart[0]][i] == '*') {
                leftarm++;
            }
        }

        // 오른팔 길이 -> 심장 오른쪽부터 끝까지 *의 개수
        for(int i = heart[1] + 1; i < n; i++) {
            if(arr[heart[0]][i] == '*') {
                rightarm++;
            }
        }

        // 허리 길이 -> 심장 밑 부분 부터 끝까지 *의 개수 (해당 열)
        for(int i = heart[0] + 1; i < n; i++) {
            if(arr[i][heart[1]] == '*') {
                waist++;
            }
        }

        // 왼다리 길이 -> 허리 끝 왼쪽 대각선 아래 부터 끝까지  *의 개수 (해당 열)
        for(int i = heart[0] + waist + 1; i < n; i++) {
            if(arr[i][heart[1] - 1] == '*') {
                leftleg++;
            }
        }


        // 오른다리 길이 -> 허리 끝 오른쪽 대각선 아래 부터 끝까지  *의 개수 (해당 열)
        for(int i = heart[0] + waist + 1; i < n; i++) {
            if(arr[i][heart[1] + 1] == '*') {
                rightleg++;
            }
        }

        System.out.println((heart[0] + 1) + " " + (heart[1] + 1));
        System.out.println(leftarm + " " + rightarm + " " + waist + " " + leftleg + " " + rightleg);
    }
}