// Last updated: 21/04/2025, 23:26:19
class Solution {
    public long[] countBlackBlocks(int n, int m, int[][] coordinates) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(int[] i:coordinates){
            int x=i[0],y=i[1];
            if(x>0&&y>0){
                String key=x+"-"+y;
                int count=hm.getOrDefault(key,0);
                hm.put(key,count+1);
            }
            if(y>0&&x+1<n){
                String key=(x+1)+"-"+y;
                int count=hm.getOrDefault(key,0);
                hm.put(key,count+1);
            }
            if(x>0&&y+1<m){
                String key=x+"-"+(y+1);
                int count=hm.getOrDefault(key,0);
                hm.put(key,count+1);
            }
            if(x+1<n&&y+1<m){
                String key=(x+1)+"-"+(y+1);
                int count=hm.getOrDefault(key,0);
                hm.put(key,count+1);
            }

        }
        long[] ans=new long[5];
        long sum=0;
        for(String key:hm.keySet()){
            sum+=hm.get(key);
            ans[hm.get(key)]++;
        }
        ans[0]=(long)(n-1)*(m-1)-hm.size();
        return ans;
    }
}