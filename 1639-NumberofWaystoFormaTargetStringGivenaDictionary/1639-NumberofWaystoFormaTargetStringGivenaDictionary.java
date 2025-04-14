// Last updated: 14/04/2025, 23:11:22
class Solution {
    int mod=1_000_000_000+7;
    Integer[][] dp;
    int findWays(int i,int j,String target,int wLength,int[][] freq){
        if(i==target.length()){
            return 1;
        }
        if(j==wLength)return 0;
        Integer ans=dp[i][j];
        if(ans!=null)return ans;
        //take j. all string having target[i] char in words
        int count=freq[j][target.charAt(i)-'a'];
        int way1=0;
        if(count!=0){
          way1=(int)(((long)count*findWays(i+1,j+1,target,wLength,freq))%mod);
        }
        //skip j
        int way2=findWays(i,j+1,target,wLength,freq);
        return dp[i][j]=(way1+way2)%mod;
    }

    public int numWays(String[] words, String target) {
        int tLength=target.length();
        int wLength=words[0].length();
        
        int[][] freq=new int[wLength][26];
        for(String w:words){
            for(int i=0;i<wLength;i++){
                freq[i][w.charAt(i)-'a']++;
            }
        }
        dp=new Integer[tLength][wLength];
        return findWays(0,0,target,wLength,freq);
    }
}