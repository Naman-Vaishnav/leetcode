// Last updated: 19/04/2025, 16:02:55
class Solution {
    public long countGood(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        int l=0,r=0,curPairs=0;
        long ans=0;
        for(;r<n;r++){
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            if(hm.get(nums[r])>=2)curPairs+=(hm.get(nums[r])-1);
            while(l<r&&curPairs>=k){
                int lFreq=hm.get(nums[l]);
                curPairs-=(lFreq-1);
                hm.put(nums[l],lFreq-1);
                l++;
                ans+=(n-r);
            }
        }
        return ans;
    }
}