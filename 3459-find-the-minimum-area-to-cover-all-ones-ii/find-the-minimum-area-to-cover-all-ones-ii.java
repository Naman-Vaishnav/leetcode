class Solution {
    public int[] minimumAreaOne(int[][] grid,int rowStart,int rowEnd,int colStart,int colEnd) {
        int mxR=Integer.MIN_VALUE,miR=Integer.MAX_VALUE;
        int miC=Integer.MAX_VALUE,mxC=Integer.MIN_VALUE;
        for(int i=rowStart;i<=rowEnd;i++){
            for(int j=colStart;j<=colEnd;j++){
                if(grid[i][j]==1){
                    miR=Math.min(miR,i);
                    mxR=Math.max(mxR,i);

                    miC=Math.min(miC,j);
                    mxC=Math.max(mxC,j);
                }
            }
        }

        if(miR==Integer.MAX_VALUE||miC==Integer.MAX_VALUE)return new int[]{0,-1,0,-1,0};
        return new int[]{miR,mxR,miC,mxC,(mxR-miR+1)*(mxC-miC+1)};
    }



    public int minimumSum(int[][] grid) {
         int n=grid.length,m=grid[0].length;
         int ans=n*m;
        int[] one= minimumAreaOne(grid,0,n-1,0,m-1);
        if(one.length==0)return 0;
        int rowStart=one[0],rowEnd=one[1];
        int colStart=one[2],colEnd=one[3];
 

        //split horizontal
        for(int i=0;i<=n-1;i++){
            int[] upperPart=minimumAreaOne(grid,rowStart,i,colStart,colEnd);
            int[] lowerPart=minimumAreaOne(grid,i+1,rowEnd,colStart,colEnd);

            //upper
                //horizontal
             for(int j=upperPart[0];j<=upperPart[1];j++){
                int[] upper=minimumAreaOne(grid,upperPart[0],j,upperPart[2],upperPart[3]);
                int[] lower=minimumAreaOne(grid,j+1,upperPart[1],upperPart[2],upperPart[3]);
                ans=Math.min(ans,lowerPart[4]+upper[4]+lower[4]);
             }
            //upper
                //vertical
            for(int j=upperPart[2];j<=upperPart[3];j++){
                int[] left=minimumAreaOne(grid,upperPart[0],upperPart[1],upperPart[2],j);
                int[] right=minimumAreaOne(grid,upperPart[0],upperPart[1],j+1,upperPart[3]);
                ans=Math.min(ans,lowerPart[4]+left[4]+right[4]);
             }


             //lower
                //horizontal
             for(int j=lowerPart[0];j<=lowerPart[1];j++){
                int[] upper=minimumAreaOne(grid,lowerPart[0],j,lowerPart[2],lowerPart[3]);
                int[] lower=minimumAreaOne(grid,j+1,lowerPart[1],lowerPart[2],lowerPart[3]);
                ans=Math.min(ans,upperPart[4]+upper[4]+lower[4]);
             }
            //lower
                //vertical
            for(int j=lowerPart[2];j<=lowerPart[3];j++){
                int[] left=minimumAreaOne(grid,lowerPart[0],lowerPart[1],lowerPart[2],j);
                int[] right=minimumAreaOne(grid,lowerPart[0],lowerPart[1],j+1,lowerPart[3]);
                ans=Math.min(ans,upperPart[4]+left[4]+right[4]);
             }
            

        }


        //split vertical
        for(int i=0;i<=m-1;i++){
            int[] leftPart=minimumAreaOne(grid,rowStart,rowEnd,colStart,i);
            int[] rightPart=minimumAreaOne(grid,rowStart,rowEnd,i+1,colEnd);

            //left
                //horizontal
             for(int j=leftPart[0];j<=leftPart[1];j++){
                int[] upper=minimumAreaOne(grid,leftPart[0],j,leftPart[2],leftPart[3]);
                int[] lower=minimumAreaOne(grid,j+1,leftPart[1],leftPart[2],leftPart[3]);
                ans=Math.min(ans,rightPart[4]+upper[4]+lower[4]);
             }
            //left
                //vertical
            for(int j=leftPart[2];j<=leftPart[3];j++){
                int[] left=minimumAreaOne(grid,leftPart[0],leftPart[1],leftPart[2],j);
                int[] right=minimumAreaOne(grid,leftPart[0],leftPart[1],j+1,leftPart[3]);
                ans=Math.min(ans,rightPart[4]+left[4]+right[4]);
             }


             //right
                //horizontal
             for(int j=rightPart[0];j<=rightPart[1];j++){
                int[] upper=minimumAreaOne(grid,rightPart[0],j,rightPart[2],rightPart[3]);
                int[] lower=minimumAreaOne(grid,j+1,rightPart[1],rightPart[2],rightPart[3]);
                ans=Math.min(ans,leftPart[4]+upper[4]+lower[4]);
             }
            //right
                //vertical
            for(int j=rightPart[2];j<=rightPart[3];j++){
                int[] left=minimumAreaOne(grid,rightPart[0],rightPart[1],rightPart[2],j);
                int[] right=minimumAreaOne(grid,rightPart[0],rightPart[1],j+1,rightPart[3]);
                ans=Math.min(ans,leftPart[4]+left[4]+right[4]);
             }


            

        }

        return ans;
        


    }
}

/**
[[1,0,1,0],
 [0,1,0,1]]

one Reg

split horiz
  -upper
    -vertical 
    -horiz
    ans=lower+
  -lower

split vertical
    -left
    -right

 */