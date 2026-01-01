class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> ans=new ArrayList<>();
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            int cur=digits[i]+carry;
            ans.add(cur%10);
            carry=cur/10;
        }
        if(carry!=0)ans.add(carry);
        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}