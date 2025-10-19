class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int min=nums[0]-k;
        int ans=1;
        for(int i=1;i<nums.length;i++){
            
            if(Math.abs(min+1-nums[i])<=k){
               ans++;
               min++;
            }
            else if(min<nums[i]-k){
                min=nums[i]-k;
                ans++;
            }
        }
        return ans;
    }
}
/**
1
2 2
3 3
4
 */