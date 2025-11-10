class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        Map<Integer,TreeSet<Integer>> nToInd=new TreeMap<>();
        nToInd.put(0,new TreeSet<>());
        for(int i=0;i<n;i++){
            int x=nums[i];
            TreeSet<Integer> ts=nToInd.get(x);
            if(ts==null){
                ts=new TreeSet<>();    
            }
            ts.add(i);
            nToInd.put(x,ts);
        }
        int ans=0;
        for(int key:nToInd.keySet()){
            if(key==0)continue;
            Integer nextInd=null;
            TreeSet<Integer> ts=nToInd.get(key);
            for(int ind:ts){
                if(nextInd!=null&&ind<nextInd)continue;
                Integer nextZero=nToInd.get(0).higher(ind);
                if(nextZero==null){
                    ans++;
                    break;
                }
                else{
                     nextInd=ts.higher(nextZero);
                     ans++;
                     if(nextInd==null)break;
                }
                
            }
            for(int ind:ts){
                nToInd.get(0).add(ind);
            }
        }

        return ans;



    }
}

/**
3,1,2,1
1->

2 1 2 1
2 0 2 0
0 0 2 0
0

2 3 2 1
2 3 2 0
0 3 0 0
0

min
 window
 n^2


0 1 3
1 
2 0 2 4
3 1

 */