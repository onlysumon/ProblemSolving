import java.util.Arrays;

public class GroupSum {

	/**
	 * Group sum with subtraction
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean groupSum(int[] nums, int target) {
		return groupSumRec(nums, target, 0);
	}

	/**
	 * Group sum by summing up
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean groupSum2(int[] nums, int target) {
		return groupSumRec2(nums, target, 0, 0);
	}

	/**
	 * Find the Power Set of the given numbers
	 * 
	 * @param nums
	 */
	public void powerSet(int[] nums) {
		powerSetRec(nums, 0, new int[] {});
	}

	private boolean groupSumRec(int[] nums, int target, int i) {
		if (i == nums.length) {
			return 0 == target;
		}
		/*
		 * Two cases: 1. Include current number (nums[i]) 2. Do NOT include current
		 * number (nums[i])
		 */
		return groupSumRec(nums, target - nums[i], i + 1) 
				|| groupSumRec(nums, target, i + 1);
	}

	private boolean groupSumRec2(int[] nums, int target, int i, int sum) {
		if (i == nums.length) {
			return sum == target;
		}
		// Same 2 scenarios: add current number or not
		return groupSumRec2(nums, target, i + 1, sum + nums[i]) 
				|| groupSumRec2(nums, target, i + 1, sum);
	}

	private void powerSetRec(int[] nums, int i, int[] currentElement) {
		if (i == nums.length) {
			System.out.println(Arrays.toString(currentElement));
			return;
		}
		// Create new array as array is object and lives in Java Heap shared memory
		int[] withCurrentNumber = new int[currentElement.length + 1];
		System.arraycopy(currentElement, 0, withCurrentNumber, 0, currentElement.length);
		withCurrentNumber[withCurrentNumber.length - 1] = nums[i];
		// case 1: With current number
		powerSetRec(nums, i + 1, withCurrentNumber);
		// case 2: Without current number
		powerSetRec(nums, i + 1, currentElement);
	}

}
