class Solution {
    public int search(int[] nums, int target) {
        int l=-1,r=nums.length;
        while(r-l>1){
            int m=l+(r-l)/2;
            //if(nums[m]==target)return m;
            if(nums[0]<=nums[m]){//in inc array
                if(nums[0]<=target&&target<=nums[m])r=m;
                else l=m;
            }
            else{
                if(nums[m]<=target&&target<=nums[nums.length-1])l=m;
                else r=m;
            }
        }
       
        if(r!=nums.length&&nums[r]==target)return r;
         if(l!=-1&&nums[l]==target)return l;
       
        return -1;
    }
}