/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import connectdb.OracleConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import path.Dir;

/**
 *
 * @author smile_000
 */
public class IdPhotos {

    public List ListIdSource() {
        List lt = new ArrayList();
        ResultSet rs = null;
        Statement st=null;
        Connection connect = null;
        try {
            connect=OracleConnect.getConnect(Dir.Host, Dir.Port, Dir.Service, Dir.UserName, Dir.PassWord);
            st=connect.createStatement();
            rs= st.executeQuery("Select * From Photos_SI");
            while(rs.next()){                
                lt.add(rs.getString("id"));
            }
        } catch (Exception ex) {
            Logger.getLogger(IdPhotos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                st.close();
                rs.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(IdPhotos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lt;
    }
//    public static void main(String[] args) {
//        IdPhotos obj= new IdPhotos();
//        List sp= new ArrayList();
//        sp=obj.ListIdSource();
//        for(int i=0;i<sp.size();i++){
//            System.out.println(sp.get(i));
//        }
//    }
}
