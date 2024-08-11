import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int l, c;
    static char [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st1.nextToken());
        c = Integer.parseInt(st1.nextToken());

        st1 = new StringTokenizer(br.readLine());

        arr = new char[c];

        for(int i = 0; i < c; i++) {
            arr[i] = st1.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        find(0, "", 0, 0);

    }

    public static void find(int index, String result, int aeiou, int other) {

        if(index == c) {
            if(aeiou >= 1 && other >=2 && result.length() == l) {
                System.out.println(result);
            }

            return;
        }

        if("aeiou".contains(Character.toString(arr[index]))) {
            aeiou++;
            find(index + 1, result + arr[index], aeiou, other);
            find(index + 1, result, aeiou-1, other);
        } else {
            other++;
            find(index + 1, result + arr[index], aeiou, other);
            find(index + 1, result, aeiou, other-1);
        }
    }
}