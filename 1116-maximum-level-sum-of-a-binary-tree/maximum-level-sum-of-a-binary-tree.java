/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer,Integer> sum;
    public int maxLevelSum(TreeNode root) {
        sum=new HashMap<>();
        dfs(root,1);
        int mx=Integer.MIN_VALUE,ans=1_000_0+1;
        for(int level:sum.keySet()){
            if(mx==sum.get(level)){
                ans=Math.min(ans,level);
                
            }
            else if(mx<sum.get(level)){
                ans=level;
                mx=sum.get(level);
            }
        }
        return ans;
    }
    void dfs(TreeNode root,int level){
        if(root==null)return;
        sum.put(level,sum.getOrDefault(level,0)+root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}