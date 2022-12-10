
public class FindPivotIndex {
	// can also approach this with derivative concept
	public static int pivotIndex(int[] nums) {

//		int leftidx = 0;
//		int rightidx = nums.length - 1;
//		int sumleft = nums[leftidx];
//		int sumright = nums[rightidx];
//
//		while (leftidx < rightidx) {
//			System.out.println(leftidx + " " + rightidx);
//			System.out.println(nums[leftidx] + " " + nums[rightidx]);
//			System.out.println(sumleft + " " + sumright);
//			System.out.println("-------------------");
//			if (sumleft == sumright) {
//				leftidx++;
//				rightidx--;
//				sumleft += nums[leftidx];
//				sumright += nums[rightidx];
//			} else if (sumleft < sumright) {
//				leftidx++;
//				sumleft += nums[leftidx];
//			} else {
//				rightidx--;
//				sumright += nums[rightidx];
//			}
//
//		}
//
//		if (sumleft == sumright && leftidx == rightidx) {
//			return leftidx;
//		}

		int pivotidx = 0;
		int leftsum = 0;
		int rightsum = 0;
		int totalsum = 0;

		for (int i = 0; i < nums.length; i++) {
			totalsum += nums[i];
		}

		for (int piv = 0; piv < nums.length; piv++) {

			for (int i = 0; i < piv; i++) {
				leftsum += nums[i];
			}

			if (leftsum == totalsum - leftsum - nums[piv]) {
				return piv;
			}

			System.out.println(leftsum + " " + (totalsum - leftsum - nums[piv]));
			leftsum = 0;
			rightsum = 0;

		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 7, 3, 6, 5, 6 };

		System.out.println(pivotIndex(nums));

	}
}
