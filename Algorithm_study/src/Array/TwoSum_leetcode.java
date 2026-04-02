package Array;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
class TwoSum_leetcode {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for(int i=0 ; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++) {
            int nowNum = target - nums[i];
            if(map.containsKey(nowNum) && map.get(nowNum) > i) {
                return new int[]{map.get(nowNum), i};
            }
        }

        return null; 
    }

}
