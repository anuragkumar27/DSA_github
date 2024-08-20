import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class Knapsack {
    double fractionalKnapsack(int w, Item arr[], int n) {
        double total = 0;
       // Arrays.sort(arr,(a,b)-> Double.compare((double)b.value/b.weight,(double)a.value/a.weight));
        Arrays.sort(arr,new Comparator<Item>(){
            @Override
            public int compare(Item a, Item b) {
                return Double.compare((double)b.value/b.weight,(double)a.value/a.weight);
            }
            
        });

        for(int i=0;i<n;i++){
            if(arr[i].weight<=w){
                total += arr[i].value;
                w -= arr[i].weight;
            }else{
                total += (double)arr[i].value/arr[i].weight*w;
                break;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        // Parse input
        int w = 24; // Capacity of the knapsack
        Item[] items = {
            new Item(1, 4),
            new Item(5, 9),
            new Item(7, 6),
            new Item(2, 3),
            new Item(7, 7),
            new Item(10, 3)
        };

        Knapsack ks = new Knapsack();
        double maxValue = ks.fractionalKnapsack(w, items, items.length);
        System.out.printf("Maximum value in the knapsack = %.6f\n", maxValue);
    }
}
