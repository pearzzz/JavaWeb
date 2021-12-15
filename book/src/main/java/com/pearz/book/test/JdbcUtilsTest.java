package com.pearz.book.test;

import com.pearz.book.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author pearz
 */
public class JdbcUtilsTest {

    @Test
    public void testConnection() {
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
    }

    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 100; i++){
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }

}
