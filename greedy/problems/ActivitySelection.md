```java
// You are using Java
import java.util.*;

class Main {

    static class Activity {
        String name;
        int start;
        int end;

        Activity(String name, int start, int end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return name + "(" + start + "," + end + ")";
        }
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        ArrayList<Activity> activities = new ArrayList<>();

        // Input: name, start time, end time
        for (int i = 0; i < n; i++) {
            String name = obj.next();
            int start = obj.nextInt();
            int end = obj.nextInt();
            activities.add(new Activity(name, start, end));
        }

        // Sort by end time using lambda + Integer.compare
        Collections.sort(activities, (a, b) -> Integer.compare(a.end, b.end));

        ArrayList<String> selected = new ArrayList<>();
        int lastEndTime = -1;

        // Select non-overlapping activities
        for (Activity act : activities) {
            if (act.start >= lastEndTime) {
                selected.add(act.name);
                lastEndTime = act.end;
            }
        }

        // Output the selected activities
        System.out.println("Selected Activities are:");
        for (String name : selected) {
            System.out.print(name + " ");
        }
    }
}
````