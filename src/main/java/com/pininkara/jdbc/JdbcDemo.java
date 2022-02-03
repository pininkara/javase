// 2022/1/25 13:08

package com.pininkara.jdbc;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 用户信息和url
        String url="jdbc:mysql://localhost:3306/school?characterEncoding=utf8&useSSL=true&serverTimezone=UTC&rewriteBatchedStatements=true";
        String username="root";
        String pwd="MySQL80";

        //3. 连接成功，获得数据库对象
        Connection connection= DriverManager.getConnection(url,username,pwd);
        //4. 创建statement对象
        Statement statement = connection.createStatement();
        //5. 执行sql，获得结果
        String sql="select * from student";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id= "+resultSet.getObject("id"));
            System.out.println("name= "+resultSet.getObject("name"));
            System.out.println("age= "+resultSet.getObject("age"));
        }
        //6. 释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
