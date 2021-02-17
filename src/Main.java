import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner out = new Scanner(System.in);

        boolean flag = true;
        int lengthArray = 0;
        int newValue = 0;
        //get the length of the array
        System.out.println("enter a number : ");
        //check the length
        do {
            lengthArray = out.nextInt();
            if (lengthArray < 1 || lengthArray > 300000) {
                System.out.println("this number is out of range.(1<n<300000) . try again!!");
                flag = false;
            } else {
                flag = true;
            }
        } while (!flag);
        //check the array
        System.out.println("enter " + lengthArray + " number : ");
        int[] array = new int[lengthArray];
        int[] copyArray = new int[array.length];
        for (int i = 0; i < lengthArray; i++) {
            do {
                do {
                    newValue = out.nextInt();
                    for (int j = 0; j < i; j++) {
                        if (newValue == array[j]) {
                            flag = false;
                            System.out.println("this number was entered already, try another one!!");
                            break;
                        } else {
                            flag = true;
                        }
                    }
                } while (!flag);

                if (-1000000000 > newValue || newValue > 1000000000) {
                    System.out.println("this number is too big or  small.(-1000000000<n<1000000000) . try again!!");
                    flag = false;
                } else {

                    array[i] = newValue;
                    copyArray[i] = array[i];
                    flag = true;
                }
            } while (!flag);

        }

        //call the method to sort it
        MergeSort mergeSort = new MergeSort();
        System.out.println("-----------");
        mergeSort.sort(array, 0, lengthArray - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("-----------");

        System.out.println(compare(array, copyArray) + " cell has been changed. ");

    }

    public static int compare(int arr1[], int arr2[]) {
        int counter = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                counter++;
        }
        return counter;
    }

}
