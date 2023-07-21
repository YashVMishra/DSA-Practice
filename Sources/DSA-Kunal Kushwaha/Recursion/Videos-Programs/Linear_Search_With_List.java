
import java.util.ArrayList;

class Linear_Search_With_List {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 4, 5 };
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(findAllIndex(arr, 4, 0, list));
        System.out.println(findAllIndex2(arr, 4, 0));
    }

    // Passing the returning list among the parameters.
    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        return findAllIndex(arr, target, index + 1, list);
    }

    // Making new list in every function call and returning its answer to the
    // previous calls.
    // vet important concept.
    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        ArrayList<Integer> ansFromBelowCalls = findAllIndex2(arr, target, index + 1);

        list.addAll(ansFromBelowCalls);

        return list;
    }
}
