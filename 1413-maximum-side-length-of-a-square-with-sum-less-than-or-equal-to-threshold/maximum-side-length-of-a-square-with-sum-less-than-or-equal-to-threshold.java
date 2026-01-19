class Solution {
    int[][] dp;
    public int maxSideLength(int[][] mat, int threshold) {
        int n=mat.length,m=mat[0].length;
        dp=new int[n][m];
        preFix(mat);
        int ans=0;
         for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                for(int k=Math.min(n,m);k>0;k--){
                    int x=i+k-1,y=j+k-1;//top left (i,j) bottom right(x,y)
                    if(x>=n||y>=m)continue;
                    int cur=dp[x][y]-
                            (i>0?dp[i-1][y]:0)-
                            (j>0?dp[x][j-1]:0)+
                            (i>0&&j>0?dp[i-1][j-1]:0);
                    if(cur<=threshold){
                        ans=Math.max(ans,k);
                        break;
                    }
                }
            }
        }
        return ans;

    }
    void preFix(int[][] mat){

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){

                dp[i][j]=
                    (i>0?dp[i-1][j]:0)+
                    (j>0?dp[i][j-1]:0)-
                    (i>0&&j>0?dp[i-1][j-1]:0)+
                    mat[i][j];

            }
        }

    }
}