class Solution {
    public int numSub(String s) {
        int mod = 1_000_000_000+7;
        int l=0,ans=0;

        for(int r=0;r<s.length();r++){
            if(s.charAt(r)=='0')l=r+1;
            if(l<=r){
                ans+=(r-l+1);
                ans%=mod;
            }
        }
        return ans;

    }
}
/**
0110111

l<=r
res+= r-l+1
 */