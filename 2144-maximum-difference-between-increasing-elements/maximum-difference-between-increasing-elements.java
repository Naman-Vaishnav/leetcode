class Solution {
    public int maximumDifference(int[] nums) {
        int ans=-1;
        int mi=nums[0];
        for(int i=1;i<nums.length;i++){
            ans=Math.max(ans,nums[i]-mi);
            mi=Math.min(mi,nums[i]);
        }
        return ans==0?-1:ans;
    }
}