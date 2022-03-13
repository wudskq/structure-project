package cn.com.wudskq.datastructure.recursion;

import lombok.Data;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName EightQueens.java
 * @Description TODO 八皇后问题
 * @createTime 2022年03月13日 19:20:00
 */
@Data
public class EightQueens {

    private int maxSize=8;

    //存放8皇后摆放位置结果
    private int[] array;

    //计数
    private int count;

    //方法调用次数
    private int judgeCount;

    public EightQueens(){
        this.array = new int[maxSize];
    }

    public static void main(String[] args) {
        EightQueens queens = new EightQueens();
        queens.check(0);
        System.out.println("一共"+queens.getCount()+"种解法");
        System.out.println("一共调用方法"+queens.getJudgeCount()+"次");
    }


    //放置第n个皇后
    //递归时每个check方法内部都会调用for循环maxSize次
    public void check(int n){
        if(n == maxSize){
            printf();
            count ++;
            return;
        }
        //反之依次放入皇后,并判断是否冲突
        for (int i = 0; i < maxSize ; i++) {
            //先把第n个皇后放置n行的第1列
            array[n] = i;
            //判断是否冲突
            if(judge(n)){ //不冲突
                check(n+1);
            }
            //如果冲突,就把第n个皇后放在同行的下一列
        }
    }






    //判断当前放置的皇后位置是否与其他已摆放皇后位置冲突 n为第几个皇后可以理解为要摆放的
    //冲突条件 不能为一行 不能为一列 不能在一条斜线上
    //不用判断是否在同一行,原因:每次都是往不同行数摆放皇后
    public boolean judge(int n){
        judgeCount ++;
        for (int i = 0; i < n ; i++) {
            //判断是否在同一列,同一斜线
            //同一斜线判断算法为 第n行减去第i行的绝对值是否等于第n行的列值减去第i行第列值的绝对值
            //即可将看作为判断是否为一个等腰直角三角形
            //判断它的高和宽是否相等,若相等即为等腰直角三角形,等腰直角三角形的斜边即为对角线
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }


    //输出皇后摆放位置结果
    public void printf(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
