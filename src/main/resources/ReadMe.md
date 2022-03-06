## JAVA数据结构与算法

### 1.算法与数据结构的关系

- 数据结构: 是一门研究组织数据方式的学,通俗来讲就是研究数据以什么样的方式组织在一起,自动有了编程语言,也就有了数据结构,学好数据结构就可以编写出更高效,更漂亮的代码
- 想要学好数据结构就要多多联系生活中的例子进行联系
- 程序 = 数据结构 + 算法, 数据结构是算法的基础
- eg: 例如数组就是一种数据结构

### 2.数据结构包含哪些？

- 数据结构主要包括线性结构与非线性结构
- 线性结构特点:
  - 线性结构作为最常用的数据结构,其特点是数据与数据之间存在一对一的线性关系
  - 线性结构有两种不同的存储结构:
    - 顺序存储结构: 顺序存储的线性表称为顺序表,顺序表中存储的元素是连续的
    - 链式存储结构: 链式存储的线性表称为链式表,链式表中存储的元素不一定是连续的,元素节点中存储元素本身信息外还存储相邻元素的地址信息
  - 线性结构常见的有: 数组,链表,队列,栈
- 非线性结构特点:
  - 常见的非线性数据结构有:二维数组,多维数组,广义表,树结构,图结构

### 3.数据结构

#### 3.1 数组(二维数组)及应用场景

- 场景介绍: 有一盘五子棋,需要使用计算机程序实现五子棋白旗黑棋功能,并实现存盘,续盘功能,利用合适的数据结构进行实现并尽可能做到内存占用最小

- 思路解析: 可使用二维数组进行实现,白棋设定为0,黑棋设定为1,存盘续盘功能使用数据库进行实现

- 存盘读盘表结构设计

  ```sql
  DROP TABLE IF EXISTS array_data;
  CREATE TABLE array_data(
      id bigint(32) NOT NULL AUTO_INCREMENT  COMMENT '' ,
      row_id int(60)    COMMENT '行号' ,
      column_id int(60)    COMMENT '列号' ,
      data int(60)    COMMENT '数据' ,
      PRIMARY KEY (id)
  )  COMMENT = '数组存盘表';
  ```

- 存盘: 遍历二维数组,拿到每行的所有数据,再次进行遍历row中的column的所有数据,存入data中

  ```java
   //存盘
      private static void saveChess(int[][] array) throws SQLException {
          String sql = "insert into array_data (row_id,column_id,data) value (?,?,?);";
          for (int i = 0; i < array.length; i++) {
              for (int j = 0; j < array[i].length ; j++) {
                  int item = array[i][j];
                  //保存每行数据
                  Conn.saveChess(sql,i,j,item);
              }
          }
      }
  ```

- 读盘: 遍历二维数组,根据row,column的index索引值作为查询条件查询出data,并赋值给该二维数组

  ```java
  //读盘
      private static void  queryChess(int[][] array) throws SQLException {
          for (int i = 0; i < array.length; i++) {
              for (int j = 0; j < array[i].length ; j++) {
                  int row = i,column = j;
                  String sql = String.format("select data from array_data where row_id =%d and column_id =%d", row, column);
                  int data = Conn.queryChess(sql, "data");
                  array[i][j] = data;
              }
          }
      }
  ```

#### 3.2 数组(稀疏数组)

- 场景依然是3.1五子棋盘场景,要求用最小的内存或存储空间实现五子棋盘的存盘/读盘功能

- 稀疏数组定义: 稀疏数组依然是一个二维数组,只不过是一个特殊的二维数组,该数组第一行存储普通二维数组的大小(即就是二维数组的行高,列宽,有效数的个数),从第二行开始存储改有效数据的位置

- 结构图解

  <img src="https://gitee.com/wudskq/cloud_img/raw/master/data/20220225003819.png" alt="image-20220225003813852" style="zoom:50%;" />

- 稀疏数组重点: 稀疏数组最重要的结构是为三列,除过第一行外,第一列存储行坐标,第二列存储列坐标,第三列存储数据

