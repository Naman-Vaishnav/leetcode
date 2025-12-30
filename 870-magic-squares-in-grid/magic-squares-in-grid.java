class Solution {
    int[][] g;
    public int numMagicSquaresInside(int[][] grid) {
        g=grid;
        int ans=0,n=grid.length,m=grid[0].length;
        for(int i=0;i+2<n;i++){
            for(int j=0;j+2<m;j++){
                if(isMagical(i,j))ans++;
            }
        }
        return ans;
    }

    boolean isMagical(int x,int y){
        Set<Integer> hs=new HashSet<>();
        Set<Integer> unique=new HashSet<>();
       for(int i=0;i<3;i++){
        int cur=0;
        for(int j=0;j<3;j++){
            if(g[x+i][y+j]<1||g[x+i][y+j]>9)return false;
            unique.add(g[x+i][y+j]);
            cur+=g[x+i][y+j];
        }
        hs.add(cur);
       }
        if(unique.size()!=9)return false;
       for(int i=0;i<3;i++){
        int cur=0;
        for(int j=0;j<3;j++){
            cur+=g[x+j][y+i];
        }
        hs.add(cur);
       }

       hs.add(g[x][y]+g[x+1][y+1]+g[x+2][y+2]);
       hs.add(g[x][y+2]+g[x+1][y+1]+g[x+2][y+0]);

       return hs.size()==1;
    }

}