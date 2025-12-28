import java.util.*;

class Solution {

    static class Node implements Comparable<Node> {
        int val, idx;
        Node(int v, int i) {
            val = v;
            idx = i;
        }

        // IMPORTANT: compare only by value (like C++ set)
        public int compareTo(Node o) {
            return Integer.compare(this.val, o.val);
        }
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        TreeSet<Node> set = new TreeSet<>();
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            Node cur = new Node(nums[i], i);

            // ignore duplicates
            if (set.contains(cur)) continue;

            set.add(cur);

            // remove next bigger element
            Node higher = set.higher(cur);
            if (higher != null) set.remove(higher);

            // link parent
            Node lower = set.lower(cur);
            if (lower != null)
                parent[i] = lower.idx;
        }

        // ---- sequence reconstruction (optional) ----
        List<Integer> lis = new ArrayList<>();
        int idx = set.last().idx;
        while (idx != -1) {
            lis.add(nums[idx]);
            idx = parent[idx];
        }
        Collections.reverse(lis);

        // Uncomment for debugging locally
        // System.out.println("LIS Sequence: " + lis);

        return set.size();
    }
}
