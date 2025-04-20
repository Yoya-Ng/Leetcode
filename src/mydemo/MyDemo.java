/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydemo;

import java.util.*;

/**
 * @author Tian
 */
public class MyDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(
//                Arrays.toString(Solution.twoSum(new int[]{3, 4, 5, 6}, 7)) +
//                        Arrays.toString(Solution.twoSum(new int[]{4, 5, 6}, 10)) +
//                        Arrays.toString(Solution.twoSum(new int[]{5, 5}, 10))

//                Input: strs = ["act","pots","tops","cat","stop","hat"]
//                Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
//                Solution.groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"})

//                Arrays.toString(Solution.topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2))

//                Input: ["neet","code","love","you"]
//                Output:["neet","code","love","you"]
//                Solution.decode(
//                        Solution.encode(List.of("we", "say", ":", "yes", "!@#$%^&*()"))
//                )

//                Input: nums = [1,2,4,6]
//                Output: [48,24,12,8]
//                Solution.productExceptSelf(new int[]{1, 2, 4, 6})


//                Input: board =
//        [["1","2",".",".","3",".",".",".","."],
//         ["4",".",".","5",".",".",".",".","."],
//         [".","9","8",".",".",".",".",".","3"],
//         ["5",".",".",".","6",".",".",".","4"],
//         [".",".",".","8",".","3",".",".","5"],
//         ["7",".",".",".","2",".",".",".","6"],
//         [".",".",".",".",".",".","2",".","."],
//         [".",".",".","4","1","9",".",".","8"],
//         [".",".",".",".","8",".",".","7","9"]]
//                Output: true
                Solution.isValidSudoku(new char[][]{
                        {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                        {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                        {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                        {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                })

        );
    }
}

class Solution {
    // Two Sum - Easy
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int x = target - nums[i];
                if (nums[j] == x) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Group Anagrams - Medium
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            res.putIfAbsent(new String(c), new ArrayList<>());
            res.get(new String(c)).add(s);
        }
        return new ArrayList<>(res.values());
    }

    //Top K Frequent Elements - Medium
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }

        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }

    // Encode and Decode Strings - Medium
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> ls = new ArrayList<>();
        int start = 0;
        while (str.length() != start) {

            int index = str.indexOf("#", start);
            int number = Integer.parseInt(str.substring(start, index));
            start = number + index + 1;
            String request = str.substring(index + 1, start);
            ls.add(request);
        }
        return ls;
    }

    // Products of Array Except Self Medium
    public static int[] productExceptSelf(int[] nums) {

        int[] ints = new int[nums.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                ints[i] *= nums[j];
            }
        }
        return ints;
    }

    // Valid Sudoku Medium
    public static boolean isValidSudoku(char[][] board) {
        for ( char[] row : board){
            if( hasDuplicate(row) ) return false;
        }
        for (int i = 0; i < 9; i++) {
            if( hasDuplicate(board[i]) ) return false;
            boolean[] seen = new boolean[10]; // 假設值範圍是 0~10000
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[j][i])) {
                    if (seen[board[j][i] - '0']) return true;
                    seen[board[j][i] - '0'] = true;
                }
            }


        }

        return true;
    }

    public static boolean hasDuplicate(char[] nums) {
        boolean[] seen = new boolean[10]; // 假設值範圍是 0~10000
        for (char num : nums) {
            if (Character.isDigit(num)) {
                if (seen[num - '0']) return true;
                seen[num - '0'] = true;
            }
        }
        return false;
    }
}

