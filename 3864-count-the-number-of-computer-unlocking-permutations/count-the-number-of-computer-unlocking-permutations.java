class Solution {
    public int countPermutations(int[] complexity) {
        int min=complexity[0];
        int n=complexity.length;
        for(int i=1;i<n;i++){
            if(complexity[i]<=min)return 0;
        }
        n--;
        long ans=1,mod=1000_000_000+7;
        for(int i=n;i>=1;i--){
            ans*=i;
            ans%=mod;
        }
        return (int)ans;
    }
}