class Solution {
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        dp=new int[n][amount+1];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        int ans=findCoins(0,amount,coins);
        
        return (ans==Integer.MAX_VALUE)?-1:ans;

    }
    
    int findCoins(int cur,int amount,int[] coins){
        if(amount==0)return 0;
        if(cur==coins.length||amount<0)return Integer.MAX_VALUE;
        if(dp[cur][amount]!=-1)return dp[cur][amount];

        int take=findCoins(cur,amount-coins[cur],coins);
        if(take!=Integer.MAX_VALUE)take++;
        int leave=findCoins(cur+1,amount,coins);

        return dp[cur][amount]=Math.min(take,leave);

    }


}