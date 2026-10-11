package string.assigment_problems;

public class WarehouseInventoryBalancer {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Error: both sections must have the same number of items");
            return;
        }
        if (sectionA.length == 0) {
            System.out.println("Error: no items to analyze");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int highest = Integer.MIN_VALUE;
        String highestSection = "";
        int highestIndex = -1;

        // Section A: add up the quantities and track the highest one
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                highestSection = "A";
                highestIndex = i;
            }
        }

        // Section B: same, but only replace the highest if strictly greater
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestSection = "B";
                highestIndex = i;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        // Item number is shown starting from 1
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB
                + " | Status: " + status + " | Highest Quantity: " + highest
                + " (Section " + highestSection + ", Item " + (highestIndex + 1) + ")");
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
        analyzeInventory(new int[]{10, 20, 30}, new int[]{5, 50, 10});
    }
}