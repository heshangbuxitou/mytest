package com.zy.algorithm;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || (k %= nums.length) == 0) {
            return;
        }
        int start = 0;
        int index = 0;
        int frontValue = nums[start];
        // 走的步数
        int loop = 0;
        // 采用走一步，转移一步的策略，注意长度能被整除时有循环。
        while (loop++ < nums.length) {
            index = (index + k) % nums.length;
            int temp = nums[index];
            nums[index] = frontValue;
            if (index == start) {
                index++;
                start++;
                frontValue = nums[index];
            } else {
                frontValue = temp;
            }
        }
    }

    public void rotate2(int[] nums, int k) {
        if (nums.length == 0 || (k %= nums.length) == 0) {
            return;
        }
        rotate2(nums, 0, nums.length - k, k);
        rotate2(nums, nums.length - k, nums.length, k);
        rotate2(nums, 0, nums.length, k);
    }

    public void rotate2(int[] nums, int start, int end, int k) {
        end--;
        while (start < end) {
            System.out.println("start:" + start + ",end:" + end);
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[list.size()];
        for (i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index >= 0) {
            if (++digits[index] == 10) {
                digits[index--] = 0;
            } else {
                break;
            }
        }
        if (index == -1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }

        return digits;
    }

    public void moveZeroes(int[] nums) {
        int count0 = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] == 0) {
                count0++;
            } else {
                int temp = nums[i];
                nums[i] = nums[i - count0];
                nums[i - count0] = temp;
            }
        }
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public void twoSumBySortArray(int[] nums, int target) {
        /**
         * 有序数组中找两个数的和
         */
        Optional.ofNullable(nums).filter(array -> array.length > 2).map(array -> {
            for (int front = 0, end = array.length - 1; front < end; ) {
                if (array[front] + array[end] == target) {
                    System.out.println(array[front] + "+++++++" + array[end]);
                    front++;
                    end--;
                } else if (array[front] + array[end] <= target) {
                    front++;
                } else {
                    end--;
                }
            }
            return null;
        });
    }

    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        boolean[][] rowExist = new boolean[len][len];
        boolean[][] colExist = new boolean[len][len];
        boolean[][] cellExist = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if ('1' <= board[i][j] && board[i][j] <= '9') {
                    int num = board[i][j] - '1';
                    if (rowExist[i][num] || colExist[j][num] || cellExist[3 * (i / 3) + j / 3][num]) {
                        return false;
                    }
                    rowExist[i][num] = colExist[j][num] = cellExist[3 * (i / 3) + j / 3][num] = true;
                }
            }
        }
        return true;
    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        // 按对角线反转
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][len - 1 - i];
                matrix[len - 1 - j][len - 1 - i] = temp;
            }
        }
        // 按列反转
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void outputMT(int[][] matrix) {
        int total = 0;
        int len = matrix.length;
        for (int i = len - 1, j = 0; i >= 0; i--) {
            int count = 0;
            while ((i + count) < len && (j + count) < len) {
                System.out.print(matrix[j + count][i + count] + " ");
                count++;
                total++;
            }
            System.out.println();
        }
        for (int i = 1, j = 0; i < len; i++) {
            int count = 0;
            while ((i + count) < len && (j + count) < len) {
                System.out.print(matrix[i + count][j + count] + " ");
                count++;
                total++;
            }
            System.out.println();
        }
        System.out.println("循环次数:" + total);
    }

    public void outputMT2(int[][] matrix) {
        int count = 0;
        int size = matrix.length;
        //一共生成几行结果
        int len = 2 * matrix.length - 1;
        for (int k = 0; k < len; k++) {
            //规律是第 K的 列号-行号=size-1-k
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    count++;
                    if (j - i == size - 1 - k) {
                        System.out.print(matrix[i][j] + " ");
                    }
                }
            }
            System.out.println("");
        }
        System.out.println("循环次数:" + count);
    }

    public String reverseString(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        return new StringBuffer(s).reverse().toString();
    }

    public String reverseString2(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        return s.charAt(0) + reverseString2(s);
    }

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int temp = x % 10;
            result = result * 10 + temp;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public int firstUniqChar(String s) {
        return Optional.ofNullable(s).map(string -> {
            // 算法复杂度O（26n）即O(n)
            int res = -1;
            for (char ch = 'a'; ch <= 'z'; ch++) {
                int front = s.indexOf(ch);
                if (front != -1 && front == s.lastIndexOf(ch)) {
                    res = (res == -1) ? front : Math.min(front, res);
                }
            }
            return res;
        }).orElse(-1);
    }

    public boolean isAnagram(String s, String t) {
        int[] ints = new int[26];
        for (char charAt : s.toCharArray()) {
            ints[charAt - 'a']++;
        }

        for (char charAt : t.toCharArray()) {
            if (ints[charAt - 'a'] > 0) {
                ints[charAt - 'a']--;
            } else {
                return false;
            }
        }
        for (int i : ints) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        // 复杂度 O(n+2/n) 即O(n)
        for (char a : s.toCharArray()) {
            if (Character.isLetterOrDigit(a)) {
                sb.append(Character.toLowerCase(a));
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public int myAtoi(String str) {
        String start = " +-";
        int result;
        Boolean flag = true;
        StringBuffer sb = new StringBuffer();
        for (char charAt : str.toCharArray()) {
            if (flag) {
                if (!Character.isDigit(charAt) && start.indexOf(charAt) == -1) {
                    return 0;
                } else if (charAt == ' ') {
                } else {
                    sb.append(charAt);
                    flag = false;
                }
            } else {
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                } else {
                    break;
                }
            }
        }
        try {
            result = Integer.valueOf(sb.toString());
        } catch (NumberFormatException e) {
            if (sb.length() > 2) {
                return sb.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                return 0;
            }
        }
        return result;
    }

    public int strStr(String haystack, String needle) {
        // 子字符串查找问题
        int num = needle.length();
        for (int i = 0; i < haystack.length() - num + 1; i++) {
            if (haystack.substring(i, i + num).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            int count = 0;
            StringBuffer sb = new StringBuffer();
            for (int j = 0, len = result.length(); j < len; j++) {
                if ((j + 1 < len) && result.charAt(j) == result.charAt(j + 1)) {
                    count++;
                } else {
                    sb.append(++count);
                    sb.append(result.charAt(j));
                    count = 0;
                }
            }
            result = sb.toString();
        }
        return result;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        String commonPrefix = strs[0];
        for (String s : strs) {
            while (s.indexOf(commonPrefix) != 0) {
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
                if (commonPrefix.isEmpty()) {
                    return "";
                }
            }
        }
        return commonPrefix;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 采用两个指针的方法来删除
        ListNode front = head;
        ListNode bankend = head;
        while (n > 0 || (front != null && front.next != null)) {
            if (n <= 0) {
                bankend = bankend.next;
            }
            front = front.next;
            n--;
        }
        if (front == null) {
            return bankend.next;
        }
        bankend.next = bankend.next.next;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = head;
        head = head.next;
        preNode.next = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = preNode;
            preNode = temp;
        }
        return preNode;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }
        ListNode merge = new ListNode(0);
        ListNode tailNode = merge;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tailNode.next = l1;
                l1 = l1.next;
            } else {
                tailNode.next = l2;
                l2 = l2.next;
            }
            tailNode = tailNode.next;
        }
        if (l1 != null) {
            tailNode.next = l1;
        } else {
            tailNode.next = l2;
        }
        return merge.next;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        //当链表为奇数个时，跳过中间元素
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            //如果两者不相同，则该链表不是回文串
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left > right) ? left : right + 1;
    }

    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return isBSTInOrder(root, Integer.MIN_VALUE);
    }

    private boolean isBSTInOrder(TreeNode root, int prev) {
        if (root == null) {
            return true;
        }
        if (isBSTInOrder(root.left, prev)) {
            System.out.println(root.val + ":" + prev);
            if (root.val > prev) {
                prev = root.val;
                return isBSTInOrder(root.right, prev);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

    public int fibonacci(int n) {
        int front = 1;
        int end = 1;
        for (int i = 0; i < n - 2; i++) {
            int temp = front;
            front = end + front;
            end = temp;
        }
        return front;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for(int i=1; i < 11;i ++){
            System.out.println(solution.fibonacci(1000));
        }
        //1,2,3,3,4,4,5
//        int[] nums1 = new int[]{-8, -4, -1, 0, 1, 3, 4, 5, 6, 7, 9};
//        solution.twoSumBySortArray(null, 10);
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        solution.outputMT(matrix2);
//        solution.outputMT2(matrix2);
//        Stream<String> stringStream = Files.lines(Paths.get("test.text"), StandardCharsets.UTF_8);
        String[] strs = {"c", "acc", "ccc"};
        System.out.println(solution.longestCommonPrefix(strs));
        System.out.println("123".substring(0, 0));
        String s = "Iam君山";
        System.out.println(s);
    }
}



