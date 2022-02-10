class Solution {
    public int rob(int[] house) {
        int[] cache =  new int[house.length + 1];
        Arrays.fill(cache, -1);
        return sol(house, 0, house.length, cache);
    }
    private int sol(int[] house, int cur, int n, int[] cache) {
        if(cur>=n)
            return 0;
        if(cache[cur]!= -1)
            return cache[cur];
        int rob =  sol(house, cur+2, n, cache) + house[cur];
        int dontRob =  sol(house, cur+1, n, cache);
        
        return cache[cur] = Math.max(rob, dontRob);
    }
}