package com.company;
public class Main {

    public static void main(String[] args) {

        int []arrSort = new int[] {1, 4, 5, 6, 7, 8, 1, 8, 6, 4};
        int []finalArr = new int[10];
        finalArr = MergeSort(arrSort);

        for(int i=0; i<arrSort.length; i++){
            if(arrSort[i] == arrSort[i+1]){
               i= i+1;
            }
            else{
                System.out.print(arrSort[i]);
            }
        }
    }

    public static int[] MergeSort(int[] arrSort){

        if (arrSort.length <= 1) {
            return arrSort;
        }

        int[] first = new int[arrSort.length/2];
        int[] second = new int[arrSort.length - first.length];

        System.arraycopy(arrSort,0,first,0,first.length);
        System.arraycopy(arrSort,first.length,second,0,second.length);

        MergeSort(first);
        MergeSort(second);

        merge(first,second,arrSort);

        return arrSort;
    }

    private static void merge(int[] first, int[] second, int [] result) {

        int iFirst = 0;
        int iSecond = 0;

        int j = 0;
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }
}