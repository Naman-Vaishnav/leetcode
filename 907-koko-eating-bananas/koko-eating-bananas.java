class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int l=0,r=1_000_000_000+1;
        while(r-l>1){
            int m=l+(r-l)/2;
            if(canEat(m,h,piles))r=m;
            else l=m;
        }
        return r;

    }

    boolean canEat(int k,int h,int[] piles){
        
        for(int cur:piles){
            h-=(cur/k+(cur%k!=0?1:0));
            if(h<0)return false;
        }
        return true;

    }
}
/**

h
k->? 1 - max piles
 */