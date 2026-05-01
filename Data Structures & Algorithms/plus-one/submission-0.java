class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> li = new ArrayList<>();
        int n = digits.length;

        int carry = 1; // initially adding 1

        for (int i = n - 1; i >= 0; i--) {
            int no = digits[i] + carry;

            carry = no / 10;
            no = no % 10;

            li.add(no);
        }

        if (carry > 0) {
            li.add(carry);
        }

        Collections.reverse(li);

        int[] ans = new int[li.size()];

        for (int i = 0; i < li.size(); i++) {
            ans[i] = li.get(i);
        }

        return ans;
    }
}