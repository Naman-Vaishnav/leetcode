class Solution {
    public String minWindow(String s, String t) {
    
        int l=0,r=0,ans=s.length()+1,idx=0;
        int freqT[]=new int[128];
        for(char ch:t.toCharArray())freqT[ch]++;

        int foundInWin=0;    
         
         int freqWin[]=new int[128];
        for(r=0;r<s.length();r++){
            freqWin[s.charAt(r)]++;

            if(freqWin[s.charAt(r)]<=freqT[s.charAt(r)])foundInWin++;

            
            while(l<=r&&freqWin[s.charAt(l)]>freqT[s.charAt(l)]){
                freqWin[s.charAt(l)]--;
                l++;
            }

        
            if(foundInWin==t.length()){
                if(ans>r-l+1){
                    ans=r-l+1;
                    idx=l;
                }
                
            }

        }
        return ans==s.length()+1?"":s.substring(idx,idx+ans);

    }
}
/**
freq[] t
l r
 check if same as freq of t
 while l<=r freqWin[l]>freqT[l]
    l++
 check if all of freqWin >= freqT[]
 */