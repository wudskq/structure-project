package cn.com.wudskq.algorithm.serach;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenfangchao
 * @title: BinarySearch
 * @projectName structure-project
 * @description: TODO 二分查找
 * @date 2022/3/29 5:15 PM
 */
public class BinarySearch {

    static int[] arrays =  {1,2,4,3,7,6,8,5,9,10,11,12,13,14};

    static int count = 0;

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch2(arrays, 0, arrays.length - 1, 10));
        System.out.println("二分查找被调用" + count);
    }


    /**
     * 思路分析: 在找到符合条件的middle的下标时
     * 开始从符合的下标 middle 左边及右边找到符合条件的Index并加入到list
     * @param arrays
     * @param left
     * @param right
     * @param findValue
     * @return
     */
    //TODO 公式: mid = 0.5*(left+right)
    public List<Integer> binarySearch(int[] arrays, int left, int right, int findValue){
        count = count + 1;
        //数据
        ArrayList<Integer> list = new ArrayList<>();
        //进行排序
        Arrays.sort(arrays);
        //递归结束条件
        //如果左下标大于了右下标||右下标小于左下标则证明找不到数据
        if(left > right){
            return null;
        }
        int middle = (left + right) /2;
        int middleData = arrays[middle];
        //向右递归
        if(findValue > middleData){
            return binarySearch(arrays,middle+1,right,findValue);
        }else if(findValue < middleData){ //向左递归
            return binarySearch(arrays,left,middle-1,findValue);
        }else{ //直接返回
            list.add(middle);
            //向左扫描
            int tempIndex = middle-1;
            while (true){
                if(tempIndex < 0 || arrays[tempIndex] != findValue){
                    break;
                }
                list.add(tempIndex);
                tempIndex -= 1;
            }
            //向右扫描
            tempIndex = middle+1;
            while (true){
                if(tempIndex > arrays.length-1 || arrays[tempIndex] != findValue){
                    break;
                }
                list.add(tempIndex);
                tempIndex += 1;
            }
        }
        return list;
    }


    //TODO 公式: mid = 0.5*(left+right)
    public int binarySearch1(int[] arrays, int left,int right,int findValue){
        //进行排序
        Arrays.sort(arrays);
        //递归结束条件
        //如果左下标大于了右下标||右下标小于左下标则证明找不到数据
        if(left > right){
            return -1;
        }
        int middle = (left + right) /2;
        int middleData = arrays[middle];
        //向右递归
        if(findValue > middleData){
           return binarySearch1(arrays,middle+1,right,findValue);
        }else if(findValue < middleData){ //向左递归
            return binarySearch1(arrays,left,middle-1,findValue);
        }else{ //直接返回
            return middle;
        }
    }

    //TODO 公式: mid = left + 0.5*(right-left)
    public int binarySearch2(int[] arrays, int left,int right,int findValue){
        //进行排序
        Arrays.sort(arrays);
        //递归结束条件
        //如果左下标大于了右下标||右下标小于左下标则证明找不到数据
        if(left > right){
            return -1;
        }
        int middle = (int) (left + 0.5 *(right -left));
        int middleData = arrays[middle];
        //向右递归
        if(findValue > middleData){
            return binarySearch1(arrays,middle+1,right,findValue);
        }else if(findValue < middleData){ //向左递归
            return binarySearch1(arrays,left,middle-1,findValue);
        }else{ //直接返回
            return middle;
        }
    }
}

