package cn.com.wudskq.algorithm.serach;

/**
 * @author chenfangchao
 * @title: LineSerach
 * @projectName structure-project
 * @description: TODO 查找算法: 线性查找
 * @date 2022/3/29 4:38 PM
 */
public class LineSerach {


    static int[] arrays = {1,2,4,6,8,5,9,10,23,43,554,65};

    public static void main(String[] args) {
        LineSerach lineSerach = new LineSerach();
        System.out.println(lineSerach.lineSerach(arrays, 65));
    }

    /**
     * 线性查找
     * @param arrays
     * @param data
     * @return
     */
    private int lineSerach(int[] arrays,int data){
        for (int i = 0; i < arrays.length; i++) {
            if(data == arrays[i]){
                return i;
            }
        }
        return -1;
    }
}
