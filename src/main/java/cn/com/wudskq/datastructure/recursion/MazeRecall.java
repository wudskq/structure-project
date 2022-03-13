package cn.com.wudskq.datastructure.recursion;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName MazeRecall.java
 * @Description TODO 迷宫回溯问题
 * @createTime 2022年03月13日 15:30:00
 */
@Data
public class MazeRecall {

    //地图 1表示为墙 0表示可空白区域
    private int[][] map;

    private List<Boolean> data;

    public MazeRecall() {
        //实例化迷宫
        this.map = new int[8][7];
        this.data = new ArrayList<>();
    }


    public static void main(String[] args) {
        MazeRecall mazeRecall = new MazeRecall();
        //打印初始地图
        mazeRecall.printMap();
        mazeRecall.initWall();
        //换行
        System.out.println();
        //迷宫回溯
        mazeRecall.getSeaWay(mazeRecall.getMap(),1,1);
        //换行
        System.out.println();
        mazeRecall.printMap();
    }


    //实例化墙
    public void initWall() {
        //创建墙
        for (int i = 0; i < map.length; i++) {
            //第一行和最后一行所有列都为墙
            if (i == 0 || i == 7) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = 1;
                }
            } else {
                //其余都为墙
                for (int j = 0; j < map[i].length; j++) {
                    map[i][0] = 1;
                    map[i][6] = 1;
                    //在第四行设置凸出的墙
                    if (i == 3) {
                        map[i][1] = 1;
                        map[i][2] = 1;
                    }
                }
            }
        }
    }

    //打印地图
    public void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int item = map[i][j];
                System.out.printf("\t" + item);
            }
            System.out.println();
        }
    }


    /**
     * 获取可走路线
     *
     * @param map 实例地图
     * @param i   index i
     * @param j   index j
     * @return 找到返回true, 未找到返回false
     */
    //约定: (i,j)表示从地图哪个位置出发map[1][1]
    //约定: 小球如果找到map[6][5]代表已找到
    //约定: 当map[i][j]为0时代表该点没有走过,当map[i][j]为1时代表墙
    //约定: 当map[i][j]为2时表示通路,当map[i][j]为3时代表该路不通
    //约定: 在走迷宫时需要确定棋子行走策略: 下-右-上-左,若该点走不通则进行回溯
    public Boolean getSeaWay(int[][] map, int i, int j) {
        //代表已找到路线
        if (map[6][5] == 2) {
            return true;
        } else {
            //如果这个点还没被棋子走过
            if (map[i][j] == 0) {
                //按照策略走 下-右-上-左 假定该点为通路开始执行策略
                map[i][j] = 2;
                if (getSeaWay(map, i + 1, j)) {
                    return true;
                } else if (getSeaWay(map, i, j + 1)) {
                    return true;
                } else if (getSeaWay(map, i - 1, j)) {
                    return true;
                } else if (getSeaWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
                //否则该点可能为1,2,3
            } else {
                return false;
            }
        }
    }

    //修改寻路策略
    public Boolean getSeaWay1(int[][] map, int i, int j) {
        //代表已找到路线
        if (map[6][5] == 2) {
            return true;
        } else {
            //如果这个点还没被棋子走过
            if (map[i][j] == 0) {
                //按照策略走 上-右-下-左 假定该点为通路开始执行策略
                map[i][j] = 2;
                if (getSeaWay1(map, i - 1, j)) {
                    return true;
                } else if (getSeaWay1(map, i, j + 1)) {
                    return true;
                } else if (getSeaWay1(map, i + 1, j)) {
                    return true;
                } else if (getSeaWay1(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
                //否则该点可能为1,2,3
            } else {
                return false;
            }
        }
    }


}
