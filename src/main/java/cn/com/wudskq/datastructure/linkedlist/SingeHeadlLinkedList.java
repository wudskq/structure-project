package cn.com.wudskq.datastructure.linkedlist;


/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName SingelLinkedList.java
 * @Description TODO 单向链表 带head节点
 * @createTime 2022年03月01日 01:46:00
 */

@SuppressWarnings("ALL")
public class SingeHeadlLinkedList {

    //初始化Head节点
    private SingleNode headNode = new SingleNode(-1,"headNode");


    public SingleNode getHeadNode() {
        return headNode;
    }


    public static void main(String[] args) {
        SingeHeadlLinkedList linkedList = new SingeHeadlLinkedList();
        linkedList.addSingeNode(new SingleNode(0,"sdasda"));
        linkedList.addSingeNode(new SingleNode(1,"1"));
        linkedList.addSingeNode(new SingleNode(2,"dasds"));
        linkedList.delSingelNode(1);
        linkedList.updateSingelNode(new SingleNode(2,"222"));
        SingeHeadlLinkedList linkedList1 = linkedList;
    }



    //判空
    public void isEmpty(){
        SingleNode temp = headNode;
        if(null == temp.getNext()){
            throw new RuntimeException("LinkedList is empty!");
        }
    }


    //获取指定下标的节点数据
    public SingleNode getIndex(int index){
        isEmpty();
        SingleNode temp = headNode.getNext();
        Boolean flag = true;
        while (flag){
            if(index == temp.getIndex()){
                flag = false;
            }else {
                temp = temp.getNext();
            }
        }
        return temp;
    }


    //添加节点
    public void addSingeNode(SingleNode node){
        //头部节点不能动
        SingleNode tempHeadNode = headNode;
        while (true){
            if(tempHeadNode.getNext() == null){
                break;
            }
            tempHeadNode = tempHeadNode.getNext();
        }
        //添加数据
        tempHeadNode.setNext(node);
    }


    //删除指定下标的节点
    public void delSingelNode(int index){
        isEmpty();
        SingleNode temp = headNode;
        Boolean flag = true;
        while (flag){
            //找到要删除节点的上一个节点
            if(index == temp.getNext().getIndex()){
                flag = false;
                break;
            }else {
                temp = temp.getNext();
            }
        }
        //删除节点的上一个节点的next指针指向新的节点
        temp.setNext(temp.getNext().getNext());
        //删除的节点next指针置空
        temp.getNext().setNext(null);
    }

    //更新指定下标位置数据
    public void updateSingelNode(SingleNode node){
        isEmpty();
        SingleNode temp = headNode;
        Boolean flag = true;
        int index = node.getIndex();
        while (flag){
            //找到要更新的节点
            if(index == temp.getIndex()){
                flag = false;
                break;
            }else {
                temp = temp.getNext();
            }
        }
        //更新数据
        temp.setData(node.getData());
    }

    //遍历链表
    public void list(SingleNode headNode){
        isEmpty();
        SingleNode temp = headNode;
        while (true){
            temp = temp.getNext();
            if(null == temp){
                break;
            }
            System.out.println(temp.toString());
        }
    }

}
