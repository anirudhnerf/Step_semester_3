package string.assigment_problems;

public class TrafficSignalStreakAnalyzer {

    // Finds the longest run of the same signal color
    static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) {
            System.out.println("No signal readings found");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestLength = 1;
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentLength++;   // streak continues
            } else {
                currentLength = 1; // new streak starts
            }

            // Keep a running record of the longest streak so far
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}