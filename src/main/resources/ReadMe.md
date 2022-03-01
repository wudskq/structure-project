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

#### 3.2数组(稀疏数组)

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


#### 3.5链表(单向链表)

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

- 求单链表中有效节点的个数
- 查找单链表中倒数第K个节点
- 单链表的反转
- 从头到尾打印单链表
  - 反向便利
  - stack栈
- 合并两个有序单链表,合并之后链表仍然有序



