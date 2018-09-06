package test.com.zy.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTest {
    public static void main(String[] args) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://localhost:3306/day10";
            String username = "root";
            String password = "root";

            conn = DriverManager.getConnection(url, username, password);

            String sql = "select * from user where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2);
            rs = stmt.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            int nums = metaData.getColumnCount();

            while (rs.next()) {
                Map map = new HashMap<String, Object>();
                for (int i = 0; i < nums; i++) {
                    String columnName = metaData.getColumnName(i + 1);
                    String columnValue = rs.getString(columnName);
                    map.put(columnName, columnValue);
                }
                resultList.add(map);
            }
            System.out.println(resultList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    stmt = null;
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    conn = null;
                }
            }
        }
    }
}
