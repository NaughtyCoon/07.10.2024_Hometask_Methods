import java.util.ArrayList;

public class NumberUtils {
    public void sort(int[] array){
        int exchange;
        for (int i = 0; i < array.length - 1; i++){
            for (int j = 1; j < array.length - i; j++){
                if (array[j] < array[j-1]){
                    exchange = array[j-1];
                    array[j-1] = array[j];
                    array[j] = exchange;
                }
            }
        }
    }
    public int[] filter(int[] array, int threshold){
        ArrayList<Integer> tempArray = new ArrayList<Integer>();
        for (int j : array) {
            if (j > threshold) tempArray.add(j);
        }
        return tempArray.stream().mapToInt(i -> i).toArray();
    }
}
