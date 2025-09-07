class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        generateSubsets(0,ans,cur,nums);
        return ans;
    }

    void generateSubsets(int i,List<List<Integer>> ans, List<Integer> cur,int[] nums){
        if(i==nums.length){
            ans.add(new ArrayList(cur));
            return;
        }

       
        cur.add(nums[i]);
        generateSubsets(i+1,ans,cur,nums);
        cur.remove(cur.size()-1);
        
       // while(i+1<nums.length&&nums[i]==nums[i+1])i++;
        generateSubsets(i+1,ans,cur,nums);


    }
}