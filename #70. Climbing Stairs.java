// https://leetcode.com/problems/climbing-stairs/

// iterative solution
// public class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n + 1];
//         if (n == 1) {
//             return 1;
//         }
//         if (n == 2) {
//             return 2;
//         }
//         dp[0] = 0;
//         dp[1] = 1;
//         dp[2] = 2;
//         for (int i = 3; i <= n; i++) {
//           dp[i] = dp[i-1] + dp[i - 2];
//         }
//         return dp[n];
//     }
// }

// recursive solution
class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        return helper(n, cache);
    }
    private int helper(int n, int[] cache) {
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        if(cache[n]!=-1)
            return cache[n];
        int oneStep = helper(n-1, cache);
        int twoStep = helper(n-2, cache);
        return cache[n] = oneStep + twoStep;
    }
}
