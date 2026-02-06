import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        
        int zero = 0;
        int one = 0;

        // 1. 전체 0과 1의 개수를 센다.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') zero++;
            else one++;
        }

        // 2. 제거해야 할 개수는 각각 절반
        zero /= 2;
        one /= 2;

        // 3. 앞에서부터 '1'을 찾아 제거 (제거한 자리는 다른 문자로 표시)
        for (int i = 0; i < arr.length && one > 0; i++) {
            if (arr[i] == '1') {
                arr[i] = '2'; // 제거됨을 의미하는 임의의 문자
                one--;
            }
        }

        // 4. 뒤에서부터 '0'을 찾아 제거
        for (int i = arr.length - 1; i >= 0 && zero > 0; i--) {
            if (arr[i] == '0') {
                arr[i] = '2';
                zero--;
            }
        }

        // 5. 남은 문자들을 순서대로 출력
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != '2') {
                sb.append(c);
            }
        }
        
        System.out.println(sb.toString());
    }
}