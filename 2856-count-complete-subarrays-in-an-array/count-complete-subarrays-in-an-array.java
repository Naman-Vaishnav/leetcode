class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        int l=0,r=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int x:nums)hm.put(x,1);
        int distinct=hm.size();
        hm.clear();
        int ans=0;
        for(;r<n;r++){
            int count=hm.getOrDefault(nums[r],0);
            hm.put(nums[r],count+1);
            while(l<r&&hm.get(nums[l])>1){
                hm.put(nums[l],hm.get(nums[l])-1);
                l++;
            }
            if(hm.size()==distinct)ans+=(l+1);
        }
        return ans;
    }
}