class Solution {
    public int distributeCandies(int n, int limit) {
        if(n>3*limit)return 0;
        //i=0 - limit   -> n-i
        int ans=0;
        for(int i=0;i<=limit;i++){
            for(int j=0;j<=limit;j++){
                for(int k=0;k<=limit;k++){
                    if(i+j+k==n)ans++;
                }
            }
        }
        return ans;
    }
}