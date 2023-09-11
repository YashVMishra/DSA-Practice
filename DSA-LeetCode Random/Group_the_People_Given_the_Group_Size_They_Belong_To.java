// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/description/?envType=daily-question&envId=2023-09-11

import java.util.ArrayList;
import java.util.List;

public class Group_the_People_Given_the_Group_Size_They_Belong_To {
    public static void main(String[] args) {
        int[] groupSizes = { 2, 1, 3, 3, 3, 2 };
        System.out.println(groupThePeople(groupSizes));
    }

    // take sometime understanding the question.
    // and then dry run the code.
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> grpID = new ArrayList<>();

        // we have written groupSizes.length + 1 because
        // the value in groupSizes array can be from 1 to groupSizes.length
        // both inclusive.
        for (int i = 0; i < groupSizes.length; i++) {
            grpID.add(new ArrayList<>());
        }

        // clubbing people with same group size.
        for (int i = 0; i < groupSizes.length; i++) {
            grpID.get(groupSizes[i]).add(i);
        }

        for (int i = 1; i < grpID.size(); i++) {
            List<Integer> temp = new ArrayList<>();

            // main logic.
            // dry run for better understanding.
            for (int j = 0; j < grpID.get(i).size(); j++) {

                // for every groupsize we have to club them in groups of i.
                temp.add(grpID.get(i).get(j));

                // as soon as the size of temp reaches i, we add it to ans.
                // coz a maximum of i people can be in a group.
                if (temp.size() == i) {
                    ans.add(temp);
                    temp = new ArrayList<>();
                }
            }
        }

        return ans;
    }
}
