class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> cur;
        sort(candidates.begin(), candidates.end());
        solve(0, candidates, target, ans, cur);
        return ans;
    }

    void solve(int ind, vector<int>& candidates, int target, vector<vector<int>> &ans, vector<int> &cur) {
        if (target == 0) {
            ans.push_back(cur);
            return;
        }
        if (ind >= candidates.size() || target < 0) return;

        // PICK the element at ind
        cur.push_back(candidates[ind]);
        solve(ind + 1, candidates, target - candidates[ind], ans, cur);
        cur.pop_back();

        // SKIP duplicates when not picking
        int next = ind + 1;
        while (next < candidates.size() && candidates[next] == candidates[ind]) {
            next++;
        }

        // NOT PICK
        solve(next, candidates, target, ans, cur);
    }
};
