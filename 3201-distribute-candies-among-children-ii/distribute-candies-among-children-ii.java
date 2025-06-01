class Solution {
    public long distributeCandies(int n, int limit) {
        if(n>3*limit)return 0;
        /**
            n 
            i=0 limit 
            1st-> i -- 1
            pending j=n-i -- 2
            j>2*limit continue 
            
            2nd-> max 0,j-limit ... min j,limit -> 2-3  2,3
            3rd-> j-k>0
            l , 0...l
            l-1,0...l+1

            0,0...2*l
           
         */
         long ans=0;
         for(int i=0;i<=limit;i++){
            int j=n-i;
            if(j<0||j>2*limit)continue;
            int k=Math.max(0,j-limit),m=Math.min(j,limit);
            ans+=(m-k+1);
            //System.out.println(ans);
         }
         return ans;
    }
}