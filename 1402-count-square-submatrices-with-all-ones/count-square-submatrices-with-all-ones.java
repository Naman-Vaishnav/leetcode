class Solution {
    public int countSquares(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int[][] dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(matrix[i-1][j-1]==1){
                        dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])) +1;
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                ans+=dp[i][j];
            }
        }
        return ans;

    }
}

/**
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]

  if m[i][j]==1
    dp[i][j]=min dp[i-1][j] dp[i][j-1] dp[i-1][j-1] +1


]
 */