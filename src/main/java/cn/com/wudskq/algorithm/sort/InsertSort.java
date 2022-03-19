package cn.com.wudskq.algorithm.sort;

import cn.com.wudskq.utils.RandomArrayUtils;

import java.util.Arrays;
import java.util.Date;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName InsertSort.java
 * @Description TODO 插入排序
 * @createTime 2022年03月19日 22:04:00
 */

public class InsertSort {

    private static int[] array = {3,1,2,6,8,4,0,10,7};


    public static void main(String[] args) {
        insertSort(array);
        System.out.println(Arrays.toString(array));

        //测试算法时间
        int[] ints = RandomArrayUtils.randomArray();
        System.out.println("插入排序前时间" + new Date());
        insertSort(ints);
        System.out.println("插入排序后时间" + new Date());
    }

    //插入排序
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            //定义要插入的数
            int insertData = array[i];
            //要插入的下标(为要插入数的前一个数的下标)
            int insertIndex = i-1;
            //如果插入的下标大于等于0且插入的数据小于前一个位置的数
            while (insertIndex >=0 && insertData < array[insertIndex]){
                //则将前一个位置的数后移
                array[insertIndex + 1] = array[insertIndex];
                //插入的下标+1
                insertIndex--;
            }
            array[insertIndex+1] = insertData;
        }
    }
}