- 初始化: 遍历原始二维数据,找到有效值个数,及行高,列宽,

  ```java
   /**
       * 遍历原始数组,计算有效值并初始化稀疏数组;
       * @param array 数组
       */
      private static int[][] initArray(int[][] array){
          //计数器
          int count = 0;
          int row = 0,column =0;
          for (int i = 0; i < array.length; i++) {
               row = array.length;
               column = array[i].length;
              for (int j = 0; j < array[i].length; j++) {
                  int item = array[i][j];
                  if(item != 0){
                      count++;
                  }
              }
          }
          //初始化稀疏数组,有效值个数+1为行高
          int[][] sparseArray = new int[count+1][3];
          sparseArray[0][0] = row;
          sparseArray[0][1] = column;
          sparseArray[0][2] = count;
          return sparseArray;
      }
  ```

- 存盘:遍历原始二维数组,判断有效值,并从第二行开始存入稀疏数组

  ```java
    //存盘操作
      private static void saveChess(int[][] array,int[][] sparseArray){
          //计数器
          int count = 0;
          for (int i = 0; i < array.length; i++) {
              for (int j = 0; j < array[i].length; j++) {
                  int item = array[i][j];
                  //判断有效值
                  if(item != 0){
                      count ++;
                      //列的功能不变
                      sparseArray[count][0] = i;
                      sparseArray[count][1] = j;
                      sparseArray[count][2] = item;
                  }
              }
          }
      }
  ```

- 读盘: 取出稀疏数组第一行数据,进行初始化二维数组,接着从第二行开始遍历稀疏数组,进行有效值的填充

  ```java
   //读盘
      private static int[][] queryChess(int[][] sparseArray){
          //取出稀疏数组第一行数据,进行初始化二维数组
          int row = sparseArray[0][0];
          int column = sparseArray[0][1];
          int [][] array = new int[row][column];
          for (int i = 0; i < sparseArray.length-1; i++) {
              for (int j = 0; j< sparseArray[i].length-1 ; j++) {
                  int rowId = sparseArray[i + 1][0];
                  int columnId = sparseArray[i + 1][1];
                  int data = sparseArray[i + 1][2];
                  array[rowId][columnId] = data;
              }
          }
          return  array;
      }
  ```


#### 3.3  队列(数组实现)

- 业务场景描述: 银行排队叫号, 客户在大厅中打号,排队,第一个叫到号的人首先办理业务,一次二号,三号,等等 

- 遵循先进先出规则,第二个编号的客户也不需要关注自己站在哪,坐在哪,只需要关注自己前一个编号是否能被叫到,

- 队列概念: 队列是一个有序列表,可以用数组或链表来实现,遵循先进选出原则

- 数组实现队列示意图

  <img src="https://gitee.com/wudskq/cloud_img/raw/master/data/20220226193356.png" alt="image-20220226193356111" style="zoom: 50%;" />

- 数组实现队列思路(尾插法)

  -  队列需要遵循先进先出原则，使用数组实现队列,需要两个辅助指针(头部指针与尾部指针),还需要一个最大容量
  - 插入数据时,从尾部插入,尾指针下标后移,新增数据时记得判断该队列是否已满
  - 取出数据时,从头部取出,头指针下标后移,取出数据时记得判断该队列是否为空
  - 队列判空, 如果头部指针等于尾部指针说明该队列为初始化的队列,无数据新增(尾部指针未后移),则该队列为空
  - 队列判满,如果尾部指针等于该队列最大容量减一,则证明该队列已满,
  - 取出队列所有数据,遍历队列即可,遍历前记得判断该队列是否为空

- 初始化

  ```java
      //队列
      private static int[] array;
      //头指针
      private static int front;
      //尾指针
      private static int rear;
      //最大容量
      private static int maxSize;
     //初始化队列
      public ArrayImplQueue(int arrayMaxSize){
          maxSize = arrayMaxSize;
          array = new int[maxSize];
          front = -1;
          rear = -1;
      }
  ```

- 判空

  ```java
    //判断队列是否为空
      public void isEmpty(){
          //头部指针与尾部指针相等时,队列位空
          if(front == rear){
             throw new RuntimeException("queue is empty!");
          }
      }
  ```

- 判满

  ```java
    //判断队列是否已满
      public void isFull(){
          //尾部指针与最大容量减1相等时,队列已满
          if(rear == maxSize -1){
              throw new RuntimeException("queue is full!");
          }
      }
  ```

