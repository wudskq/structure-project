package cn.com.wudskq.datastructure.linkedlist;


/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName CircularLinkedList.java
 * @Description TODO 单向环形链表,不带头节点
 * @createTime 2022年03月07日 00:40:00
 */
public class CircularLinkedList {

    //first指针
    public   CircularNode first = null;

    public static void main(String[] args) {

        CircularLinkedList circularHeadNodeLinkedList = new CircularLinkedList();

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


        System.out.println("删除节点");
        circularHeadNodeLinkedList.removeCircularNode(2);

        System.out.println("遍历链表");
        //遍历链表
        circularHeadNodeLinkedList.listCircularList();

        System.out.println("获取指定节点数据");
        //获取指定节点数据
        CircularNode node = circularHeadNodeLinkedList.getIndex(3);
        System.out.println(node);


        System.out.println("更新节点");
        circularHeadNodeLinkedList.updateCircularNode(new CircularNode(3, "更新节点"));
        //遍历链表
        circularHeadNodeLinkedList.listCircularList();

        System.out.println("链表大小");
        System.out.println(circularHeadNodeLinkedList.size());

    }


    //环形链表判空
    public Boolean isEmpty() {
        if(null == first){
            return true;
        }
        return false;
    }

    //环形链表size
    public int size() {
        isEmpty();
        int count = 0;
        CircularNode temp = first;
        Boolean flag = true;
        while (flag) {
            temp = temp.getNext();
            count++;
            //判断到达队列最后
            if (first == temp) {
                flag = false;
                break;
            }
        }
        return count;
    }


    /**
     * first 第一个指针
     * node  新增的数据
     * @param node
     */
    public void addCircularNode(CircularNode node) {
        CircularNode current = first;
        Boolean flag = true;
        Boolean firstFlag = false;
        while (flag) {
            //第一次添加数据时,next指针为空代表该节点为链表最后节点
            if (null == first) {
                first = node;
                //尾部添加数据
                node.setNext(first);
                flag = false;
                break;
            }
            //第二次开始,需要判断该节点的next指针是否指向first节点
            if (current.getNext().equals(first)) {
                //从第二次开始,标志位更新
                firstFlag = true;
                flag = false;
                break;
            }
            //指针后移
            current = current.getNext();
        }
        //第一次添加数据自己构建环形
        if(firstFlag){
            //构建环形
            current.setNext(node);
            node.setNext(first);
        }
    }


    //环形链表删除数据
    public void removeCircularNode(int index) {
        isEmpty();
        CircularNode temp = first;
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
        CircularNode temp = first;
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
            if (first == temp) {
                System.out.println("下标" + index + "不存在");
                break;
            }
        }
    }

    //获取指定位置的节点数据
    public CircularNode getIndex(int index) {
        isEmpty();
        CircularNode temp = first;
        Boolean flag = true;
        while (flag) {
            //找到需要更新的节点
            if (index == temp.getIndex()) {
                flag = false;
                break;
            }
            //判断链表中是否只剩下最后一个节点
            if(null == temp.getNext()){
                flag = false;
                break;
            }
            temp = temp.getNext();
            //代表找遍所有链表节点
            if (first == temp) {
                flag = false;
                System.out.println("下标" + index + "不存在");
                break;
            }
        }
        return temp;
    }


    //环形链表遍历
    public void listCircularList() {
        CircularNode temp = first;
        Boolean flag = true;
        while (flag) {
            System.out.println(temp.toString());
            //判断节点是否为最后一个节点
            //即判断该节点的next指针是否指向headNode
            if (first == temp.getNext()) {
                flag = false;
                break;
            }
            temp = temp.getNext();
        }
    }

    //约瑟夫问题
    public void josePhus(int k, int m) {
        Boolean flag = true;
        CircularNode helper=first;
        //通过循环将helper辅助节点，调至指向未开始前最后一个节点
        while (true){
            if (helper.getNext()==first) {
                break;
            }
            helper=helper.getNext();
        }
        //先移动first和helper,移动k-1次
        //使其分别指向报数时的第一个节点和最后一个节点
        for(int j=0;j<k-1;j++){
            first=first.getNext();
            helper=helper.getNext();
        }
        //随着每个位置的人的报数first后移, 移动m-1次
        //需注意的是因为first已经指向了第一个人所以first移动位数要比报数人数少一位
        while(true){
            if (helper==first){
                //说明环中仅有一个节点
                break;
            }
            for (int j=0;j<m-1;j++){
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.println("序号为"+first.getIndex()+"的人出列");
            first= first.getNext();
            helper.setNext(first);//删除节点，成环
        }
        System.out.println("序号为"+first.getIndex()+"的人最后出列");
    }
}

