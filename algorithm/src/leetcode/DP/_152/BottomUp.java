package leetcode.DP._152;

public class BottomUp {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = maxProd;
            // minProd * nums[i] 가 음수이고 nums[i] 도 음수이면 더 커질 수 있음
            maxProd = Math.max(nums[i], Math.max(maxProd * nums[i], minProd * nums[i]));
            minProd = Math.min(nums[i], Math.min(temp * nums[i], minProd * nums[i]));
            result = Math.max(result, maxProd);
        }

        return result;
    }
}
