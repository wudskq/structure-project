package cn.com.wudskq.algorithm.sort;

import cn.com.wudskq.utils.RandomArrayUtils;

import java.util.Date;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName SelectSort.java
 * @Description TODO 选择排序
 * @createTime 2022年03月17日 01:06:00
 */

public class SelectSort {

    private static int[] array = {8, 3, 2, 1, 7, 4, 6, 5};

    public static void main(String[] args) {
        int[] ints = RandomArrayUtils.randomArray();
        System.out.println("排序前"+ new Date());
        int[] res = selectSort(ints);
        System.out.println("排序后"+new Date());

    }


    public static int[] selectSort(int[] array) {
        //n躺
        for (int i = 0; i < array.length - 1; i++) {
            //假定第i个为最小值
            int minData = array[i];
            int minIndex= i;
            //第n躺循环判断j次
            //判断假定值是否为最小值
            for (int j = i+1; j < array.length; j++) {
                if(minData>array[j]){
                    //最小值等于Index=j
                    minData = array[j];
                    //需要交换的下标
                    minIndex = j;
                }
            }
            //说明最小值就是array[i],则不需要交换
            if(minIndex != i){
                array[minIndex] = array[i];
                array[i] = minData;
            }
        }
        return array;
    }

    public static void list(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
