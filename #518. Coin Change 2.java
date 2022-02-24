// https://leetcode.com/problems/coin-change-2/
class Solution {
    
    public int change(int amount, int[] coins)
    {
        int n=coins.length;
        int[][] cache = new int[n+1][amount+1];
        for(int[] row: cache) {
            Arrays.fill(row, -1);
        }
        return sol(amount, n, coins, cache);
    }
    private int sol(int amount, int n, int[] coins, int[][]cache) 
    {
        if(amount == 0)
            return 1;
        if(n==0)
            return 0;
        if(cache[n][amount] != -1)
            return cache[n][amount];
        int pick=0;
        if(amount >= coins[n-1] )
            pick = sol(amount-coins[n-1], n, coins, cache);
        int dontPick = sol(amount, n-1, coins, cache);
        
        return cache[n][amount]=pick+dontPick;
    }
}
