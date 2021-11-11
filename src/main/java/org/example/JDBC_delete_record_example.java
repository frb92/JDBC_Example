package org.example;

import java.sql.*;

public class JDBC_delete_record_example {
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
            String sql1 = "DELETE FROM emloyees WHERE id = 2";

            statement.executeUpdate(sql1);

            String sql2 = "DELETE FROM emloyees WHERE name = 'Rafal'";

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

