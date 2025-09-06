class Solution {
    long findOperation(long n){
        if(n==0)return 0;
        long log=(int)(Math.log(n)/Math.log(4));
        // System.out.println(log);//15 
        long opr= (n-(long)Math.pow(4,log)+1)*(log+1) ;
        n=(long)Math.pow(4,log);
        while(n>1){
            log--;
            opr+=(n-(n/4))*(log+1);
            n/=4;
        }
        return opr;

    }
    public long minOperations(int[][] queries) {
        long ans=0;
        //System.out.println(findOperation(1));
       // System.out.println(findOperation(255));
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0],r=queries[i][1];
            ans+=(findOperation(r)-findOperation(l-1)+1)/2;
            //System.out.println(ans);
        }
        return ans;
    }
}
/**
14 ->3 +1 ->4
(14-3*4 +1) * (3+1)

4*(3*(3+1))/2
16-18 -> 3*5 ->15
12 - 15->4 -> 16
8 - 11->3 ->12
4 - 7 ->2 ->8
1 -3 -> 1 -> 3

64-255 ->4 192
16-63 ->3 48
4-15 ->2 12 
1-3 ->1 3
 */