/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createdb;

import connectdb.OracleConnect;
import java.sql.CallableStatement;
import java.sql.Connection;
import path.Dir;

/**
 *
 * @author smile_000
 */
public class CreatData {

    public static void InsertData(String name) throws Exception {
        Connection connect = OracleConnect.getConnect(Dir.Host, Dir.Port, Dir.Service, Dir.UserName, Dir.PassWord);
        CallableStatement pro = connect.prepareCall("{call STILL_INSERT(?,?,?)}");
        pro.setString(1, name);
        pro.setString(2, "Photo demo Nigeria");
        pro.setString(3, "Nigeria");
        pro.executeQuery();
        pro.close();
        connect.close();
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 1000; i++) {
            String name = Integer.toString(i) + ".jpg";
            CreatData.InsertData(name);
        }
    }
}
