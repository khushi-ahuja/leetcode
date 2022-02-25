// https://leetcode.com/problems/distinct-subsequences/
class Solution {
    public int numDistinct(String s, String t) {
        int[][] cache = new int[s.length()+1][t.length()+1];
        for(int[] row: cache) {
            Arrays.fill(row, -1);
        }
        return sol(s.length(), t.length(), s, t, cache);
    }
    private int sol(int curS, int curT, String s, String t, int [][] cache) {
        if(curT == 0)
            return 1;
        
        if(curS == 0)
            return 0;
        
        if(cache[curS][curT]!=-1)
            return cache[curS][curT];
        
        int inc = 0;
        if(s.charAt(curS-1)==t.charAt(curT-1)) {
            inc = sol(curS-1, curT-1, s, t, cache);
        }
        int exc = sol(curS-1, curT, s, t, cache);
        
        return cache[curS][curT]=inc+exc;
    }
}
