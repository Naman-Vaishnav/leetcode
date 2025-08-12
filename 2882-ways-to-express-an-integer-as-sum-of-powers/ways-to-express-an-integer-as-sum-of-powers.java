class Solution {
    long[][] dp;
    long mod=1_000_000_000+7;
    public int numberOfWays(int n, int x) {
        dp=new long[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return (int)solve(n,x,1);
        
        

    }

    long solve(int n,int x,int cur){
        if(n==0)return 1;
        if(n<0||cur>n)return 0;
        if(dp[n][cur]!=-1)return dp[n][cur];

        return dp[n][cur]=(solve(n,x,cur+1)+solve(n-(int)Math.pow(cur,x),x,cur+1))%mod;
        

    }
}
/**
4
4^1
3^1+1^1

160

(1)
 */