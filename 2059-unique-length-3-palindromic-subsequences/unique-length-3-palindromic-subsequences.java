class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character,TreeSet<Integer>> charToInds=new HashMap<>();
        int ind=0;
        for(char ch:s.toCharArray()){
            TreeSet<Integer> ts=charToInds.get(ch);
            if(ts==null)ts=new TreeSet<>();
            ts.add(ind);
            charToInds.put(ch,ts);
            ind++;
        }
        int ans=0;
        for(char ch='a';ch<='z';ch++){
             TreeSet<Integer> ts=charToInds.get(ch);
             if(ts==null||ts.size()==1)continue;
            int first=ts.first(),last=ts.last();
            for(char iCh='a';iCh<='z';iCh++){
                ts=charToInds.get(iCh);
                if(ts==null||ts.higher(first)==null)continue;
                int higher=ts.higher(first);
                if(higher<last)ans++;
            }
        }
        return ans;

    }
}

/**
a*a*a

b*b b->indexs first and last of it
        go throught all chars
            char if first< charInd <last

bbcbaba
b*b 3
a*a 1
 */