import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {

            String words = br.readLine();
            String[] word = words.split(" ");
            int wordsCnt = 0;
            int wordCnt = 0;
            boolean flag = false;
            boolean internal = false;

            // 각 단어 첫 글자 확인
            for(int j = 0; j < word.length; j++) {
                if(!(set.contains(Character.toUpperCase(word[j].charAt(0))) || set.contains(Character.toLowerCase(word[j].charAt(0))))) {
                    wordsCnt = j;
                    wordCnt = 0;
                    set.add(word[wordsCnt].charAt(wordCnt));
                    flag = true;
                    internal = true;
                    break;
                }
            }

            // 각 단어 내에서 순차 탐색
            if(!flag) {
                for(int j = 0; j < word.length; j++) {

                    char[] arr = word[j].toCharArray();
                    internal = false;

                    for(int k = 0; k < arr.length; k++) {
                        if(!(set.contains(Character.toUpperCase(arr[k])) || set.contains(Character.toLowerCase(arr[k])))) {
                            wordsCnt = j;
                            wordCnt = k;
                            set.add(word[wordsCnt].charAt(wordCnt));
                            internal = true;
                            break;
                        }
                    }

                    if(internal) {
                        break;
                    }
                }
            }

            if(!internal) {

                sb.append(words);

            } else {
                for(int j = 0; j < word.length; j++) {
                    if(j == wordsCnt) {
                        for(int k = 0; k < word[j].length(); k++) {
                            if(k == wordCnt) {
                                sb.append('[');
                                sb.append(word[j].charAt(k));
                                sb.append(']');
                            } else {
                                sb.append(word[j].charAt(k));
                            }
                        }

                        sb.append(" ");

                    } else {
                        sb.append(word[j] + " ");
                    }
                }
            }

            sb.append("\n");

        }

        System.out.println(sb);
    }
}