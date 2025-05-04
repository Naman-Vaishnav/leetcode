class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans=0;
        int n=dominoes.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            Arrays.sort(dominoes[i]);
            int key=(dominoes[i][0]*111+dominoes[i][1]);
            ans+=hm.getOrDefault(key,0);
            hm.put(key,hm.getOrDefault(key,0)+1);
        }
    
        return ans;


    }
}