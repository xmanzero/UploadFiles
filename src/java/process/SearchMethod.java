/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import collection.Score;
import collection.ScoreCompare;
import connectdb.OracleConnect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import path.Dir;

/**
 *
 * @author smile_000
 */
public class SearchMethod {

    public List Avg() {
        List list1;
        List<Score> list2 = new ArrayList<Score>();
        IdPhotos obj = new IdPhotos();
        list1 = obj.ListIdSource();
        Connection connect = null;
        Statement st = null;
        CallableStatement cs = null;
        try {
            connect = OracleConnect.getConnect(Dir.Host, Dir.Port, Dir.Service, Dir.UserName, Dir.PassWord);
            for (int i = 0; i < list1.size(); i++) {
                cs = connect.prepareCall("{call match_averageColor(?,?,?)}");
                int k = Integer.parseInt((String) list1.get(i));
                //System.out.println(k);
                cs.setInt(1, 2);
                cs.setInt(2, k);
                cs.registerOutParameter(3, Types.DOUBLE);
                cs.execute();
                double Score = cs.getDouble(3);
                System.out.println(Score);
                if (Score < 8) {
                    list2.add(new Score(Integer.parseInt((String) list1.get(i)), Score));
                }
            }
            Collections.sort(list2, new ScoreCompare());
            st = connect.createStatement();
            st.executeUpdate("delete from photos_test where id=2");
        } catch (Exception ex) {
            Logger.getLogger(SearchMethod.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                st.close();
                cs.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(SearchMethod.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list2;
    }

    public List Histogram() {
        List list1;
        List<Score> list2 = new ArrayList<Score>();
        IdPhotos obj = new IdPhotos();
        list1 = obj.ListIdSource();
        Connection connect = null;
        Statement st = null;
        CallableStatement cs = null;
        try {
            connect = OracleConnect.getConnect(Dir.Host, Dir.Port, Dir.Service, Dir.UserName, Dir.PassWord);
            for (int i = 0; i < list1.size(); i++) {
                cs = connect.prepareCall("{call score_ColorHistogram(?,?,?)}");
                int k = Integer.parseInt((String) list1.get(i));
                //System.out.println(k);
                cs.setInt(1, 2);
                cs.setInt(2, k);
                cs.registerOutParameter(3, Types.DOUBLE);
                cs.execute();
                double Score = cs.getDouble(3);
                System.out.println(Score);
                if (Score < 25) {
                    list2.add(new Score(Integer.parseInt((String) list1.get(i)), Score));
                }
            }
            Collections.sort(list2, new ScoreCompare());
            st = connect.createStatement();
            st.executeUpdate("delete from photos_test where id=2");
        } catch (Exception ex) {
            Logger.getLogger(SearchMethod.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                st.close();
                cs.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(SearchMethod.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list2;
    }

//    public static void main(String[] args) {
//        List list = new ArrayList();
//        SearchMethod obj = new SearchMethod();
//        list = obj.Avg();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//    }
}
