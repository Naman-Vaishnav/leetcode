class Solution {
    public int minimumArea(int[][] grid) {
        int mxR=Integer.MIN_VALUE,miR=Integer.MAX_VALUE;
        int miC=Integer.MAX_VALUE,mxC=Integer.MIN_VALUE;
        int n=grid.length,m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    miR=Math.min(miR,i);
                    mxR=Math.max(mxR,i);

                    miC=Math.min(miC,j);
                    mxC=Math.max(mxC,j);
                }
            }
        }

        if(miR==Integer.MAX_VALUE||miC==Integer.MAX_VALUE)return 0;
        return (mxR-miR+1)*(mxC-miC+1);
    }
}