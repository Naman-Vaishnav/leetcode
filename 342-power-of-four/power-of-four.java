class Solution {
    public boolean isPowerOfFour(int n) {
       if(n<=0)return false;
       double log=Math.log(n)/Math.log(4);
       return log==(int)log;
    }
}