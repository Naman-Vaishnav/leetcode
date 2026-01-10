class Solution {
    Integer[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        dp=new Integer[s1.length()][s2.length()];
        return findMin(0,0,s1,s2);
    }

    int findMin(int i,int j,String s1, String s2){

        if(i==s1.length()||j==s2.length()){
            int ans=0;
            for(int k=i;k<s1.length();k++){
                ans+=s1.charAt(k);
            }
            for(int k=j;k<s2.length();k++){
                ans+=s2.charAt(k);
            }
            return ans;
        }

        if(dp[i][j]!=null)return dp[i][j];

        int ans=Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j))ans=Math.min(ans,findMin(i+1,j+1,s1,s2));
        else{
            ans=Math.min(ans,s1.charAt(i)+findMin(i+1,j,s1,s2));
            ans=Math.min(ans,s2.charAt(j)+findMin(i,j+1,s1,s2));
            ans=Math.min(ans,s1.charAt(i)+s2.charAt(j)+findMin(i+1,j+1,s1,s2));
        }
        return dp[i][j]=ans;
    }

}

/*
delete"
"leet"

(i,j)
    if(i<0||j<0){
        0 i sum
        0 j sum
    }
    if([i]==[j])ans=(i+1,j+1)
    [i]+(i+1,j)
    [j]+(i,j+1)
    [i]+[j]+(i+1,j+1)
*/