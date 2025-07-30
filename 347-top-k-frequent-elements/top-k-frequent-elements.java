class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> freq=new HashMap<>();
        for(int i=0;i<n;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }

        List<List<Integer>> bucket=new ArrayList<>();
        for(int i=1;i<=n+1;i++){
            bucket.add(new ArrayList<>());
        }

        for(Integer key:freq.keySet()){
            bucket.get(freq.get(key)).add(key);
        }
        int[] ans=new int[k];
        int cur=0;
        for(int i=n;i>0;i--){
            for(Integer ele:bucket.get(i)){
                ans[cur++]=ele;
                if(cur==k)break;
            }
            if(cur==k)break;
        }
        return ans;

    }
}