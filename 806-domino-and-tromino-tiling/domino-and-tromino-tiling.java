class Solution {
    int n;
    int[][] dp;
    int mod=1_000_000_000+7;
    public int numTilings(int n) {
        /*(i,0)->prev are connected ->(i+1,0)+(i+1,1)+2*(i-1,3)
          (i,1)->prev are disconnected but have to extened -> (i-1,2)
          (i,2)->prev are disconnected but not to to extened->(i-1,0)+(i-1,1)+2*(i-1,3)
          (i,3)->it is tromino->(i-1,3)+(i-1,1)

         (i,0)prev are connected -> 
          break both (i+1,0)
          2*extend one 2*(i+1,1) 
         (i,1) prev are disconnected

         (i,0)H      (i+1,0) (i+1,1) (i+1,2) -> combined these two
         (i,1)V both (i+2,0) (i+2,1) (i+2,2) -> 
         (i,2)T      2*(i+1,2) 2*(i+1,3)
         (i,3)V one  2*(i+2,0) 2*(i+1,3)

          
        */
        this.n=n;
        dp=new int[n+1][4];
        for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
        return findWays(1,0);
    }

    int findWays(int i,int x){
       
        if(i==n+1)return (x==0)?1:0;
        if(i>n+1)return 0;

        if(dp[i][x]!=-1)return dp[i][x];

        if(x==0){
            return dp[i][x]=((findWays(i+1,0) +findWays(i+2,0))%mod +2*findWays(i+1,2)%mod)%mod;
        }
        /*if(x==1){
            return findWays(i+1,0) +findWays(i+2,1) +2*findWays(i+1,2);
        }*/
        if(x==2){
            return dp[i][x]=(findWays(i+2,0) +findWays(i+1,2))%mod;
        }
        if(x==2){
            return dp[i][x]=(findWays(i+2,0) +findWays(i+1,2))%mod;
        }
        return 0;
    }
}