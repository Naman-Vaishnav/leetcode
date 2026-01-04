class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans=0;
        for(int cur:nums){
            int div=-1,noOfDiv=0;
            for(int i=2;i*i<=cur;i++){
                if(cur%i==0){
                    div=i;noOfDiv++;
                }
            }
            if(noOfDiv!=1||div*div==cur)continue;
            ans+=1+div+cur/div+cur;
        }
        return ans;
    }
}