class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans=0;
        int l=0,r=0;
        int n=nums.length;
        long sum=0;
        for(;r<n;r++){
            sum+=nums[r];
            while(l<=r&&sum*(r-l+1)>=k){
                sum-=nums[l];
                l++;
            }
            ans+=(r-l+1);
        }
        return ans;
    }
}