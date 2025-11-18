class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n=bits.length;
        if(n==1)return true;
        
        int i;
            for(i=0;i<n;){
                if(bits[i]==1)i+=2; 
                else i++;
                if(i==n-1)return true;
            }
       
        
        return false;
    }
}