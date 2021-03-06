package cn.com.wudskq.algorithm.sort;

import cn.com.wudskq.utils.RandomArrayUtils;

import java.util.Arrays;
import java.util.Date;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName SheelSort1.java
 * @Description TODO 希尔排序(交换法)
 * @createTime 2022年03月19日 23:13:00
 */
public class ShellSort {

    private static int[] array = {8,9,1,7,2,3,5,4,6,0};

    public static void main(String[] args) {
        shellSort2(array);
        System.out.println(Arrays.toString(array));
        int[] ints = RandomArrayUtils.randomArray();
        System.out.println("排序前"+ new Date());
        shellSort1(ints);
        System.out.println("排序后"+new Date());
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
                    //如果后面数大于前面数进行交换
                    if(array[k] > array[k+step]){
                        int temp = array[k];
                        array[k] = array[k+step];
                        array[k+step] = temp;
                    }
                }
            }
        }
    }

    //希尔排序-快速排序
    public static void shellSort2(int[] array) {
        //对分组步长不断更新
        for (int step = array.length / 2; step > 0; step /= 2) {
            //对数据设置步长,进行分组
            //分组的下标位置
            for (int groupIndex = step; groupIndex < array.length; groupIndex++) {
                int i = groupIndex;
                int data = array[i];
                //判断每组数据中大的index是否小于小的index
                if(array[i] < array[i-step]){
                    while (i -step >=0 && data < array[i-step]){
                        array[i] = array[i-step];
                        i -= step;
                    }
                    array[i] = data;
                }
            }
        }
    }

}
