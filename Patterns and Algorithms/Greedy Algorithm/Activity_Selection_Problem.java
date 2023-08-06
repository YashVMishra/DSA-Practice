import java.util.Collections;
import java.util.ArrayList;

public class Activity_Selection_Problem {
    public static void main(String[] args) {
        int start[] = { 1, 3, 2, 5 };
        int end[] = { 2, 4, 3, 6 };
        System.out.println(activitySelection(start, end, 4));
    }

    static class Activity {
        int start;
        int end;

        Activity(int start, int finish) {
            this.start = start;
            this.end = finish;
        }
    }

    public static int activitySelection(int start[], int end[], int n) {
        // add your code here
        // making an array of Activity class
        Activity[] arr = new Activity[n];

        // adding the start and end time in the array
        for (int i = 0; i < n; i++) {
            arr[i] = new Activity(start[i], end[i]);
        }

        // creation of list
        ArrayList<Activity> list = new ArrayList<>();

        // adding it in the list so that we can sort then acc to the end time.
        for (int i = 0; i < n; i++) {
            list.add(arr[i]);
        }

        // sorting acc to end time.
        Collections.sort(list, (a, b) -> a.end - b.end);

        int count = 1;

        // current activity refers to the end time of the first list item.
        int curr_activity = list.get(0).end;

        for (int i = 1; i < n; i++) {
            if (list.get(i).start > curr_activity) {
                count++;
                curr_activity = list.get(i).end;
            }
        }

        return count;
    }

}