class Solution {
    private void dfs(int[] candidates, int target, int index, List<Integer> currList, List<List<Integer>> result) {
        if (target < 0 || index >= candidates.length) return;
        if (target == 0) {
            result.add(new ArrayList<Integer>(currList));
            return;
        }
        currList.add(candidates[index]);
        dfs(candidates, target - candidates[index], index, currList, result);
        currList.remove(currList.size() - 1);
        dfs(candidates, target, index + 1, currList, result);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        dfs(candidates, target, 0, currList, result);
        return result;
    }
}
