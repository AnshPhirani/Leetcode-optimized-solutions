class Solution {
    public String reverseWords(String s) {
        String[] ans = Arrays.stream(s.split(" ")).map((word) -> new StringBuilder(word).reverse().toString()).toArray(String[]::new);
        return String.join(" ", ans);
    }
}