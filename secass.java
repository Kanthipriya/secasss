import java.util.*;
public class CombinationSum240 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, result, new ArrayList<>(), target, 0);
        return result;
    }

    public void backtrack(int[] candidates, List<List<Integer>> result, List<Integer> partialList,
                          int remain, int start) {
        if (remain < 0)
            return;
        else if (remain == 0)
            result.add(new ArrayList<>(partialList));
        else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1])
                    continue;
                ;
                partialList.add(candidates[i]);
                backtrack(candidates, result, partialList, remain - candidates[i], i + 1);
                partialList.remove(partialList.size() - 1);
            }
        }
    }
}