class Solution {
    public int longestSubarray(int[] nums) {
        int l=0,n=nums.length;
        int ans=0,zeros=0;

        for(int r=0;r<n;r++){
            if(nums[r]==0)zeros++;
            while(zeros>1){
                if(nums[l]==0)zeros--;
                l++;     
            }
            
            ans=Math.max(ans,r-l+1 -1 );
        }
        
        return ans;

    }
}