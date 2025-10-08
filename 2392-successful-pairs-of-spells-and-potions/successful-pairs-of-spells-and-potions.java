class Solution {

    int find_no_of_greater(int[] potions,long key){
        int n=potions.length;
        int l=-1,r=potions.length;
        while(r-l>1){
            int m=l+(r-l)/2;
            if(potions[m]<key)l=m;
            else r=m;//m>=l
        }
        if(r==potions.length)return 0;
        return n-(r);
    }
//5 8 8
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n=spells.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int cur=spells[i];
            ans[i]=find_no_of_greater(potions,success/cur + (success%cur!=0?1:0));
        }
        return ans;
    }
}