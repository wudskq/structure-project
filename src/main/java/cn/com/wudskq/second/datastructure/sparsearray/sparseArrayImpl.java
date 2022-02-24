package cn.com.wudskq.second.datastructure.sparsearray;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName sparseArrayImpl.java
 * @Description TODO 稀疏数组实现
 * @createTime 2022年02月25日 00:24:00
 */

public class sparseArrayImpl {

    //声明数组 棋盘大小
    private static int[][] array = new int[13][13];


    public static void main(String[] args) {
        printChessboard(array);
        handlePlayChess(array,1,1,1);
        handlePlayChess(array,1,2,2);
        System.out.print("\n");
        printChessboard(array);
        int[][] sparseArray = initArray(array);
        System.out.print("\n");
        printChessboard(sparseArray);
        System.out.println("\n");
        saveChess(array,sparseArray);
        System.out.print("\n");
        printChessboard(sparseArray);
        int[][] arrayData = queryChess(sparseArray);
        System.out.print("\n");
        printChessboard(arrayData);


    }

    //执行下棋操作 白棋为1,黑棋为2
    private static void handlePlayChess(int[][] array,int row,int column,int data){
        array[row][column] = data;
    }

    //打印棋盘
    private static void printChessboard(int[][] array){
        for (int i = 0; i < array.length; i++) {
            //打印行所有数据
            for (int j = 0; j < array[i].length; j++) {
                int item = array[i][j];
                System.out.printf("\t" + item);
            }
            //换行
            System.out.println();
        }
    }

    /**
     * 遍历原始数组,计算有效值并初始化稀疏数组;
     * @param array 数组
     */
    private static int[][] initArray(int[][] array){
        //计数器
        int count = 0;
        int row = 0,column =0;
        for (int i = 0; i < array.length; i++) {
             row = array.length;
             column = array[i].length;
            for (int j = 0; j < array[i].length; j++) {
                int item = array[i][j];
                if(item != 0){
                    count++;
                }
            }
        }
        //初始化稀疏数组,有效值个数+1为行高
        int[][] sparseArray = new int[count+1][3];
        sparseArray[0][0] = row;
        sparseArray[0][1] = column;
        sparseArray[0][2] = count;
        return sparseArray;
    }

    //存盘操作
    private static void saveChess(int[][] array,int[][] sparseArray){
        //计数器
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int item = array[i][j];
                //判断有效值
                if(item != 0){
                    count ++;
                    //列的功能不变
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = item;
                }
            }
        }
    }

    //读盘
    private static int[][] queryChess(int[][] sparseArray){
        //取出稀疏数组第一行数据,进行初始化二维数组
        int row = sparseArray[0][0];
        int column = sparseArray[0][1];
        int [][] array = new int[row][column];
        for (int i = 0; i < sparseArray.length-1; i++) {
            for (int j = 0; j< sparseArray[i].length-1 ; j++) {
                int rowId = sparseArray[i + 1][0];
                int columnId = sparseArray[i + 1][1];
                int data = sparseArray[i + 1][2];
                array[rowId][columnId] = data;
            }
        }
        return  array;
    }
}
