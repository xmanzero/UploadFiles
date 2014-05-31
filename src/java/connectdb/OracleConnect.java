/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectdb;

import java.sql.*;
import path.Dir;

/**
 *
 * @author smile_000
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
public class OracleConnect {

    static Connection connect=null;

    /**
     *
     * @return @throws Exception
     */
    public static Connection getConnect(String Host, int Port, String Service, String UserName, String PassWord) throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");//jdbc:oracle:thin:@localhost:1521:orcl
        String url = "jdbc:oracle:thin:@" + Host + ":" + Port + ":" + Service;
        try {
            connect = DriverManager.getConnection(url, UserName, PassWord);
        } catch (java.sql.SQLException e) {
            throw new Exception("khong the ket noi");
        }

        return connect;
    }

}
