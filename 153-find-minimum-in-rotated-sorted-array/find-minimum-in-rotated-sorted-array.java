class Solution {
    public int findMin(int[] nums) {
        int l=-1,r=nums.length; // 0 n-1
        while(r-l>1){
            int m=l+(r-l)/2;
            if(nums[0]<=nums[m])l=m;
            else r=m;
        }
        if(r==nums.length)return nums[0];
        return nums[r];
    }
}
/**
 [3,4,5,1,2]
    if l<m go right l=m
    else r=m 

 */