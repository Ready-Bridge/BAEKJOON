import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static char[][] arr;
	public static int min = Integer.MAX_VALUE;
	public static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		arr = new char[a][b];

		for(int i = 0; i < a; i++) {
			String str = bf.readLine();

			for(int k = 0; k < b; k++) {
				arr[i][k] = str.charAt(k);
			}
		}

		for(int i = 0; i < a - 7; i++) {
			for(int k = 0; k < b - 7; k++) {
				checkColor(i, k,'W'); // 제일 왼쪽 위가 검정색으로 시작하는 경우 (색상이 한번 바뀌고 시작함)

			
				checkColor(i, k, 'B'); // 제일 왼쪽 위가 흰색으로 시작하는 경우 (색상이 한번 바뀌고 시작함)
			}
		}

		System.out.println(min);
	}

	private static void checkColor(int i, int k, char color) {
		for(int m = i; m < i + 8; m++) {

			// 행이 바뀔 때 이전 색상에서 한 번 변경
			color = color == 'W' ? 'B' : 'W';

			for (int n = k; n < k + 8; n++) {
				// 만약 색이 일치하지 않으면 칠해야 할 cnt 증가
				if(arr[m][n] != color) {
					cnt += 1;
				}

				// 다음 색깔 확인을 위해 색상 변경
				color = color == 'W' ? 'B' : 'W';

			}
		}
		min = Math.min(min, cnt); // 칠하는 경우의 수가 가장 작은 경우를 min에 저장함

		cnt = 0; // 색칠해야할 타일 개수 초기화
	}
}