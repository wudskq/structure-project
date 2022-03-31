package cn.com.wudskq.datastructure.linkedlist;

import lombok.Data;

/**
 * @author chenfangchao
 * @title: SingleLinkedList
 * @projectName structure-project
 * @description: TODO 单向链表 不带头节点
 * @date 2022/4/1 1:22 AM
 */
@Data
public class SingleLinkedList {

    //头部节点
    //使头部节点等于第一个节点
    private SingleNode head;


    public SingleLinkedList(){
        this.head = null;
    }


    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        //添加数据
        linkedList.add(new SingleNode(0,"00"));
        linkedList.add(new SingleNode(1,"11"));
        linkedList.add(new SingleNode(2,"22"));
        //遍历链表
        linkedList.list();
        System.out.println();
        //更新链表
        linkedList.update(new SingleNode(1,"2022"));  //遍历链表
        linkedList.list();
        System.out.println();
        
        //删除链表
        linkedList.del(0);
        //遍历链表
        linkedList.list();

        System.out.println();
        //查找
        linkedList.query(2);

    }


    //链表判空
    public void isEmpty(){
        if(null == head){
         throw new RuntimeException("linkedList is Empty!");
        }
    }

    //添加数据
    public void add(SingleNode node){
        //第一次添加数据
        if(null == head){
            head = node;
        }else {
            SingleNode temp = head;
            while (true){
                //等于即找到最后
                if(null == temp.getNext()){
                    break;
                }
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }

    //移除数据
    public void del(int index){
        isEmpty();
        //判断删除的节点是否为第一个节点
        if(head.getIndex() == index){
            head = head.getNext();
        }else {
            SingleNode temp = head;
            while (true){
                //等于即找到最后
                if(null == temp.getNext()){
                    throw new RuntimeException("del node not exist!");
                }
                //找到要删除节点的上一个节点
                if(temp.getNext().getIndex() == index){
                    break;
                }
                temp = temp.getNext();
            }
            //删除节点的上一个节点指向删除节点的下下节点
            temp.setNext(temp.getNext().getNext());
            //避免链表最后节点next置空
            if(null != temp.getNext()){
                //删除节点next置空
                temp.getNext().setNext(null);
            }
        }
    }


    //更新数据
    public void  update(SingleNode node){
        isEmpty();
        SingleNode temp = head;
        while (true){
            //最后
            if(null == temp.getNext()){
                break;
            }
            //判断
            if(node.getIndex() == temp.getIndex()){
                break;
            }
            temp = temp.getNext();
        }
        temp.setData(node.getData());
    }

    public void query(int index){
        isEmpty();
        SingleNode temp = head;
        while (true){
            //最后
            if(null == temp.getNext()){
                break;
            }
            //判断
            if(index == temp.getIndex()){
                break;
            }
            temp = temp.getNext();
        }
        System.out.println(temp.toString());
    }


    //遍历数据
    public void list(){
        isEmpty();
        SingleNode temp = head;
        while (true){
            System.out.println(temp.toString());
            ///到链表最后
            if(null == temp.getNext()){
                break;
            }
            temp = temp.getNext();
        }
    }

}
