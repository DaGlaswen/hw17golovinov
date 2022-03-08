package ru.learnup.march;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        // необходимо ввести в консоль цифры, программа найдет все сочетания 3-х цифр, сумма которых даст 0
        int[] intArgs = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            intArgs[i] = Integer.parseInt(args[i]);
        }
        System.out.println(threeSum(intArgs));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> hashSetResult = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<int[]> currTwoSum = twoSum(nums, -nums[i], i);
            if (currTwoSum.isEmpty()) continue;
            else {
                for (int j = 0; j < currTwoSum.size(); j++){
                    List<Integer> currList = new ArrayList<>();
                    currList.add(nums[i]);
                    currList.add(nums[currTwoSum.get(j)[0]]);
                    currList.add(nums[currTwoSum.get(j)[1]]);
                    Collections.sort(currList);
                    hashSetResult.add(currList);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(hashSetResult);
        return result;

    }

    public static List<int[]> twoSum(int[] nums, int target, int ignoreInd) {
        HashMap<Integer, Integer> tracker = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == ignoreInd) continue;
            int diff = target - nums[i];
            if (tracker.containsKey(diff)){
                result.add(new int[]{tracker.get(diff), i});
            }

            tracker.put(nums[i], i);
        }

        return result;
    }
}
