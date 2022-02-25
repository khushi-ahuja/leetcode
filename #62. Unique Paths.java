// https://leetcode.com/problems/unique-paths/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for(int[] row: cache){
            Arrays.fill(row, -1);
        }
        return sol(m-1, n-1, cache);
    }
    private int sol(int m, int n, int[][] cache) {
        if(m==0 && n==0)
            return 1;
        if(m<0 || n<0)
            return 0;
        if(cache[m][n]!=-1)
            return cache[m][n];
        
        int up = sol(m-1, n, cache);
        int left=sol(m, n-1, cache);
        
        return cache[m][n]=up+left;
    }
}
