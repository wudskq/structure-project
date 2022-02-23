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

#### 3.1 数组(稀疏数组)及应用场景

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

