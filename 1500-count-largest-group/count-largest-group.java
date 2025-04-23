class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int ans=0,mx=0;
        for(int i=1;i<=n;i++){
            int temp=i,sum=0;
            for(int j=temp;j>0;j=j/10){
                sum+=j%10;
            }
            int count=hm.getOrDefault(sum,0);
            hm.put(sum,count+1);
        }
        for(Integer key:hm.keySet()){
            if(mx<hm.get(key)){
                mx=hm.get(key);
                ans=1;
            }
            else if(mx==hm.get(key)){
                ans++;
            }
        }
        return ans;
    }
}