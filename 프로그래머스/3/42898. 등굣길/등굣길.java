import java.util.*;

class Solution {
    int mm, nn;
    int[][] dp;
    int MOD = 1000000007;

    private boolean isWater(int x, int y, int[][] puddles) {
        for (int[] arr : puddles) {
            if (arr[0] - 1 == x && arr[1] - 1 == y) {
                return true;
            }
        }
        return false;
    }

    private int dfs(int x, int y, int[][] puddles) {

        if (x == mm && y == nn) return 1;

        if (dp[x][y] != -1) return dp[x][y];

        long ways = 0;

        // 오른쪽
        if (x + 1 <= mm && !isWater(x + 1, y, puddles)) {
            ways += dfs(x + 1, y, puddles);
        }

        // 아래쪽
        if (y + 1 <= nn && !isWater(x, y + 1, puddles)) {
            ways += dfs(x, y + 1, puddles);
        }

        dp[x][y] = (int)(ways % MOD);
        return dp[x][y];
    }

    public int solution(int m, int n, int[][] puddles) {
        mm = m - 1;
        nn = n - 1;
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(0, 0, puddles);
    }
}
