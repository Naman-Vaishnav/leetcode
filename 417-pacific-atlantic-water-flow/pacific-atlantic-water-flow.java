class Solution {
    int n,m;
    boolean[][] vis;
    int[][] count;
    int[][] h;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

    boolean isValid(int i,int j){
        return i>=0&&i<n&&j>=0&&j<m;
    }
    void dfs(int i,int j){
        vis[i][j]=true;
        count[i][j]++;
        for(int[] d:dir){
            int nI=i+d[0],nJ=j+d[1];
            if(isValid(nI,nJ)&&!vis[nI][nJ]&&h[i][j]<=h[nI][nJ])dfs(nI,nJ);
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n=heights.length;m=heights[0].length;
        count=new int[n][m];
        vis=new boolean[n][m];
        h=heights;
        for(int i=0;i<n;i++){
            if(!vis[i][0])dfs(i,0);
        }
        for(int i=0;i<m;i++){
             if(!vis[0][i])dfs(0,i);
        }
        vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            if(!vis[i][m-1])dfs(i,m-1);
        }
        for(int i=0;i<m;i++){
             if(!vis[n-1][i])dfs(n-1,i);
        }

        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(count[i][j]>1)ans.add(Arrays.asList(i,j));
            }
        }
        return ans;

    }
}