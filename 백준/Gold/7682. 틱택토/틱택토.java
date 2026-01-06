import java.util.*;
import java.io.*;

public class Main {

    static void counter(char[][] arr, int[] cnt) {

        int X = 0;
        int O = 0;

        for(int i = 0; i < 3; i++) {
            for(int k = 0; k < 3; k++) {
                if(arr[i][k] == 'X') {
                    X++;
                } else if(arr[i][k] == 'O') {
                    O++;
                }
            }
        }

        cnt[0] = X;
        cnt[1] = O;
    }

    static int isEnd(char[][] arr, int X, int O) {

        // X라면 X == O + 1
        // O라면 X == O

        int cnt = 0;

        // 양쪽 대각선 확인
        if(arr[0][0] != '.' && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
            if(arr[0][0] == 'X') {
                if(!(X == O + 1)) {
                    return -1;
                }
            } else if(arr[0][0] == 'O') {
                if(!(X == O)) {
                    return -1;
                }
            }

            cnt++;
        }

        if(arr[0][2] != '.' && arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]) {
            if(arr[0][2] == 'X') {
                if(!(X == O + 1)) {
                    return -1;
                }
            } else if(arr[0][2] == 'O') {
                if(!(X == O)) {
                    return -1;
                }
            }

            cnt++;
        }



        // 각 행들 확인

        for(int i = 0; i < 3; i++) {
            if(arr[i][0] != '.' && arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                if(arr[i][2] == 'X') {
                    if(!(X == O + 1)) {
                        return -1;
                    }
                } else if(arr[i][2] == 'O') {
                    if(!(X == O)) {
                        return -1;
                    }
                }

                cnt++;
            }
        }

        // 각 열들 확인

        for(int i = 0; i < 3; i++) {
            if(arr[0][i] != '.' && arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
                if(arr[2][i] == 'X') {
                    if(!(X == O + 1)) {
                        return -1;
                    }
                } else if(arr[2][i] == 'O') {
                    if(!(X == O)) {
                        return -1;
                    }
                }

                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            String input = br.readLine();

            if(input.equals("end")) break; // 종료

            char[][] arr = new char[3][3];

            // 틱택토 판 생성
            for(int i = 0; i < 3; i++) {
                for(int k = 0; k < 3; k++) {
                    arr[i][k] = input.charAt(i * 3 + k);
                }
            }

            int[] cnt = new int[2]; // [0] -> X의 개수, [1] -> Y의 개수
            counter(arr, cnt);

            // 개수 유효성검사 통과못하면 invaild
            if(!(cnt[0] == cnt[1] || cnt[0] == (cnt[1] + 1))) {
                System.out.println("invalid");
                continue;
            }

            // X + O의 개수가 9개이거나 같은 행, 열 대각선 이 전부 X혹은 O인지 확인 -> 통과하면 vaild 못하면 invalid

            int end = isEnd(arr, cnt[0], cnt[1]);

//            Oxx
//            xOx
//            xOO

            if(cnt[0] + cnt[1] == 9 && end != -1) {
                System.out.println("valid");
            } else if(end == 1) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }

    }
}