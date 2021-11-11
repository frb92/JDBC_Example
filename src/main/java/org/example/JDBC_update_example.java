package org.example;

import java.sql.*;

public class JDBC_update_example {
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
            String sql1 = "UPDATE emloyees SET city = 'wroclow' WHERE id >= 2";

            statement.executeUpdate(sql1);

            String sql2 = "UPDATE emloyees SET salary = 9999 WHERE id IN (1,2)";

            statement.executeUpdate(sql2);



        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                //resultSet.close();
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

