class Solution {
    HashMap<Long,Long> freq=new HashMap<>();
    long[] dp;
    long findMax(int i,long[] nums){
        if(i>=nums.length)return 0;
        if(dp[i]!=-1)return dp[i];
        //take
        int j=i+1;
        while(j<nums.length&&nums[j]<=nums[i]+2)j++;
        long ans1=freq.get(nums[i])*nums[i]+findMax(j,nums);
        //skip
        long ans2=findMax(i+1,nums);
        return dp[i]=Math.max(ans1,ans2);
    }

    public long maximumTotalDamage(int[] power) {
        for(long x:power)freq.put(x,freq.getOrDefault(x,0L)+1);
        long[] nums=new long[freq.size()];
        int i=0;
        for(long num:freq.keySet()){
            nums[i++]=num;
        }
        dp=new long[nums.length];
        Arrays.fill(dp,-1);
        Arrays.sort(nums);
        long ans=findMax(0,nums);
        return ans;
    }
}

/**
1 1 3 4

1 ->2 -1 3
3 ->1  1 5
4 ->1  2 6

i 
    -take
        skip till <=i+2
        i*fre[i]+j
    -not take
        i+1
 */