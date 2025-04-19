// Last updated: 19/04/2025, 15:15:45
class Solution {
    int upper_bound(int[] nums,int target,int i){
        int l=-1,r=i+1;
        while(r-l>1){
            int m=l+(r-l)/2;
            if(nums[m]<=target)l=m;
            else r=m;
        }
        return r;
    }
    //0,1,4,4,5,7
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n=nums.length,ex=0;
        long ans=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int left=upper_bound(nums,lower-nums[i]-1,i-1);
            int right=upper_bound(nums,upper-nums[i],i-1);
            //if(left<=nums[i]&&nums[i]<=right)ex++;
            ans+=(right-left);
        }
        return ans;

    }
}