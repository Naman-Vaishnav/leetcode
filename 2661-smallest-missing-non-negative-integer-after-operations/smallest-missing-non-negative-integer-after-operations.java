class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            nums[i]=(nums[i]%value+value)%value;
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
        }

        int i=0;
        while(hs.get(i%value)!=null&&hs.get(i%value)>0){
            hs.put(i%value,hs.get(i%value)-1);
            i++;
        }
        return i;
    }
}