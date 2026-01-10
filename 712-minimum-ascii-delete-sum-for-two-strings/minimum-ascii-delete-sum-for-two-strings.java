class Solution {
    Integer[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        dp=new Integer[n+1][m+1];
        //return findMin(0,0,s1,s2);
        int[] prev=new int[m+1];
        int[] cur=new int[m+1];
        //dp[0][0]=0;
        prev[0]=cur[0]=0;
        for(int j=1;j<=m;j++){
            //dp[0][j]=dp[0][j-1]+s2.charAt(j-1);
            prev[j]=prev[j-1]+s2.charAt(j-1);
        }
        // for(int i=1;i<=n;i++){
        //     dp[i][0]=dp[i-1][0]+s1.charAt(i-1);
        // }
        for(int i=1;i<=n;i++){
            cur[0]=s1.charAt(i-1)+prev[0];
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))cur[j]=prev[j-1];
                else{
                    int delI=s1.charAt(i-1)+prev[j];
                    int delJ=s2.charAt(j-1)+cur[j-1];
                    //int delIJ=s1.charAt(i-1)+s2.charAt(j-1)+prev[j-1];
                    cur[j]=Math.min(delI,delJ);
                }
            }
            int[] temp=prev;
            prev=cur;
            cur=temp;
        }
        return prev[m];
        //return dp[n][m];

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
(0,0) 0
(0,j) sum(j)
(i,0) sum(i)

(i,j)
    if(i<0||j<0){
        0 i sum
        0 j sum
    }
    if([i]==[j])ans=(i+1,j+1)
    [i]+(i+1,j)
    [j]+(i,j+1)
    [i]+[j]+(i+1,j+1)

    (i,j)
    if(i)
        [i]==[j]->1+(i+1,j+1,true)
        else (i+1,j,is)
       
        (i,j+1,false)
*/