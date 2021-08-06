import java.util.*;

public class StoneGame {
    // August 5, 2021: Stone Game
    // Sol 1: Recursive Approach (TLE)
    public static int stoneGameDfs(int[] piles, int first, int last, int curr) {
        if(first > last) {
            return 0;
        }
        
        if(curr == 0) { // alex's turn
            int ans1 = stoneGameDfs(piles, first + 1, last, 1) + piles[first];
            int ans2 = stoneGameDfs(piles, first, last - 1, 1) + piles[last];
            return Math.max(ans1, ans2);
        }
        // lee's turn
        int ans1 = stoneGameDfs(piles, first + 1, last, 0) - piles[first];
        int ans2 = stoneGameDfs(piles, first, last - 1, 0) - piles[last];
        return Math.min(ans1, ans2);
    } 

    // Sol 2: Memoization (Accepted)
    public static int stoneGameMemo(int[] piles, int first, int last, int curr, int[][] dp) {
        if(first > last) {
            return 0;
        }
        
        if(dp[first][last] != (int)1e9) return dp[first][last];

        if(curr == 0) { // alex's turn
            int ans1 = stoneGameMemo(piles, first + 1, last, 1, dp) + piles[first];
            int ans2 = stoneGameMemo(piles, first, last - 1, 1, dp) + piles[last];
            return dp[first][last] = Math.max(ans1, ans2);
        }
        // lee's turn
        int ans1 = stoneGameMemo(piles, first + 1, last, 0, dp) - piles[first];
        int ans2 = stoneGameMemo(piles, first, last - 1, 0, dp) - piles[last];
        return dp[first][last] = Math.min(ans1, ans2);
    } 
    
    public boolean stoneGame(int[] piles) {
        // return stoneGameDfs(piles, 0, piles.length - 1, 0) > 0;
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int[] d: dp) Arrays.fill(d, (int)1e9);
        stoneGameMemo(piles, 0, n - 1, 0, dp);
        return dp[0][n-1] > 0;
    }

    // Sol 3: Dynamic Programming (Accepted)
    public static boolean stoneGameDP(int[] piles) {
        int N = piles.length;
        int[][] dp = new int[N][N];
        boolean curr = true;
        for(int i = 0; i < N; i++) dp[i][i] = -piles[i];
        for(int i = 1; i < N; i++) {
            for(int first = 0; first < N - i; first++) {
                int last = first + i;
                if(curr) dp[first][last] = Math.max(dp[first + 1][last] + piles[first], dp[first][last - 1] + piles[last]);
                else dp[first][last] = Math.min(dp[first + 1][last] - piles[first], dp[first][last - 1] - piles[last]);
                
            }
            curr = !curr;
        }
        return dp[0][N - 1] > 0;
    }
    
}
