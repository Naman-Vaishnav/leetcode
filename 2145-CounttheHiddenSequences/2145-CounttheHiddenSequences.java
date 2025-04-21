// Last updated: 21/04/2025, 11:10:53
class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n=differences.length;
        long mi=0,mx=0;
        long prev=0;
        for(int dif:differences){
           prev+=dif;
           mi=Math.min(mi,prev);
           mx=Math.max(mx,prev);
        }
        mi=lower-mi;
        mx=upper-mx;
        if(mi>mx)return 0;
        return (int)(mx-mi+1);

    }
}