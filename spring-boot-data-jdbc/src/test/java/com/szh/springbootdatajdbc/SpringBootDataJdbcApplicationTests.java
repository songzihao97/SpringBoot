package com.szh.springbootdatajdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.*;

@SpringBootTest
class SpringBootDataJdbcApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection=dataSource.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user");
        while(rs.next()){
            //获取数据
            int id = rs.getInt(1);
            String name = rs.getString("username");
            String password = rs.getString("password");
            System.out.println(id + "---" + name + "---" +password );
        }
        rs.close();
        stmt.close();
        connection.close();
    }

}
