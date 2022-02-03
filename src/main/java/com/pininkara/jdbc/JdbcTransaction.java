// 2022/1/25 14:30

package com.pininkara.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTransaction {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection.setAutoCommit(false);//关闭自动提交，开启事务
            String sql = "";
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.rollback();//失败则回滚


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
