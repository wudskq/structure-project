package cn.com.wudskq.datastructure.linkedlist;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName CircularLinkedList.java
 * @Description TODO 单向环形链表,带头节点
 * @createTime 2022年03月07日 00:40:00
 */
public class CircularHeadNodeLinkedList {

    //头节点
    private CircularNode headNode = new CircularNode(-1, "headNode");


    public static void main(String[] args) {
        CircularHeadNodeLinkedList circularHeadNodeLinkedList = new CircularHeadNodeLinkedList();

        CircularNode node1 = new CircularNode(0, "0");
        CircularNode node2 = new CircularNode(1, "1");
        CircularNode node3 = new CircularNode(2, "2");
        CircularNode node4 = new CircularNode(3, "3");
        CircularNode node5 = new CircularNode(4, "4");

        //添加数据
        circularHeadNodeLinkedList.addCircularNode(node1);
        circularHeadNodeLinkedList.addCircularNode(node2);
        circularHeadNodeLinkedList.addCircularNode(node3);
        circularHeadNodeLinkedList.addCircularNode(node4);
        circularHeadNodeLinkedList.addCircularNode(node5);

        //遍历链表
        circularHeadNodeLinkedList.listCircularList();

        System.out.println("删除节点");
        circularHeadNodeLinkedList.removeCircularNode(2);
        //遍历链表
        circularHeadNodeLinkedList.listCircularList();

        System.out.println("更新节点");
        circularHeadNodeLinkedList.updateCircularNode(new CircularNode(2, "更新节点"));
        //遍历链表
        circularHeadNodeLinkedList.listCircularList();

    }


    //环形链表判空
    public Boolean isEmpty() {
        if (null == headNode) {
            return true;
        }
        if (null == headNode.getNext()) {
            return true;
        }
        return false;
    }

    //环形链表size
    public int size() {
        isEmpty();
        int count = 0;
        CircularNode temp = headNode.getNext();
        Boolean flag = true;
        while (flag) {
            temp = temp.getNext();
            count++;
            //判断到达队列最后
            if (headNode == temp) {
                flag = false;
                break;
            }
        }
        return count;
    }


    //环形链表添加数据
    public void addCircularNode(CircularNode node) {
        CircularNode temp = headNode;
        Boolean flag = true;
        while (flag) {
            //第一次添加数据时,next指针为空代表该节点为链表最后节点
            if (null == temp.getNext()) {
                flag = false;
                break;
            }
            //第二次开始,需要判断该节点的next指针是否指向headNode节点
            if (temp.getNext().equals(headNode)) {
                flag = false;
                break;
            }
            temp = temp.getNext();
        }
        //尾部添加数据
        temp.setNext(node);
        //尾部链接headNode
        node.setNext(headNode);
    }


    //环形链表删除数据
    public void removeCircularNode(int index) {
        isEmpty();
        CircularNode temp = headNode;
        Boolean flag = true;
        CircularNode next = null;
        while (flag) {
            //找到要删除节点的上一个节点
            if (index == temp.getNext().getIndex()) {
                flag = false;
                //要删除节点的下一个节点
                next = temp.getNext().getNext();
                //删除节点的next置空
                temp.getNext().setNext(null);
                break;
            }
            temp = temp.getNext();
        }
        //pre节点链接node的next指针节点
        temp.setNext(next);
    }


    //环形链表更新数据
    public void updateCircularNode(CircularNode node) {
        isEmpty();
        CircularNode temp = headNode;
        Boolean flag = true;
        int index = node.getIndex();
        while (flag) {
            //找到需要更新的节点
            if (index == temp.getIndex()) {
                flag = false;
                temp.setData(node.getData());
                break;
            }
            temp = temp.getNext();
            //代表找遍所有链表节点
            if (headNode == temp) {
                System.out.println("下标" + index + "不存在");
                break;
            }
        }
    }

    //获取指定位置的节点数据
    public CircularNode getIndex(int index) {
        isEmpty();
        CircularNode temp = headNode;
        Boolean flag = true;
        while (flag) {
            //找到需要更新的节点
            if (index == temp.getIndex()) {
                flag = false;
                break;
            }
            temp = temp.getNext();
            //代表找遍所有链表节点
            if (headNode == temp) {
                System.out.println("下标" + index + "不存在");
                break;
            }
        }
        return temp;
    }


    //环形链表遍历
    public void listCircularList() {
        CircularNode temp = headNode.getNext();
        Boolean flag = true;
        while (flag) {
            System.out.println(temp.toString());
            //判断节点是否为最后一个节点
            //即判断该节点的next指针是否指向headNode
            if (headNode == temp.getNext()) {
                flag = false;
                break;
            }
            temp = temp.getNext();
        }
    }
}

