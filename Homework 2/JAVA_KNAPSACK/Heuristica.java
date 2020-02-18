import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;

public class Heuristica {

    public ArrayList<Item> readFile(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<Item> generatedItems = new ArrayList<Item>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] elements = line.split("      ");
            int ID = Integer.parseInt(elements[0]);
            int value = Integer.parseInt(elements[1]);
            int weight = Integer.parseInt(elements[2]);
            double ratio = value / weight;
            Item item = new Item(ID, value, weight, ratio);
            generatedItems.add(item);
        }

        return generatedItems;

    }

    public void Heuristics() throws IOException {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Which heuristic would you like to run? 1.- By value \n 2.- By weight \n 3.- By ratio");
        int option = 3; // scanner.nextInt();
        ArrayList<Item> items = readFile("Instances.txt");
        switch(option) {
            case 1:
                Collections.sort(items, Item.itemValueComparator);
                break;
            case 2:
                Collections.sort(items, Item.itemWeightComparator);
                break;
            case 3:
                Collections.sort(items, Item.itemRatioComparator);
                break;
        }
        int capacity = 15300;
        System.out.println(capacity);
        int weightSum = 0;
        ArrayList<Item> knapsack = new ArrayList<Item>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getWeight() <= capacity) {
                knapsack.add(items.get(i));
                capacity -= items.get(i).getWeight();
                weightSum += items.get(i).getWeight();
            } else {
                break;
            }
        }
        System.out.println(weightSum);
    }

}