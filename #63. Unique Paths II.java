// https://leetcode.com/problems/unique-paths-ii/
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m =grid.length;
        int n=grid[0].length;
        
        int[][] cache = new int[m][n];
        for(int[] row: cache){
            Arrays.fill(row, -1);
        }
        return sol(grid, m-1, n-1, cache);
    }
    private int sol(int[][] grid, int m, int n, int[][] cache) {
        if(m<0 || n<0 || grid[m][n]==1)
            return 0;
        
        if(m==0 && n==0)
            return 1;
        
        if(cache[m][n]!=-1)
            return cache[m][n];
        
        int up = sol(grid, m-1, n, cache);
        int left=sol(grid, m, n-1, cache);
        
        return cache[m][n]=up+left;
    }
}
