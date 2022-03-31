package cn.com.wudskq.datastructure.hashtable;

import cn.com.wudskq.datastructure.linkedlist.SingleLinkedList;
import cn.com.wudskq.datastructure.linkedlist.SingleNode;

/**
 * @author chenfangchao
 * @title: HashTable1
 * @projectName structure-project
 * @description: TODO 数组+链表实现hashTable
 * @date 2022/3/31 1:45 AM
 */
public class Array4LinkedList {

    //数组
    private SingleLinkedList[] arrays;

    private int size;

    //初始化hashtable
    public Array4LinkedList(int size){
        this.size = size;
        arrays = new SingleLinkedList[this.size];
        //初始化数组元素
        for (int i = 0; i < arrays.length; i++) {
            SingleLinkedList linkedList = new SingleLinkedList();
            arrays[i] = linkedList;
        }
    }

    public static void main(String[] args) {
        Array4LinkedList hashTable = new Array4LinkedList(3);
        //虚拟数据
        SingleNode node1 = new SingleNode(1, "11");
        SingleNode node2 = new SingleNode(2, "22");
        SingleNode node3 = new SingleNode(3, "33");
        SingleNode node4 = new SingleNode(4, "44");

        //添加
        hashTable.add(node1);
        hashTable.add(node2);
        hashTable.add(node3);
        hashTable.add(node4);

        //遍历
        hashTable.list();
        System.out.println("分割线-----------------------");

        //更新
        hashTable.update(new SingleNode(1,"2022"));
        //遍历
        hashTable.list();

        System.out.println("分割线-----------------------");
        //删除
        hashTable.del(new SingleNode(4,""));
        //遍历
        hashTable.list();

        System.out.println("分割线-----------------------");
        //查找
        hashTable.get(1);

    }


    //查询数据
    public void get(int index){
        //根据散列函数获取数据要添加到数组中哪个位置的链表
        SingleLinkedList linkedList =  arrays[hashFun(index)];
        linkedList.query(index);
    }

    //添加数据
    public void  add(SingleNode node){
        int index = node.getIndex();
        //根据散列函数获取数据要添加到数组中哪个位置的链表
        SingleLinkedList linkedList =  arrays[hashFun(index)];
        linkedList.add(node);
    }


    //更新数据
    public void update(SingleNode node){
        int index = node.getIndex();
        //根据散列函数获取数据要添加到数组中哪个位置的链表
        SingleLinkedList linkedList =  arrays[hashFun(index)];
        linkedList.update(node);
    }


    //删除数据
    public void del(SingleNode node){
        int index = node.getIndex();
        //根据散列函数获取数据要添加到数组中哪个位置的链表
        SingleLinkedList linkedList =  arrays[hashFun(index)];
        linkedList.del(node.getIndex());
    }


    //遍历哈希表
    public void list(){
        for (int i = 0; i < size; i++) {
            SingleLinkedList linkedList = arrays[i];
            linkedList.list();
            System.out.println("");
        }
    }


    //散列函数
    public int hashFun(int id){
        int index = id % this.size;
        return index;
    }


}
