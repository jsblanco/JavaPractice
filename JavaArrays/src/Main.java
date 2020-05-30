public class Main {

    public static void main(String[] args){
        int[] intArray = {0,1,2,3,4,5,6};
        int[] methodArray = createArray(10,0, -1);
        readIntArray(intArray);
        System.out.println("########");
        readIntArray(methodArray);


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
