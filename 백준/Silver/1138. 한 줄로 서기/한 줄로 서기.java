import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        // 저장할 배열
        int [] arr = new int [n + 1];

        // 입략 받을 때 키가 1인 사람부터 배치하면 제대로 된 위치가 나옴
        for(int i = 1; i < n + 1; i++) {

            int left = sc.nextInt();

            // 앞에서부터 차례로 자리 확인
            for(int k = 1; k <= n; k++) {

                if(left == 0 && arr[k] == 0) {
                    arr[k] = i;
                    break;

                    // 해당 자리가 비어있는데 left가 0이 아니라면 자신보다 왼쪽에 큰 사람이 충족하지 않음
                    // 키가 1인 사람부터 차례로 입력받으니까 해당 left에 큰 수 가 들어올 자리를 만들어놔야함
                } else if(arr[k] == 0) {
                    left -= 1;
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}