package cn.com.wudskq.second.datastructure.linkedlist;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName DoubleLinkedList.java
 * @Description TODO
 * @createTime 2022年03月06日 22:24:00
 */

public class DoubleLinkedList {

    //头部节点
    private DoubleNode headNode = new DoubleNode(-1, "headNode");


    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        //获取头节点
        DoubleNode headNode = linkedList.getHeadNode();

        //添加数据
        DoubleNode node1 = new DoubleNode(0, "0");
        DoubleNode node2 = new DoubleNode(1, "1");
        DoubleNode node3 = new DoubleNode(2, "2");
        DoubleNode node4 = new DoubleNode(3, "3");

        linkedList.addDoubleNode(node1);
        linkedList.addDoubleNode(node2);
        linkedList.addDoubleNode(node3);
        linkedList.addDoubleNode(node4);

        //正向遍历双向链表
        linkedList.listDoubleList();

        //删除节点
        linkedList.removeDoubleNode(1);
        System.out.println("删除后的链表数据");
        //正向遍历双向链表
        linkedList.listDoubleList();

        //更新数据
        linkedList.updateDoubleNode(new DoubleNode(2,"二"));
        System.out.println("更新后的链表数据");
        //正向遍历双向链表
        linkedList.listDoubleList();

    }


    //获取头部节点
    public DoubleNode getHeadNode() {
        return headNode;
    }

    //链表判空
    public void isEmpty() {
        if (null == headNode) {
            return;
        }
        DoubleNode nextNode = headNode.getNext();
        if (null == nextNode) {
            throw new RuntimeException("doubleLinkedList is empty!");
        }
    }

    //添加节点
    public void addDoubleNode(DoubleNode node) {
        DoubleNode temp = headNode;
        Boolean flag = true;
        while (flag) {
            //如果temp的next指针等于空
            //则证明temp为最后一个节点
            if (null == temp.getNext()) {
                flag = false;
                break;
            }
            //否则tmep节点后移
            temp = temp.getNext();
        }
        //next指向新增数据
        temp.setNext(node);
        //新增node的pre指针指向temp
        node.setPre(temp);
    }

    //删除节点(节点自删除)
    public void removeDoubleNode(int index) {
        isEmpty();
        DoubleNode temp = headNode;
        Boolean flag = true;
        DoubleNode pre = null;
        DoubleNode next = null;
        while (flag) {
            int nodeIndex = temp.getIndex();
            if (nodeIndex == index) {
                flag = false;
                pre = temp.getPre();
                next = temp.getNext();
                break;
            }
            //否则指针后移
            temp = temp.getNext();
        }
        //重新进行指针链接
        pre.setNext(temp.getNext());
        next.setPre(temp.getPre());
        //删除节点的指针置空
        temp.setPre(null);
        temp.setNext(null);
    }

    //更新节点数据
    public void updateDoubleNode(DoubleNode node) {
        isEmpty();
        DoubleNode temp = headNode;
        Boolean flag = true;
        int index = node.getIndex();
        while (flag) {
            //已找到要更新的节点
            if(temp.getIndex() == index){
                flag = false;
                break;
            }
            temp = temp.getNext();
        }
        //更新数据
        temp.setData(node.getData());
    }

    //遍历节点
    private void listDoubleList() {
        isEmpty();
        DoubleNode temp = headNode.getNext();
        while (true) {
            System.out.println(temp.toString());
            temp = temp.getNext();
            if (null == temp) {
                break;
            }
        }
    }


}
