// Last updated: 16/04/2025, 22:16:14
class Solution {
    class FenWickTree{
        int n;
        int[] bit;
        FenWickTree(int n){
            this.n=n;
            bit=new int[n+1];
        }

        void update(int i,int delta){
            for(;i<=n;i+=(i&-i)){
                bit[i]+=delta;
            }
        }

        int sum(int i){
            int ans=0;
            for(;i>0;i-=(i&-i)){
                ans+=bit[i];
            }
            return ans;
        }


    }
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int[] num1ToIdx=new int[n];

        for(int i=0;i<n;i++){
            num1ToIdx[nums1[i]]=i;
        }
        int[] left=new int[n];
        FenWickTree tree1=new FenWickTree(n);
        for(int i=0;i<n;i++){
            int idxInNums1=num1ToIdx[nums2[i]];
            left[i]=tree1.sum(idxInNums1+1);
            tree1.update(idxInNums1+1,1);
        }

        FenWickTree tree2=new FenWickTree(n);
        int[] right=new int[n];
        for(int i=n-1;i>=0;i--){
            int idxInNums1=num1ToIdx[nums2[i]];
            right[i]=tree2.sum(n)-tree2.sum(idxInNums1+1);
            tree2.update(idxInNums1+1,1);
        }
        long ans=0;
         for(int i=0;i<n;i++){
            ans+=1L*left[i]*right[i];
            // System.out.println(left[i]+" "+right[i]);
         }
        
         return ans;
        
    }
}