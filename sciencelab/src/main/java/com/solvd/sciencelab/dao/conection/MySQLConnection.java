package com.solvd.sciencelab.dao.conection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

class MySQLConnection {
    public static void main(String args[]) {

        Properties props = new Properties();

        try {
                FileReader reader = new FileReader("src/main/resources/db.properties");
                props.load(reader);
            } catch (IOException e) {
                e.getMessage();
            }

        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String getConStr = url + "?" + user + "?" + password;

        String query = "Use gabriel_micillo";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager
                    .getConnection(getConStr);
            PreparedStatement ps = con.prepareStatement(query);
            ps.setLong(1, 1);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}