- 添加数据

  ```java
   //添加数据
      public void addQueue(int data){
          //添加数据时判断队列是否已满
          isFull();
          //尾指针后移
          rear++;
          array[rear] = data;
      }
  ```

- 取出数据

  ```java
   //取出数据
      public  int getQueue(){
          //取出数据时判断队列是否为空
          isEmpty();
          //头指针后移
          front++;
          int data = array[front];
          return data;
      }
  ```

- 取出队列所有数据

  ```java
   //取出队列所有数据
      public List<Integer> listQueue(){
          isEmpty();
          List<Integer> list = new ArrayList<>();
          for (int i = 0; i < array.length; i++) {
              int item = array[i];
              list.add(item);
          }
          return list;
      }
  ```

- 取出队列头部数据

  ```java
  
      //取出队列头部数据
      public int getQueueFront(){
          isEmpty();
          int data = array[0];
          return data;
      }
  ```

- 取出队列尾部数据

  ```java
     //取出队列尾部数据
      private int getQueueRear(){
          isEmpty();
          int i = array[rear];
          return i;
      }
  ```

#### 3.4 队列(环形队列)

- 3.1中数组实现的普通队列并不能实现复用

  ```java
   ArrayImplQueue queue = new ArrayImplQueue(10);
          queue.addQueue(1);
          queue.addQueue(2);
          queue.addQueue(3);
          queue.addQueue(4);
          queue.addQueue(5);
          queue.addQueue(6);
          queue.addQueue(7);
          queue.addQueue(8);
          queue.addQueue(9);
          queue.addQueue(10);
          System.out.println(queue.getQueue());
          List<Integer> list = queue.listQueue();
          queue.addQueue(11);
  ```

  - 当数据添加到队列最大容量后,取出队列先入的数据,在往队列中进行添加,会报错

  ```bash
  Connected to the target VM, address: '127.0.0.1:54920', transport: 'socket'
  1
  Exception in thread "main" java.lang.RuntimeException: queue is full!
  	at cn.com.wudskq.second.datastructure.queue.ArrayImplQueue.isFull(ArrayImplQueue.java:65)
  	at cn.com.wudskq.second.datastructure.queue.ArrayImplQueue.addQueue(ArrayImplQueue.java:72)
  	at cn.com.wudskq.second.datastructure.queue.ArrayImplQueue.main(ArrayImplQueue.java:40)
  Disconnected from the target VM, address: '127.0.0.1:54920', transport: 'socket'
  ```

- 未能实现队列的复用性! 使用数组实现环形队列就可以实现复用功能

- 指针仍然是两个指针,头指针front,尾指针rear,指针位置进行变化,初始化时front=0,rear=maxSize-1

- 当循环队列属于上图的d1情况时，是无法判断当前状态是队空还是队满。为了达到判断队列状态的目的，可以通过牺牲一个存储空间来实现。 
  如下图d2所示， 
  队头指针在队尾指针的下一位置时，队满。 Q.front == (Q.rear + 1) % MAXSIZE 因为头指针可能又重新从0位置开始，而此时队尾指针是MAXSIZE - 1，所以需要求余。 
  当队头和队尾指针在同一位置时，队空。 Q.front == Q.rear;

  <img src="https://gitee.com/wudskq/cloud_img/raw/master/data/20220228012609.png" alt="image-20220228012609730" style="zoom: 50%;" />

- 判断队列是否为空

  ```java
  //判断队列是否为空
      private Boolean isEmpty(){
          if(front == rear){
              throw new RuntimeException("queue is empty!");
          }
          return true;
      }
  
  ```

- 判断队列是否已满

  ```java
    //判断队列是否已满
      private Boolean isFull(){
          if((rear + 1) % maxSize == front){
              throw new RuntimeException("queue is full!");
          }
          return false;
      }
  ```

- 数据入队列

  ```java
     //入队
      private void addQueue(int data){
          isFull();
          array[rear] = data;
          rear = (rear+1)%maxSize;
      }
  ```

