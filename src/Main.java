import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        String userEntry = "";
        int counter = 0;
        Integer threshold = null;

        // Обеспечим контроллируемый ввод пользователем целых чисел в произвольном количестве
        // для формирования первичного массива.
        // ArrayList применён для создания массива непредсказуемого размера.
        while(true){
            System.out.print("Введите элемент массива [" + counter + "] или \"\", чтобы завершить: ");
            userEntry = scanner.nextLine();
            if (userEntry.isBlank()){
                if (counter == 0) System.exit(0); // Если в массив не введено ни одного числа, закрываем программу.
                break;
            }
            try{
                myArray.add(parseInt(userEntry));
            }
            catch (NumberFormatException e){
                System.out.println("Необходимо ввести целое число!");
                userEntry = "";
                counter--;
            }
            finally {
                counter++;
            }
        }
        while(true){
            if (threshold != null) break;
            System.out.print("Введите пороговое значение или \"\", чтобы завершить: ");
            userEntry = scanner.nextLine();
            if (userEntry.isBlank()) break;
            try{
                threshold = parseInt(userEntry);
            }
            catch (NumberFormatException e){
                System.out.println("Необходимо ввести целое число!");
                userEntry = "";
            }
        }


        // Теперь на основе массива myArray произвольной длины создалим примитивный
        // массив int[] originalArray, с которым далее и будем работать.
        int[] array = myArray.stream().mapToInt(i -> i).toArray();
        System.out.println("Вы ввели массив: " + Arrays.toString(array));

        NumberUtils numberUtils = new NumberUtils();

        if (threshold == null) {
            // Выполним сортировку
            numberUtils.sort(array);
            System.out.println("Результат сортировки: " + Arrays.toString(array));
        } else {
            // Выполним фильтрацию
            int[] filteredArray;
            filteredArray = numberUtils.filter(array, threshold);
            System.out.println("Результат фильтрации: " + Arrays.toString(filteredArray));
        }
        scanner.close();
    }
}