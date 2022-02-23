// https://leetcode.com/problems/delete-and-earn/
class Solution {
    
    private int sol(int[] house, int n, int[] cache ){
        if(n<=0)
            return 0;
        if(cache[n]!=-1)
            return cache[n];
        
        int count = sol(house, n-2, cache) + house[n-1];
        int notCount = sol(house, n-1, cache );
        
        return cache[n] = Math.max(count, notCount);
    }
    
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int val: nums){
            if(val>max)
                max = val;
        }
        
        int[] house = new int[max+1];
        int[] cache = new int[house.length+1];
        
        for(int val: nums){
            house[val]+=val;
        }
        Arrays.fill(cache, -1);
        return sol(house, house.length, cache);
    }
    
}
