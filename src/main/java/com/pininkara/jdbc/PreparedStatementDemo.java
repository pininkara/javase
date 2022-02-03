// 2022/1/25 14:06

package com.pininkara.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement statement=null;

        try{
            String sql="insert into student(id,`name`,`password`) values(?,?,?)";
            statement=connection.prepareCall(sql);//预编译SQL，不执行
            statement.setInt(1,4);
            statement.setString(2,"zhangsan");
            statement.setString(3,"pass123456");//赋值
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
