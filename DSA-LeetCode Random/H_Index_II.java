// https://leetcode.com/problems/h-index-ii/description/

public class H_Index_II {
    public static void main(String[] args) {
        int[] citations = { 0, 1, 3, 5, 6 };
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int low = 0, high = citations.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (citations[mid] == citations.length - mid) {
                return citations[mid];
            } else if (citations[mid] > citations.length - mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return citations.length - low;
    }
}