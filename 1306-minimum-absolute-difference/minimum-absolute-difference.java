class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans=new ArrayList<>();
        int n=arr.length,minDif=arr[n-1]-arr[0];

        for(int i=1;i<n;i++)minDif=Math.min(minDif,arr[i]-arr[i-1]);

        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]==minDif){
                List<Integer> temp=new ArrayList<>();
                temp.add(arr[i-1]);temp.add(arr[i]);
                ans.add(temp);
            }
        }
        return ans;

    }
}