// Last updated: 20/04/2025, 14:10:17
class Solution {
    public int numRabbits(int[] answers) {
        int n=answers.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int x:answers){
            int count=hm.getOrDefault(x,0);
            hm.put(x,count+1);
        }
        int ans=0;
        for(Integer key:hm.keySet()){
            int temp=hm.get(key)/(key+1);
            if(hm.get(key)%(key+1)>0)temp++;
            ans+=temp*(key+1);
        }
        return ans;
    }
}