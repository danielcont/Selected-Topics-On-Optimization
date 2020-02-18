import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generator{
    public void getUserInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of items you want to generate: ");
        int items = 1000000; // scanner.nextInt();
        System.out.println("Enter the minimum value: ");
        int minValue = 3; // scanner.nextInt();
        System.out.println("Enter the maximum value: ");
        int maxValue = 75; // scanner.nextInt();
        System.out.println("Enter the minimum weight: ");
        int minWeight = 5; // scanner.nextInt();
        System.out.println("Enter the maximum weight: ");
        int maxWeight = 89; // scanner.nextInt();
        writeFile(items, minValue, maxValue, minWeight, maxWeight);
    }

    public void writeFile(int items, int minimumValue, int maximumValue, int minimumWeight, int maximumWeight) throws java.io.IOException {
        File file = new File("Instances.txt");
        FileWriter fileInstance = new FileWriter(file);
        Random rand = new Random();
        for (int i = 0; i < items; i++) {
            int value = minimumValue + rand.nextInt(maximumValue);
            int weight = minimumWeight + rand.nextInt(maximumWeight);
            fileInstance.write(Integer.toString(i) + "      " + Integer.toString(value) + "      "
                    + Integer.toString(weight) + "\n");
        }
        fileInstance.close();
    }
}