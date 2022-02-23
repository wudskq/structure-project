package cn.com.wudskq.second.datastructure.sparsearray;

import cn.com.wudskq.utils.Conn;

import java.sql.SQLException;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName ArrayListImpl.java
 * @Description TODO 数组实现五子棋功能
 * @createTime 2022年02月23日 22:40:00
 */
public class ArrayListImpl {

    //声明数组
    private static int[][] array = new int[12][12];

    public static void main(String[] args) throws SQLException {
        printChessboard(array);
        System.out.println("--------------------------------------------------------");
        queryChess(array);
        printChessboard(array);
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

    //执行下棋操作
    private static void handlePlayChess(int[][] array,int row,int column,int data){
        array[row][column] = data;
    }
    
    //存盘
    private static void saveChess(int[][] array) throws SQLException {
        String sql = "insert into array_data (row_id,column_id,data) value (?,?,?);";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length ; j++) {
                int item = array[i][j];
                //保存每行数据
                Conn.saveChess(sql,i,j,item);
            }
        }
    }

    //读盘
    private static void  queryChess(int[][] array) throws SQLException {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length ; j++) {
                int row = i,column = j;
                String sql = String.format("select data from array_data where row_id =%d and column_id =%d", row, column);
                int data = Conn.queryChess(sql, "data");
                array[i][j] = data;
            }
        }
    }
}

