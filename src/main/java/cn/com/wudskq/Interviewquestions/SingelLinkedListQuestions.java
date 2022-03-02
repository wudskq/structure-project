package cn.com.wudskq.Interviewquestions;

import cn.com.wudskq.second.datastructure.linkedlist.SingelLinkedList;
import cn.com.wudskq.second.datastructure.linkedlist.SingleNode;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName SingelLinkedListQuestions.java
 * @Description TODO 单向链表面试题
 * @createTime 2022年03月03日 03:09:00
 */
public class SingelLinkedListQuestions {


    public static void main(String[] args) {
        SingelLinkedList linkedList = new SingelLinkedList();
        linkedList.addSingeNode(new SingleNode(0,"0"));
        linkedList.addSingeNode(new SingleNode(1,"1"));
        linkedList.addSingeNode(new SingleNode(2,"2"));
        linkedList.addSingeNode(new SingleNode(3,"3"));
        linkedList.addSingeNode(new SingleNode(4,"4"));
        linkedList.addSingeNode(new SingleNode(5,"5"));
        linkedList.addSingeNode(new SingleNode(6,"6"));
        //获取头节点
        SingleNode headNode = linkedList.getHeadNode();
        int linkedListSize = getLinkedListSize(headNode);
        SingleNode reciprocalNode = getReciprocalNode(headNode, 0);
        System.out.println(reciprocalNode.toString());
    }




    //求链表中的有效个数
    private static int getLinkedListSize(SingleNode headNode){
        if(headNode.getNext() == null){
            return 0;
        }
        int count = 0;
        //辅助节点
        SingleNode temp = headNode.getNext();
        while (null != temp){
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    //求链表中倒数第k个节点 正向数倒数的节点下标为n-k+1
    //设置快慢指针解决链表倒数问题
    private static SingleNode getReciprocalNode(SingleNode headNode, int index){
        Boolean flag = true;
        if(null == headNode || null == headNode.getNext()){
            return null;
        }
        //慢指针
        SingleNode slow = headNode;
        //快指针
        SingleNode fast = headNode;
        //快指针先向后移动k个位置
        for (int i = 0; i <index; i++) {
            fast = fast.getNext();
        }
        while (flag){
            fast = fast.getNext();
            slow = slow.getNext();
            //判断如果快指针为空,说明fast走到链表最后
            //停止循环,此时slow指针指向的位置就是倒数第k个节点
            if(null == fast){
                flag = false;
                break;
            }
        }
        return slow;
    }



}
