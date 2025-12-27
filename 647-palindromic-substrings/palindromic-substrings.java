class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int ans=n;

        for(int i=1;i<n;i++){
            int odd=expand(i,i,s);
            int even=expand(i-1,i,s);
            ans+=odd/2+even/2;
        }
        return ans;

    }

    int expand(int i,int j,String s){
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;j++;
        }

        return j-i-1;

    }

}

/**
bbaca

-1 3
3--1 -1
acaca
5+
3->1
5->2
7->3

acac
4->2

 */