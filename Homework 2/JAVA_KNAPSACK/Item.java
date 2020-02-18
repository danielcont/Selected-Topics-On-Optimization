import java.util.Comparator;

public class Item {
    public int ID;
    public int value;
    public int weight;
    public double ratio;

    public Item(int ID, int value, int weight, double ratio) {
        this.ID = ID;
        this.value = value;
        this.weight = weight;
        this.ratio = ratio;
    }

    public static Comparator<Item> itemValueComparator = new Comparator<Item>() {
        
        public int compare(Item item1, Item item2) {
            int value1 = item1.getValue();
            int value2 = item2.getValue();

            return value1 - value2;

        }
    };

    public static Comparator<Item> itemWeightComparator = new Comparator<Item>() {
        
        public int compare(Item item1, Item item2) {
            int weight1 = item1.getWeight();
            int weight2 = item2.getWeight();

            return weight2 - weight1;
            
        }
    };

    public static Comparator<Item> itemRatioComparator = new Comparator<Item>() {
        
        public int compare(Item item1, Item item2) {
            double ratio1 = item1.getRatio();
            double ratio2 = item2.getRatio();

            return Double.compare(ratio2, ratio1);
            
        }
    };

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}