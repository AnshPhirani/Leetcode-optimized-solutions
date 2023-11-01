class Solution {

    public int[] sortByBits(int[] arr) {
        return Arrays
            .stream(arr)
            .boxed()
            .sorted(
                (a, b) -> {
                    int first = Integer.bitCount(a);
                    int second = Integer.bitCount(b);
                    return (first != second) ? first - second : a - b;
                }
            )
            .mapToInt(i -> i)
            .toArray();
    }
}
