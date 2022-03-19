package cn.com.wudskq.algorithm.sort;

import java.util.Arrays;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName SheelSort1.java
 * @Description TODO 希尔排序(交换法)
 * @createTime 2022年03月19日 23:13:00
 */
public class ShellSort1 {

    private static int[] array = {8,9,1,7,2,3,5,4,6,0};

    public static void main(String[] args) {
        shellSort1(array);
        System.out.println(Arrays.toString(array));
    }




    //希尔排序-交换排序
    public static void shellSort1(int[] array) {
        //对分组步长不断更新
        for (int step = array.length / 2; step > 0; step /= 2) {
            //对数据设置步长,进行分组
            //分组的下标位置
            for (int groupIndex = step; groupIndex < array.length; groupIndex++) {
                //对根据步长分组的每组数据进行交换排序
                for (int k = groupIndex - step; k >= 0; k -= step) {
                    if(array[k] > array[k+step]){
                        int temp = array[k];
                        array[k] = array[k+step];
                        array[k+step] = temp;
                    }
                }
            }
        }
    }

}
