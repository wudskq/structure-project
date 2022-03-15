package cn.com.wudskq.algorithm.sort;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName BubbleSort.java
 * @Description TODO 冒泡排序:
 * @createTime 2022年03月15日 11:25:00
 */

public class BubbleSort {


    public static void main(String[] args) {
        int[] array = {0, -1, -3, -4, 8, 7, 6};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
//        bubbleSort.sort1(array);
//        bubbleSort.sort2(array);
//        bubbleSort.sort3(array);
//        bubbleSort.sort4(array);
//        bubbleSort.sort5(array);
//        bubbleSort.sort6(array);
        bubbleSort.list(array);
    }


    /**
     * 进行冒泡排序
     * 第一趟比较时,比较的是该数组所有的数据,比较完成后该数组最后一个数为最大数
     * 第二趟比较时,数组最后一个数据不参与进行比较,以此类推,直至比较n躺比较完成
     * @param array
     */
    public int[] sort(int[] array) {
        if (null == array || array.length < 2) {
            return null;
        }
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    //原始比较演示
    public void sort1(int[] array) {
        if(null == array || array.length < 2){
            return;
        }
        for(int i = 0; i < array.length - 1; i++){
            if (array[i] > array[i + 1]) {
                int middle = array[i];
                array[i] = array[i + 1];
                array[i + 1] = middle;
            }
        }
    }

    //原始比较演示
    public void sort2(int[] array) {
        if(null == array || array.length < 2){
            return;
        }
        for(int i = 0; i < array.length - 1-1; i++){
            if (array[i] > array[i + 1]) {
                int middle = array[i];
                array[i] = array[i + 1];
                array[i + 1] = middle;
            }
        }
    }

    //原始比较演示
    public void sort3(int[] array) {
        if(null == array || array.length < 2){
            return;
        }
        for(int i = 0; i < array.length - 1-1-1; i++){
            if (array[i] > array[i + 1]) {
                int middle = array[i];
                array[i] = array[i + 1];
                array[i + 1] = middle;
            }
        }
    }

    //原始比较演示
    public void sort4(int[] array) {
        if(null == array || array.length < 2){
            return;
        }
        for(int i = 0; i < array.length - 1-1-1-1; i++){
            if (array[i] > array[i + 1]) {
                int middle = array[i];
                array[i] = array[i + 1];
                array[i + 1] = middle;
            }
        }
    }
    //原始比较演示
    public void sort5(int[] array) {
        if(null == array || array.length < 2){
            return;
        }
        for(int i = 0; i < array.length - 1-1-1-1-1; i++){
            if (array[i] > array[i + 1]) {
                int middle = array[i];
                array[i] = array[i + 1];
                array[i + 1] = middle;
            }
        }
    }

    //原始比较演示
    public void sort6(int[] array) {
        if(null == array || array.length < 2){
            return;
        }
        for(int i = 0; i < array.length - 1-1-1-1-1-1; i++){
            if (array[i] > array[i + 1]) {
                int middle = array[i];
                array[i] = array[i + 1];
                array[i + 1] = middle;
            }
        }
    }

    public void list(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}



