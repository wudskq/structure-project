package cn.com.wudskq.utils;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName RandomArray.java
 * @Description TODO
 * @createTime 2022年03月17日 01:59:00
 */

public class RandomArrayUtils {

    private static int[] array;

    public static int[] randomArray(){
        array = new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i] = (int)(Math.random()*8000000);
        }
        return array;
    }

}
