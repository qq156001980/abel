package com.abel.db;

import java.sql.*;

/**
 * Created by 95 on 2015/5/28.
 */
public class DBConnection {
    private String URL = "jdbc:mysql://";
    private String OP = "?useUnicode=true";
    private String INNERADDR = null;
    private String DBTABLE = null;
    private String U_NAME = null;
    private String PASSWORD = null;
    private Connection conn = null;

    public DBConnection() {
    }

    public DBConnection(String INNERADDR, String DBTABLE, String u_NAME, String PASSWORD) {
        this.INNERADDR = INNERADDR;
        this.DBTABLE = DBTABLE;
        U_NAME = u_NAME;
        this.PASSWORD = PASSWORD;
        this.URL += this.INNERADDR + "/" + DBTABLE + OP;

    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Statement getStatement() {
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(URL, U_NAME, PASSWORD);
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  statement;
    }

    public PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement preparedStatement = null;
        try {
            conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public void closeAll(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
