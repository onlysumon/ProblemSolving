public class TwoSum {
  
  public int[] twoSumBruteForce(int[] nums, int target) {
    // Time: O(n*n) Space: O(1)
    for(int i = 0; i < nums.length; i++) {
        for(int j = i + 1; j < nums.length; j++) {
            if(nums[i] + nums[j] == target) {
                return new int[] {i, j};
            }
        }
    }
    return new int[]{};
   }
   
   public int[] twoSumOptimized(int[] nums, int target) {
        // Time: O(n) Space: O(n)
        Map<Integer, Integer> numbersFound = new HashMap<>(nums.length);
        numbersFound.put(nums[0], 0);
        for(int i = 1; i < nums.length; i++) {
            if(numbersFound.containsKey(target - nums[i])) {
                return new int[]{ numbersFound.get(target - nums[i]), i };
            }
            numbersFound.put(nums[i], i);
        }
        return new int[]{};
    }

  public int[] twoSumSorted(int[] nums, int target) {
    // Time: O(n) Space: O(1)
    int i = 0, j = nums.length - 1;
    while(i < j) {
        if(nums[i] + nums[j] == target) {
            // Target found
            return new int[] {i, j};
        } else if(nums[i] + nums[j] > target) {
            j--;
        } else {
            i++;
        }
    }
    return new int[]{};
   }
  
}
