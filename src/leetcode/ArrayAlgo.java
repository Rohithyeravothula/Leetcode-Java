package leetcode;

import java.util.*;

public class ArrayAlgo {
    public int singleNumber(int[] nums){
        int ans=0;
        for(int cur: nums){
            ans = ans^cur;
        }
        return ans;
    }

    public String getfizzBuzz(int n){
        StringBuilder sb = null;

        if(n%3==0){
            sb = new StringBuilder();
            sb.append("Fizz");
        }

        if (n%5 == 0) {
            if(sb == null)
                sb = new StringBuilder();
            sb.append("Buzz");
        }

        if(sb == null)
            return Integer.toString(n);
        return sb.toString();
    }

    public List<String> fizzBuzz(int n){
        List<String> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            ans.add(getfizzBuzz(i));
        }
        return ans;
    }

    public void testSingleNumber() {
        int[] nums = {1, 2, 2,3,1};
        System.out.println(singleNumber(nums));
    }

    public void testFizzBuzz(){
//        System.out.println(getfizzBuzz(15));
        List<String> ans = fizzBuzz(20);
        System.out.println(ans);
    }

    public int majorityElement(int[] nums){
        int ans=Integer.MAX_VALUE, count=0;
        for(int cur: nums){
            if(cur == ans){
                count++;
            }
            else if (count == 0){
                count++;
                ans = cur;
            }
            else{
                count--;
            }
        }
        return ans;
    }

    public void testMajorityElement(){
        int[] a = {1,2,2,2,3};
        System.out.println(majorityElement(a));
    }

    public HashMap<Integer, Integer> getCounts(int[] nums){
        HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();
        for(int cur: nums){
            if(left.containsKey(cur))
                left.put(cur, left.get(cur)+1);
            else
                left.put(cur, 1);
        }
        return left;
    }

    public int[] intersect1(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index=0;
        int[] ans = new int[Math.max(nums1.length, nums2.length)];
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                ans[index] = nums1[i];
                index++;
                i++;
                j++;
            } else if(nums1[i] < nums2[j]){
                i++;
            } else{
                j++;
            }
        }
        int[] final_ans = new int[index];
        for(i=0;i<index;i++)
            final_ans[i] = ans[i];
        return final_ans;

    }

    public int[] intersect(int[] nums1, int[] nums2){
        Queue<Integer> left = new PriorityQueue<>();
        Queue<Integer> right = new PriorityQueue<>();
        int[] temp = new int[Math.max(nums1.length, nums2.length)];
        int index=0;
        for(int cur: nums1)
            left.add(cur);
        for(int cur: nums2)
            right.add(cur);
        while(!left.isEmpty() && !right.isEmpty()){
            if(left.peek().equals(right.peek())){
                temp[index] = left.poll();
                right.poll();
                index++;
            } else if(left.peek() < right.peek()){
                left.poll();
            } else{
                right.poll();
            }
        }

        int[] ans = new int[index];
        for(int i=0;i<index;i++)
            ans[i] = temp[i];
        return ans;
    }

    public void testIntersection(){
        int[] nums1 = {1,2,3,3,3,4};
        int[] nums2 = {7,8,2,3,3};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public int[] twoSum1(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int i=0,j=length-1, cur;
        while(i<j){
            cur = nums[i]+nums[j];
            if(cur == target)
                return new int[]{i,j};
            else if(cur < target)
                i++;
            else
                j--;
        }
        return new int[2];
    }

    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> indices = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(indices.containsKey(target-nums[i]))
                return new int[]{indices.get(target-nums[i]), i};
            indices.put(nums[i], i);
        }
        return null;
    }

    public boolean isPowerOfThree(int n){
        int val = (int) Math.pow(3, 10);
        return val%n==0;
    }


    public void testTwoSum(){
        int[] a = {5,2,3,1,1,2,3,8};
        System.out.println(Arrays.toString(twoSum(a, 8)));
    }

    public int removeDuplicates(int[] nums){
        int index=0,prev=Integer.MAX_VALUE;
        for(int cur: nums){
            if(cur != prev){
                nums[index] = cur;
                index++;
                prev = cur;
            }
        }
        return index;
    }

    public void testRemoveduplicates(){
        int[] a = {1,1,2,2,3,3,3,3,4};
        int[] newa = Arrays.copyOfRange(a, 0, removeDuplicates(a));
        System.out.println(Arrays.toString(newa));
    }

    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>-1;i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] updated = new int[digits.length+1];
        updated[0]=1;
        return updated;
    }

    public void testplusOne(){
        int[] digits = {8,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=nums1.length-1,i=m-1,j=n-1;
        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j])
                nums1[index--] = nums1[i--];
            else
                nums1[index--] = nums2[j--];
        }
        while(i>=0){
            nums1[index--] = nums1[i--];
        }
        while(j>=0)
            nums1[index--] = nums2[j--];
    }

    public void testMerge(){
        int[] a = {1,5,13};
        int[] b = {};
        merge(a, 3, b, b.length);
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        ArrayAlgo arrayAlgo = new ArrayAlgo();
        arrayAlgo.testMerge();
    }
}
