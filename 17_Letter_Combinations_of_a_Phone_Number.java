import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] phone = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        generate(digits, 0, "", phone, result);

        return result;
    }

    private void generate(String digits, int index, String current,
                           String[] phone, List<String> result) {

        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = phone[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            generate(digits, index + 1, current + c, phone, result);
        }
    }
}
