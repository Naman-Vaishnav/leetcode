class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int num:nums){
            int left=num-k,right=num+k;
            tm.put(left,tm.getOrDefault(left,0)+1);
            tm.put(right+1,tm.getOrDefault(right+1,0)-1);
            tm.putIfAbsent(num,0);///////////////////////////////

            freq.put(num,freq.getOrDefault(num,0)+1);

        }
        int preFix=0,ans=0;
        for(int key:tm.keySet()){
            preFix+=tm.get(key);
            ans=Math.max(ans,
              Math.min(preFix - freq.getOrDefault(key,0),numOperations)   +freq.getOrDefault(key,0)
            );

            //System.out.println(key+"-"+preFix+"-"+freq.getOrDefault(key,0)+"-"+ans);
        }
        return ans;

    }
}