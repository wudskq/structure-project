package cn.com.wudskq.utils;//导入包

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 数据库连接
 */
public class Conn {

    private static Connection con = null;

    public static void main(String[] args) throws SQLException {
        int data = queryChess("select data from array_data where row_id =" + 1 + " and column_id =" + 1, "data");
        System.out.println(data);
    }

    public static Connection getMysqlConnection() throws SQLException {

        //jdbc驱动
        String driver = "com.mysql.cj.jdbc.Driver";
        //这里我的数据库是cxxt
        String url = "jdbc:mysql://localhost:3306/data _structure?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
        return null;
    };


    //读盘
    public static int queryChess(String sql,String column) throws SQLException {
        Connection connection = getMysqlConnection();
        assert connection != null;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int data = Integer.parseInt(resultSet.getString(column));
            return data;
        }
        con.close();
        return 3;
    }


    //存盘
    public static void saveChess(String sql,int row,int column,int data) throws SQLException {
        Connection connection = getMysqlConnection();
        assert connection != null;
        PreparedStatement ps = connection.prepareStatement(sql);
        try {
            connection.setAutoCommit(false);//自动提交记得关了....
            ps.setString(1, String.valueOf(row));
            ps.setString(2, String.valueOf(column));
            ps.setString(3, String.valueOf(data));
            ps.addBatch();
            ps.executeBatch();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }


}

