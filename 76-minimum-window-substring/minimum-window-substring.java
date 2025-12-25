class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> freqS=new HashMap<>();
         Map<Character,Integer> freqT=new HashMap<>();
        for(char ch:t.toCharArray()){
            freqT.put(ch,freqT.getOrDefault(ch,0)+1);
        }
        int l=0,start=0;
        int ans=Integer.MAX_VALUE;
        int curMatch=0;
        for(int r=0;r<s.length();r++){
            char R=s.charAt(r);
            freqS.put(R,freqS.getOrDefault(R,0)+1);
            if(freqS.getOrDefault(R,0)<=freqT.getOrDefault(R,0))curMatch++;

            while(l<=r&&freqS.getOrDefault(s.charAt(l),0)>freqT.getOrDefault(s.charAt(l),0)){
                freqS.put(s.charAt(l),freqS.get(s.charAt(l))-1);
                l++;
            }
            
            if(curMatch>=t.length()&&ans>r-l+1){
                ans=Math.min(ans,r-l+1);
                start=l;
            }

        }

        if(ans!=Integer.MAX_VALUE)return s.substring(start,ans+start);
        return "";

    }
}

/**
ADOBECODEBANC
ABC
freqS
freqT - pre

include r freqS++
while(freqS[l]>freqT[l])l++
if all 26 update ans
 */