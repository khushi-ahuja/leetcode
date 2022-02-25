// https://leetcode.com/problems/minimum-path-sum/
class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] cache = new int[m][n];
        for(int[] row: cache){
            Arrays.fill(row, -1);
        }
        return sol(m-1, n-1, grid, cache);  
    }
    private int sol(int m, int n, int[][] grid, int[][] cache) {
        if(m==0 && n==0)
            return grid[m][n];
        if(m<0 || n<0)
            return Integer.MAX_VALUE;
        if(cache[m][n]!=-1)
            return cache[m][n];
        
        int up = sol(m-1, n, grid, cache);
        int left=sol(m, n-1, grid, cache);
        
        return cache[m][n]=Math.min(up, left)+grid[m][n];
    }
}
