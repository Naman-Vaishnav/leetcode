class Solution {
    int[] dp;
    public int numDecodings(String s) {
       int n=s.length();
        dp=new int[n];
        Arrays.fill(dp,-1);
       return findWays(0,s);  
    }

    int findWays(int i,String s){
        if(i==s.length())return 1;
        //if(i>s.length())return 0;
        if(dp[i]!=-1)return dp[i];
        int ans=0;
        int first=s.charAt(i)-'0';
        if(first==0)return 0;
        ans+=findWays(i+1,s);
        if(i+1<s.length()){
            int second=s.charAt(i+1)-'0';
            if(first*10+second<=26)ans+=findWays(i+2,s);
        }
        return dp[i]=ans;

    }
}