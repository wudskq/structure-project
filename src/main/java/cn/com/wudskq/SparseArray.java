package cn.com.wudskq;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName SparseArray.java
 * @Description TODO 数组与稀疏数组
 * @createTime 2021年11月25日 22:38:00
 */
public class SparseArray {

    /**
     * 创建一个11*11的五子棋盘
     * 白子为1 黑子为2
     *
     * @param args
     */
    public static void main(String[] args) {
        /* 原始数组 */
        int[][] array = array();
        forEach(array);
        /* 稀疏数组 */
        int[][] sparseArray = getArrayBaseInfo(array);
        saveSparseArray(array,sparseArray);
        forEach(sparseArray);
        /* 稀疏数组恢复为原始数组 */
        int[][] ints = initArray(sparseArray);
        forEach(ints);
    }

    /**
     * 初始化原始数组
     *
     * @return
     */
    private static int[][] array() {
        int[][] array = new int[11][11];
        array[0][1] = 1;
        array[1][2] = 2;
        array[3][4] = 1;
        array[5][6] = 1;
        return array;
    }

    /**
     * 遍历数组
     */
    private static void forEach(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int item = array[i][j];
                System.out.printf("\t" + item);
            }
            System.out.println();
        }

    }

    /**
     * 获取原始数组的基本信息
     * 行 列 有效数据
     */
    private static int[][] getArrayBaseInfo(int[][] array) {
        int h = 0;
        int w = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                h = array.length;
                w = array[i].length;
                /* 获取原始数组所有数据 */
                int data = array[i][j];
                if (data != 0) {
                    sum++;
                }
            }
        }
        System.out.println("原始数组的行数" + h);
        System.out.println("原始数组的列数" + w);
        System.out.println("有效值总数" + sum);
        return initSparseArray(h, w, sum);
    }


    /**
     * 初始化稀疏数组
     *
     * @param h
     * @param w
     * @param sum
     * @return
     */
    private static int[][] initSparseArray(int h, int w, int sum) {
        /* 初始化稀疏数组 */
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = h;
        sparseArray[0][1] = w;
        sparseArray[0][2] = sum;
        return sparseArray;
    }

    /**
     * 遍历原始数组并把存入有效值
     */
    private static void saveSparseArray(int[][] array, int[][] sparseArray) {
        /* 计数器 */
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int data = array[i][j];
                if (data != 0) {
                    count++;
                    /* 行 */
                    sparseArray[count][0] = i;
                    /* 列 */
                    sparseArray[count][1] = j;
                    /* 值 */
                    sparseArray[count][2] = data;
                }
            }
        }
    }

    /**
     * 遍历稀疏数组恢复原始数组
     */
    private static int[][] initArray(int[][] sparseArray){
        int h = sparseArray[0][0];
        int w = sparseArray[0][1];
        int[][] array = new int[h][w];
        for (int i = 1; i < sparseArray.length; i++) {
            /* 行 列 值 */
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return array;
    }

}
