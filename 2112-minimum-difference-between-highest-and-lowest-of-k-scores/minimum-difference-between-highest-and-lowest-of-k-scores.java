class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int l=0,r=k-1,ans=Integer.MAX_VALUE;
        while(r<n){
            ans=Math.min(ans,nums[r]-nums[l]);
            l++;r++;
        }
        return ans;
    }
}