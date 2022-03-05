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
        linkedList.addSingeNode(new SingleNode(7,"7"));
        linkedList.addSingeNode(new SingleNode(8,"8"));
        //获取头节点
        SingleNode headNode = linkedList.getHeadNode();
//        int linkedListSize = getLinkedListSize(headNode);
//
//        SingleNode reciprocalNode = getReciprocalNode(headNode, 5);
//        System.out.println("倒数第K个节点为: "+reciprocalNode.toString());
//
//        SingleNode middleNode = getMiddleNode(headNode);
//        System.out.println("中间节点为: "+middleNode.toString());
//
//        System.out.println("迭代反转法");
//        iterativeInversion(headNode);
//
//        System.out.println("遍历链表");
//        linkedList.list(headNode);

        System.out.println("就地逆置法");
        localReverse(headNode);

        System.out.println("遍历链表");
        linkedList.list(headNode);

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
                return  slow;
            }
        }
        return null;
    }

    //获取链表的中间节点
    //设置快慢指针解决链表倒数问题
    private static SingleNode getMiddleNode(SingleNode headNode){
        Boolean flag = true;
        //慢指针
        SingleNode slow  = headNode.getNext();
        //快指针
        SingleNode fast  = headNode.getNext();
        //fast的next指针为null或者fast的next指针的next指针为空,说明fast已到最后一个节点
        while (flag){
            if(null == fast.getNext() || null == fast.getNext().getNext()){
                flag = false;
                return  slow;
            }
            //慢指针
             slow  = slow.getNext();
             //快指针
             fast  = fast.getNext().getNext();
        }
        return  null;
    }

    //单向链表反转
    //迭代反转法
    private static void iterativeInversion(SingleNode headNode){
        //计数器
        int count = 0;
        Boolean flag = true;
        if(null == headNode.getNext()){
            return;
        }
        SingleNode begin = null;
        SingleNode middle = headNode;
        SingleNode end = headNode.getNext();
        while (flag){
            middle.setNext(begin);
            //代表指针已到链表最后
            if(null == end){
                flag = false;
                break;
            }
            //所有指针后移
            begin = middle;
            middle = end;
            end = end.getNext();
            //确保反转后最后一个节点的next指针为null
            count++;
            //count=1时begin为head,等于2时begin为初始链表的第一个节点
            if(count == 2){
                //begin指针的next指针置为空
                begin.setNext(null);
            }
        }
        //头节点指向middle指针
        headNode.setNext(middle);
    }

    //就地逆置法反转单向链表
    private static void localReverse(SingleNode headNode){
        Boolean flag = true;
        if(null == headNode.getNext() || null == headNode.getNext().getNext()){
            return;
        }
        SingleNode begin = headNode.getNext();
        SingleNode end = begin.getNext();
        while (flag){
            //移除end指针节点
            begin.setNext(end.getNext());
            end = end.getNext();
            if(null == end){
                flag = false;
                break;
            }
        }
    }

}