- 数据出队列

  ```java
   //出队
      private int getQueue(){
          isEmpty();
          int i = array[front];
          front = (front+1)%maxSize;
          return i;
      }
  ```


#### 3.5 链表(单向链表)

- 概念: 链表是有序的列表,链表存储在物理上是不连续的,在逻辑上存储是连续的

  - 链表分为有头部节点的链表与没有头部节点的链表

- 逻辑结构图

  <img src="https://gitee.com/wudskq/cloud_img/raw/master/data/20220301021749.png" alt="image-20220301021743772" style="zoom:50%;" />

- 物理结构图

  ![image-20220301022455258](https://gitee.com/wudskq/cloud_img/raw/master/data/20220301022455.png)

- 判断链表是否为空

  - 在有head节点的情况下只需要判断head节点的next指针是否为空

    ```java
     //判空
        private void isEmpty(){
            SingleNode temp = headNode;
            if(null == temp.getNext()){
                throw new RuntimeException("LinkedList is empty!");
            }
        }
    ```

- 链表新增数据

  - 链表新增数据时,都是新增在最后一个节点的next下

  - 创建一个辅助节点使之等于头部节点,无限循环,如果复制节点的next指针为空,则证明找到了链表的最后,则退出循环,否则辅助节点的next指针一直后移

    ```java
      //添加节点
        private void addSingeNode(SingleNode node){
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
    ```

- 链表删除数据

  - 链表删除指定index下的节点

  - 创建一个临时节点等于头部节点,循环遍历找到对应的下标位置

  - 主要是要获取到要删除节点的上一个节点,然后使上一个节点的next指向新的要删除节点的下一个节点,接着要删除节点的next指针置为空

    ```java
     //删除指定下标的节点
        private void delSingelNode(int index){
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
    ```

- 链表获取全部数据

  - 获取数据前判空
  - 循环便利链表即可,直到最后一个节点的next指针为空,则代表全部数据遍历完

- 链表更新数据

  - 循环便利获取指定下标的节点,更新该节点的data属性即可

    ```java
      //更新指定下标位置数据
        private void updateSingelNode(SingleNode node){
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
    ```

#### 3.6 单向链表(BAT面试题)

##### 3.6.1 求单链表中有效节点的个数

- 思路: 设置一个计数器,和辅助节点,循环遍历到最后一个节点即可

  ```java
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
  ```

##### 3.6.2 查找单链表中倒数第K个节点

- 思路分析: 快慢指针问题解决链表倒数问题,设置两个指针fast(快指针),slow(慢指针),都等于head节点,
- 先让fast指针向后移动k步,这个K值不能为小于0或者为负数
- 接着无限循环快满指针,fast = fast.getNext(), slow = slow.getNext(),
- 判断fast指针,如果快指针节点等于null,说明已经走到了链表最后,此时slow指针与fast指针相差k个距离,
- 即slow指针所在的节点就是倒数第K个数

```java
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
```

##### 3.6.3 单链表求中间节点

- 场景设计: 给定一个单向链表,返回这个单向链表的中间节点
- 思路分析: 设置快慢指针,fast,slow,快指针始终比慢指针步长多一倍,如果fast等于空,说明到了链表的最后一个节点,又因为slow指针的步长等于1/2的fast指针,即当前slow指针所指的节点就为当前链表的中点值

```java
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
```

##### 3.6.4 单链表的反转(迭代反转法)

- 图示

<img src="https://gitee.com/wudskq/cloud_img/raw/master/data/20220303200816.png" alt="image-20220303200810957" style="zoom: 50%;" />

- 思路解析 [10.1 迭代反转链表]()

- 迭代反转链表法:  设置三个指针 begin,middle,end, begin指针指向空,middle指向head节点,end指针指向head.next节点遍历链表,使其middle指向begin,随后三个指针都向后移动一步,直至end为空(middle.next为空),最后使其middle的next指针指向begin,head的next指针指向middle即可完成单向链表的反转

- 代码

  ```java
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
  ```

##### 3.6.5 单链表的反转(就地逆置法)

- 引用 

- 思路解析: 需要两个辅助指针begin&&end,begin指针指向head.next,end指针指向head.next.next,

  遍历链表,取出end节点数据,使head节点的next指针指向end,判断end是否为空,为空遍历结束,

  begin节点的next指针置为空

  

##### 3.6.6 从头到尾打印单链表

- 反向遍历
- stack栈

##### 3.6.7 合并两个有序单链表,合并之后链表仍然有序



### 3.7 链表(双向链表)

- 概念: 节点包括前指针(pre)及后指针(next),链表内存结构呈双向连接

- 原理图

  <img src="https://gitee.com/wudskq/cloud_img/raw/master/data/20220306215336.png" alt="image-20220306215330661" style="zoom: 50%;" />

- 链表判空: 拿到头节点判断headNode的next指针的下一个节点是否为空即可

  ```java
      //链表判空
      public void isEmpty(){
          if(null == headNode){
              return;
          }
          DoubleNode nextNode = headNode.getNext();
          if(null == nextNode){
              throw new RuntimeException("doubleLinkedList is empty!");
          }
      }
  ```

- 链表新增数据: 建立辅助指针等于头节点,遍历链表,找到最后一个节点,然后建立pre,next指针链接

  ```java
  
      //添加节点
      public void addDoubleNode(DoubleNode node){
          DoubleNode temp = headNode;
          Boolean flag = true;
          while (flag){
              //如果temp的next指针等于空
              //则证明temp为最后一个节点
              if(null == temp.getNext()){
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
  ```

- 链表删除数据(双向链表可实现节点自删除): 建立辅助指针使其等于headNode节点,遍历链表,找到下标等于要删除的节点,拿到要删除节点的pre节点与next节点,使其pre节点的next指针指向deleteNode的next节点,使其next节点的pre指针指向deleteNode节点的pre节点

  ```java
      //删除节点(节点自删除)
      public void  removeDoubleNode(int index){
          isEmpty();
          DoubleNode temp =  headNode;
          Boolean flag = true;
          DoubleNode pre = null;
          DoubleNode next = null;
          while (flag){
              int nodeIndex = temp.getIndex();
              if(nodeIndex == index){
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
  ```

- 链表更新数据: 建立辅助指针temp使其等于headNode,遍历链表找到temp.getIndex=index的节点,否则temp节点后移,直至找到,找到后数据正常赋值即可

  ```java
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
  ```

- 链表查询所有数据: 建立辅助指针使其等于haedNode,无限循环temp节点直至temp.next等于空为止

  ```java
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
  ```

  

































### 10.引用

#### 10.1 迭代反转链表

该算法的实现思想非常直接，就是从当前链表的首元节点开始，一直遍历至链表的最后一个节点，这期间会逐个改变所遍历到的节点的指针域，另其指向前一个节点。

具体的实现方法也很简单，借助 3 个指针即可。以图 1 中建立的链表为例，首先我们定义 3 个指针并分别命名为 beg、mid、end。它们的初始指向如图 3 所示：



![迭代反转链表的初始状态](https://gitee.com/wudskq/cloud_img/raw/master/data/20220304002838.gif)

​                                                                        图 3 迭代反转链表的初始状态


在上图的基础上，遍历链表的过程就等价为：3 个指针每次各向后移动一个节点，直至 mid 指向链表中最后一个节点（此时 end 为 NULL ）。需要注意的是，这 3 个指针每移动之前，都需要做一步操作，即改变 mid 所指节点的指针域，另其指向和 beg 相同。

\1) 在图 3 的基础上，我们先改变 mid 所指节点的指针域指向，另其和 beg 相同（即改为 NULL），然后再将 3 个指针整体各向后移动一个节点。整个过程如图 4 所示：



![迭代反转链表过程一](https://gitee.com/wudskq/cloud_img/raw/master/data/20220304002846.gif)

​                                                                           图 4 迭代反转链表过程一


\2) 在图 4 基础上，先改变 mid 所指节点的指针域指向，另其和 beg 相同（指向节点 1 ），再将 3 个指针整体各向后移动一个节点。整个过程如图 5 所示：



![迭代反转链表过程二](https://gitee.com/wudskq/cloud_img/raw/master/data/20220304002850.gif)
																	图 5 迭代反转链表过程二


\3) 在图 5 基础上，先改变 mid 所指节点的指针域指向，另其和 beg 相同（指向节点 2 ），再将 3 个指针整体各向后移动一个节点。整个过程如图 6 所示：



![迭代反转链表过程三](https://gitee.com/wudskq/cloud_img/raw/master/data/20220304002853.gif)
																	图 6 迭代反转链表过程三


\4) 图 6 中，虽然 mid 指向了原链表最后一个节点，但显然整个反转的操作还差一步，即需要最后修改一次 mid 所指节点的指针域指向，另其和 beg 相同（指向节点 3）。如图 7 所示：



![迭代反转链表过程四](https://gitee.com/wudskq/cloud_img/raw/master/data/20220304002801.gif)
																		图 7 迭代反转链表过程四

> 注意，这里只需改变 mid 所指节点的指向即可，不用修改 3 个指针的指向。

\5) 最后只需改变 head 头指针的指向，另其和 mid 同向，就实现了链表的反转。

```c
//迭代反转法，head 为无头节点链表的头指针
link * iteration_reverse(link* head) {
    if (head == NULL || head->next == NULL) {
        return head;
    }
    else {
        link * beg = NULL;
        link * mid = head;
        link * end = head->next;
        //一直遍历
        while (1)
        {
            //修改 mid 所指节点的指向
            mid->next = beg;
            //此时判断 end 是否为 NULL，如果成立则退出循环
            if (end == NULL) {
                break;
            }
            //整体向后移动 3 个指针
            beg = mid;
            mid = end;
            end = end->next;
        }
        //最后修改 head 头指针的指向
        head = mid;
        return head;
    }
}
```

#### 10.2 就地逆置法反转链表

就地逆置法和头插法的实现思想类似，唯一的区别在于，头插法是通过建立一个新链表实现的，而就地逆置法则是直接对原链表做修改，从而实现将原链表反转。

值得一提的是，在原链表的基础上做修改，需要额外借助 2 个指针（假设分别为 beg 和 end）。仍以图 1 所示的链表为例，接下来用就地逆置法实现对该链表的反转：
\1) 初始状态下，令 beg 指向第一个节点，end 指向 beg->next，如图 16 所示：


