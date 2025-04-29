class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        int mx=0;
        for(int x:nums)mx=Math.max(x,mx);
        int l=0,r=0,count=0;
        long ans=0;
        for(;r<n;r++){
            if(nums[r]==mx)count++;
            while(l<=r&&count>k){
                if(nums[l]==mx)count--;
                l++;
            }
            while(count==k&&l<=r&&nums[l]!=mx)l++;
            if(count==k)ans+=(l+1);
        }
        return ans;
    }
}