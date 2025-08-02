class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l1 = nums1.length, l2 = nums2.length;
        int totalLen = l1 + l2;

        int l = -1, r = l1;

        while (r - l > 1) {
            int m = l + (r - l) / 2;
            int partX = m;
            int partY = (totalLen + 1) / 2 - (partX+1) - 1; 
            // Explanation:
            // nums1's left partition is [0..partX], so left max at nums1[partX]
            // nums2's left partition is [0..partY], note offset by -2 due to zero indexing adjustment

            double leftX = (partX < 0) ? Integer.MIN_VALUE : nums1[partX];
            double rightX = (partX + 1 >= l1) ? Integer.MAX_VALUE : nums1[partX + 1];

            double leftY = (partY < 0) ? Integer.MIN_VALUE : nums2[partY];
            double rightY = (partY + 1 >= l2) ? Integer.MAX_VALUE : nums2[partY + 1];

            if (leftX <rightY) {
                l = m;
            } else {
                r = m;
            }
        }

        int partX = l;
        int partY = (totalLen + 1) / 2 - partX - 2;

        double leftX = (partX < 0) ? Integer.MIN_VALUE : nums1[partX];
        double rightX = (partX + 1 >= l1) ? Integer.MAX_VALUE : nums1[partX + 1];

        double leftY = (partY < 0) ? Integer.MIN_VALUE : nums2[partY];
        double rightY = (partY + 1 >= l2) ? Integer.MAX_VALUE : nums2[partY + 1];

        if ((totalLen & 1) == 1) {
            return Math.max(leftX, leftY);
        } else {
            return (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2.0;
        }
    }
}
