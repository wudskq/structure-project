package cn.com.wudskq.algorithm.serach;

import java.util.Arrays;

/**
 * @author chenfangchao
 * @title: InterpolationSearch
 * @projectName structure-project
 * @description: TODO 插值搜索
 * @date 2022/3/30 10:58 AM
 */
public class InterpolationSearch {

    static int[] arrays = {1,2,4,3,7,6,8,5,9,10,11,12,13,14};

    static int count = 0;

    public static void main(String[] args) {
        InterpolationSearch search = new InterpolationSearch();
        System.out.println(search.interpolationSearch(arrays, 0, arrays.length - 1, 10));
        System.out.println("插值查找被调用" + count);
    }


    /**
     * 插值排序
     * @param arrays
     * @param left
     * @param right
     * @param findValue
     * @return
     */
    public int interpolationSearch(int[] arrays,int left,int right,int findValue){
        count = count+1;
        Arrays.sort(arrays);
        if(left > right || findValue < arrays[0] || findValue > arrays[arrays.length-1]){
            return -1;
        }
        //插值算法公式
        int middle = left + (findValue-arrays[left])/(arrays[right]-arrays[left]) * (right-left);
        int middleData = arrays[middle];
        //向右找
        if(findValue > middleData){
            return interpolationSearch(arrays,middle+1,right,findValue);
        }else if(findValue < middleData){//向左找
            return interpolationSearch(arrays,left,middle-1,findValue);
        }else {
            return middle;
        }
    }
}
