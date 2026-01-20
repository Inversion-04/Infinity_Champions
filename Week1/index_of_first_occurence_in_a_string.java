public class index_of_first_occurence_in_a_string {

    // Brute Force
    // Time Complexity: O(n^3)
    // Space Complexity: O(n)
    public int strStrBrute(String haystack, String needle) {
        int idx = -1;

        for (int i = 0; i < haystack.length(); i++) {
            for (int j = i + 1; j <= haystack.length(); j++) {
                String substr = haystack.substring(i, j);
                if (substr.equals(needle)) {
                    idx = i;
                    break;
                }
            }
            if (idx != -1) {
                break;
            }
        }
        return idx;
    }

    // Optimized
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int strStrOptimized(String haystack, String needle) {
        StringBuilder sb = new StringBuilder(haystack);
        return sb.indexOf(needle);
    }

    public static void main(String[] args) {
        index_of_first_occurence_in_a_string obj =
                new index_of_first_occurence_in_a_string();

        String haystack = "hello";
        String needle = "ll";

        System.out.println(obj.strStrBrute(haystack, needle));
        System.out.println(obj.strStrOptimized(haystack, needle));
    }
}
