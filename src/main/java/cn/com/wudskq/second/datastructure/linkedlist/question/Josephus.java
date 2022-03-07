package cn.com.wudskq.second.datastructure.linkedlist.question;

import cn.com.wudskq.second.datastructure.linkedlist.CircularLinkedList;
import cn.com.wudskq.second.datastructure.linkedlist.CircularNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName Josephus.java
 * @Description TODO
 * @createTime 2022年03月07日 01:57:00
 */

public class Josephus {

    public static void main(String[] args) {
        int k = 3;
        int m = 2;
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        CircularNode node1 = new CircularNode(0, "0");
        CircularNode node2 = new CircularNode(1, "1");
        CircularNode node3 = new CircularNode(2, "2");
        CircularNode node4 = new CircularNode(3, "3");
        CircularNode node5 = new CircularNode(4, "4");

        //添加数据
        circularLinkedList.addCircularNode(node1);
        circularLinkedList.addCircularNode(node2);
        circularLinkedList.addCircularNode(node3);
        circularLinkedList.addCircularNode(node4);
        circularLinkedList.addCircularNode(node5);

        //存放数据
        List<CircularNode> list = new ArrayList<CircularNode>();
        //获取第k个位置的数据
        CircularNode circularNode = circularLinkedList.getCircularNode(3);
        //创建临时节点,用于找到需要踢出的节点
        CircularNode temp = circularNode;
        Boolean flag = true;
        while (flag) {
            //从第k个位置后移m+1下,因为有headNode节点
            for (int i = 0; i < m+1; i++) {
                temp = temp.getNext();
            }
            circularLinkedList.removeCircularNode(temp.getIndex());
            list.add(temp);/**/
            if(circularLinkedList.isEmpty()){
                flag = false;
                break;
            }
        }
        System.out.println(list.size());
    }
}
