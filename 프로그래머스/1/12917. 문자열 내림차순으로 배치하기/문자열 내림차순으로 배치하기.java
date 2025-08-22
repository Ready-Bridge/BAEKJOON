import java.util.*;

class Solution {
    public String solution(String s) {
        Character[] arr = s.chars()
                   .mapToObj(c -> (char)c) 
                   .toArray(Character[]::new);

        Arrays.sort(arr, (v1, v2) -> v2 - v1);

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}
