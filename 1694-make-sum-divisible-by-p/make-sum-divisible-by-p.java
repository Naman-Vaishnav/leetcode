class Solution {
    public int minSubarray(int[] nums, int p) {
        int remainder=0,n=nums.length;
        int[] preFix=new int[n];
        preFix[0]=nums[0]%p;
        for(int i=1;i<n;i++){
            preFix[i]+=preFix[i-1]+nums[i];
            preFix[i]%=p;
          //System.out.print(preFix[i]+" ");
        }
        System.out.println();
        Map<Integer,Integer> lastSeen=new HashMap<>();
        int sumMod=preFix[n-1],ans=n;
        if(sumMod==0)return 0;
        lastSeen.put(0,-1);
        for(int i=0;i<n;i++){
            int cur=(preFix[i]-sumMod+p)%p;
            if(lastSeen.get(cur)!=null)ans=Math.min(ans,i-lastSeen.get(cur));
            lastSeen.put(preFix[i],i);
           // System.out.print(cur+" ");
        }
        
        if(ans==n)return -1;
        return ans;
    }
}

/**
6,3,5,2 10
6 0 5 7 7



3,1,4,2 6
3 4 2 4 4

2-4+6

subArray sum %p =4
 */
