import java.util.*;

class Solution {

    public String[] solution(int[][] line) {

        List<int[]> gyojum = new ArrayList<>();

        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;

        for (int i = 0; i < line.length - 1; i++) {
            long A = line[i][0], B = line[i][1], E = line[i][2];

            for (int k = i + 1; k < line.length; k++) {
                long C = line[k][0], D = line[k][1], F = line[k][2];

                long denominator = A * D - B * C;
                if (denominator == 0) continue; 

                long xNumerator = B * F - E * D;
                long yNumerator = E * C - A * F;

                if (xNumerator % denominator != 0 || yNumerator % denominator != 0) continue;

                int x = (int)(xNumerator / denominator);
                int y = (int)(yNumerator / denominator);
                gyojum.add(new int[] {x, y});

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }

        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);

        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = ".".repeat(width);
        }

        for (int[] point : gyojum) {
            int x = point[0];
            int y = point[1];

            int row = (int)(maxY - y);     
            int col = (int)(x - minX);     

            String lineStr = answer[row];
            answer[row] = lineStr.substring(0, col) + '*' + lineStr.substring(col + 1);
        }

        return answer;
    }
}
