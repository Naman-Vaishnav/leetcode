class Solution {
    int mxLen=0,start=0;
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n<2)return s;
        
        for(int i=0;i<=n-1;i++){
            extend(i,i,s);
            extend(i,i+1,s);

        }

        return s.substring(start,start+mxLen);

    }
    void extend(int i,int j,String s){
        while(i>=0&&j<=s.length()-1&&s.charAt(i)==s.charAt(j)){
            i--;j++;
        }

        if(j-i-1>mxLen){
            start=i+1;
            mxLen=j-i-1;
        }
        
    }
}