![就地反转链表的初始状态](https://gitee.com/wudskq/cloud_img/raw/master/data/20220304014829.gif)
图 16 就地反转链表的初始状态


\2) 将 end 所指节点 2 从链表上摘除，然后再添加至当前链表的头部。如图 17 所示：


![反转节点2](https://gitee.com/wudskq/cloud_img/raw/master/data/20220304014826.gif)
图 17 反转节点 2


\3) 将 end 指向 beg->next，然后将 end 所指节点 3 从链表摘除，再添加到当前链表的头部，如图 18 所示：


![反转节点3](https://gitee.com/wudskq/cloud_img/raw/master/data/20220304014824.gif)
图 18 反转节点 3


\4) 将 end 指向 beg->next，再将 end 所示节点 4 从链表摘除，并添加到当前链表的头部，如图 19 所示：


![反转节点 4](https://gitee.com/wudskq/cloud_img/raw/master/data/20220304014821.gif)
图 19 反转节点 4


由此，就实现了对图 1 链表的反转。 

具体实现代码如下：

```c
link * local_reverse(link * head) {
    link * beg = NULL;
    link * end = NULL;
    if (head == NULL || head->next == NULL) {
        return head;
    }
    beg = head;
    end = head->next;
    while (end != NULL) {
        //将 end 从链表中摘除
        beg->next = end->next;
        //将 end 移动至链表头
        end->next = head;
        head = end;
        //调整 end 的指向，另其指向 beg 后的一个节点，为反转下一个节点做准备
        end = beg->next;
    }
    return head;
}
```

#### 10.3 总结

本节仅以无头节点的链表为例，讲解了实现链表反转的 4 种方法。实际上，对于有头节点的链表反转：

- 使用迭代反转法实现时，初始状态忽略头节点（直接将 mid 指向首元节点），仅需在最后一步将头节点的 next 改为和 mid 同向即可；
- 使用头插法或者就地逆置法实现时，仅需将要插入的节点插入到头节点和首元节点之间即可；
- 递归法并不适用反转有头结点的链表（但并非不能实现），该方法更适用于反转无头结点的链表。
