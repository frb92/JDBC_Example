package org.example;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class JDBC_select_example {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
             connection =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
            if(connection == null) {
                System.out.println("Brak połączenia z bazą danych");
            }else {
                System.out.println("Jest połaczenie");
            }
            statement = connection.createStatement();
            String sql = "SELECT * FROM emloyees WHERE id >= 2";
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
               int id = resultSet.getInt("id");
               String name = resultSet.getString("name");
               String address = resultSet.getString("city");
               int salary = resultSet.getInt("salary");
                System.out.println("id: " + id + " name: " + name + " city: " + address + " salary: " + salary);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                resultSet.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            try {
                statement.close();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            try {
                    connection.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

    }
    }

