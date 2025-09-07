class Solution {
    public int[] sumZero(int n) {
        int[] ans=new int[n];
        int i=0;
        if(n%2==1){
            ans[i]=0;
            n--;i++;
        }
        int cur=1;
        while(n>0){
            ans[i++]=cur; ans[i++]=-cur;
            n-=2;cur++;
        }

        return ans;
    }
}