class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans=0,mxDiag=0;

        for(int i=0;i<dimensions.length;i++){
            if(dimensions[i][0]*dimensions[i][0]+dimensions[i][1]*dimensions[i][1]>mxDiag){
                mxDiag=dimensions[i][0]*dimensions[i][0]+dimensions[i][1]*dimensions[i][1];
                ans=dimensions[i][0]*dimensions[i][1];
            }    
            else  if(dimensions[i][0]*dimensions[i][0]+dimensions[i][1]*dimensions[i][1]==mxDiag){
                 ans=Math.max(ans,dimensions[i][0]*dimensions[i][1]);
            }
        }
        return ans;

    }
}