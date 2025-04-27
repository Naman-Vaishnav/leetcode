class Solution {
    public int countSubarrays(int[] nums) {
        int ans=0;
        int n=nums.length;
        for(int i=2;i<n;i++){
            if((nums[i-2]+nums[i])*2==nums[i-1])ans++;
        }
        return ans;
    }
}