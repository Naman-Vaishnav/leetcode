class Solution {
    public boolean isPossible(List<Integer> nums, int k) {
        List<Integer> inc=new ArrayList<>();
        int curInc=1;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i-1)<nums.get(i))curInc++;
            else {
                inc.add(curInc);
                if(curInc>=2*k)return true;
                curInc=1;
            }    
        }
        inc.add(curInc);
        if(curInc>=2*k)return true;
        for(int i=1;i<inc.size();i++){
            if(inc.get(i-1)>=k&&inc.get(i)>=k)return true;
        }

        return false;
    }

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n=nums.size();
        int l=0,r=n/2+1;
        while(r-l>1){
            int m=l+(r-l)/2;
            if(isPossible(nums,m))l=m;
            else r=m;
        }
        return l;
    }
}