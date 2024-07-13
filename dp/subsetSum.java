package allmethod.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class subsetSum {

    public static boolean hasSubsetSum(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Base cases:
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; // Any subset can sum to 0
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false; // Empty set cannot sum to a non-zero value
        }

        // Fill the dp table using top-down approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    // Include or exclude the current element
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    // Exclude the current element (as it's too large)
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }


        return dp[n][sum];
    }
 static int minSum(int[] arr, int sum) {
        int n = arr.length;

        // dp[i][j] will be true if there is a subset with sum j in arr[0..i-1]
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the last row where dp[n][j] is true for maximum j
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j <= sum / 2; j++) {
            if (dp[n][j]) {
                list.add(j);
            }
        }

        // Find the minimum subset sum difference
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < list.size(); k++) {
            min = Math.min(min, sum - 2 * list.get(k));
        }

        return min;
    }
//static int targetSum(int []arr,int targetSum,int i,int sign){
//        if(targetSum==0||i==arr.length){
//            return 1;
//        }
//        if(arr[i]>targetSum){
//            arr[i]*=-1;
//           targetSum(arr,targetSum,i,1);
//        }
//       else{
//        targetSum(arr,targetSum-arr[i],i+1,1);
//        targetSum(arr,targetSum-arr[i],i+1,-1);
//
//
//       }
//}
    static int min(int[]arr,int n){
        if(n==0){
            return arr[0];
        }
        return arr[n]<min(arr,n-1)?arr[n]:arr[n-1];
    }
    static void subset(String input,String output){
        if(input.length()==0){
            System.out.print(output+",");
            return;
        }
        String output1=output;
        String output2=output;
        output2+=input.charAt(0);
        input=input.substring(1);
        subset(input,output1);
        subset(input,output2);

    }

    public static void main(String[] args) {
        List<Object>list=new ArrayList<>();
        list.add(2);
        list.add(21);
        list.add(12);
        list.add(23);
        System.out.println(list.get(0));

        int doublearr[][]={{1,2,1,3},{23,1,2,13}};
//        for(int []nums:doublearr){
//            System.out.println(nums[0]);
//        }
        int[] nums = {3, 34, 4, 12, 5, 2};
        int sum = 9;

//        if (hasSubsetSum(nums, sum)) {
//            System.out.println("There exists a subset with sum " + sum);
//        } else {
//            System.out.println("No subset with sum " + sum + " exists");
//        }
        int arr[]={34,12,1,-3,23};
//        System.out.println(min(arr,4));
        subset("abc","");

    }
}
