class Solution {
    public String pushDominoes(String dominoes) {
        //1L.R321LR21L..
        //.L.R123LR12L.
        int mx=1_000_000;
        int n=dominoes.length();
        List<Integer> L=new ArrayList<>();
        List<Integer> R=new ArrayList<>();
        int cur=0;
        for(int i=0;i<n;i++){
            char ch=dominoes.charAt(i);
            if(ch=='R'){
                cur=1;
                R.add(mx);
            }
            if(ch=='.'){
                if(cur>=1){
                    R.add(++cur);
                }
                else R.add(mx);
            }
            if(ch=='L'){
                cur=0;
                R.add(mx);
            }
        }
        for(int i=n-1;i>=0;i--){
            char ch=dominoes.charAt(i);
            if(ch=='L'){
                cur=1;
                L.add(mx);
            }
            if(ch=='.'){
                if(cur>=1){
                    L.add(++cur);
                }
                else L.add(mx);
            }
            if(ch=='R'){
                cur=0;
                L.add(mx);
            }
        }
        Collections.reverse(L);
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=dominoes.charAt(i);
            if(ch=='R'||ch=='L')ans.append(""+ch);
            else{
                if(L.get(i)==mx&&R.get(i)==mx)ans.append(".");
                else if(L.get(i)<R.get(i))ans.append("L");
                else if(L.get(i)>R.get(i))ans.append("R");
                else ans.append(".");
            }
        }
        return ans.toString();
        

    }
}