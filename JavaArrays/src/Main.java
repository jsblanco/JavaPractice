import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        /*int[] intArray = {0,1,2,3,4,5,6};
        int[] methodArray = createArray(10,0, -1);
        readIntArray(intArray);
        System.out.println("########");
        readIntArray(methodArray);*/

        int[] integerInput = getIntegers(6);
        int[] arrayClone = integerInput.clone();
        arrayClone[0]= 9999;
        System.out.println("Arrays.toString(integerInput) = " + Arrays.toString(integerInput));
        System.out.println("Arrays.toString(arrayClone) = " + Arrays.toString(arrayClone));
        System.out.println("Array mean value: "+getIntArrayMean(integerInput));
        System.out.println("Sorted array values: "+ Arrays.toString(sortArray(integerInput)));

        String[] prueba = {"hola", "qué tal", "adios"};
        Arrays.stream(prueba).map(value -> value+=" amigo");
        System.out.println(prueba[0]+" "+ prueba[1]+" "+ prueba[2]);
    }

    public static int[] getIntegers(int number){
        System.out.println("Enter "+number+" integers:");
        int[] values =  new int[number];
        for (int i=0; i < number; i++){
            values[i] = scanner.nextInt();
            scanner.nextLine();
        }
        return values;
    }

    public static int[] sortArray(int[] array){
        int[] sortedArray = new int[array.length];
        boolean keepChecking = true;

        for (int i=0; i<array.length; i++){
            sortedArray[i]= array[i];
        }

        while (keepChecking){
            keepChecking=false;
            for (int i=0; i< sortedArray.length-1; i++){
                if (sortedArray[i]<sortedArray[i+1]){
                    int sum = sortedArray[i];
                    sortedArray[i]= sortedArray[i+1];
                    sortedArray[i+1]=sum;
                    keepChecking=true;
                }
            }
        }
        return sortedArray;
    }

    public static double getIntArrayMean(int[] array){
        int sum=0;
        for (int i=0; i<array.length; i++){
            sum += array[i];
        }
        return (double) sum/array.length;
    }


    public static void readIntArray(int[] array){
        /*
        for (int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
         */
        for (int value : array) {
            System.out.println(value);
        }
    }

    public static int[] createArray(int start, int end, int modifier){
        int arrLength = Math.abs(end-start);
        int[] result = new int[arrLength];
        for (int i=0; i<arrLength; i++){
            result[i]=start+(modifier*(i+1));
        }
        return result;
    }

}
