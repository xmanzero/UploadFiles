/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import connectdb.OracleConnect;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import path.Dir;

/**
 *
 * @author smile_000
 */
public class GetPhoto {

    public static byte[] getPhoto(int iNumPhoto)
            throws Exception, SQLException {
        Blob img;
        byte[] imgData = null;
        Connection connect = OracleConnect.getConnect(Dir.Host, Dir.Port, Dir.Service, Dir.UserName, Dir.PassWord);

        // Query
        CallableStatement cs = null;
        cs = connect.prepareCall("{call STILL_CONTENT(?,?)}");
        cs.setInt(1, iNumPhoto);
        cs.registerOutParameter(2, Types.BLOB);
        cs.execute();
        img = cs.getBlob(2);
        imgData = img.getBytes(1, (int) img.length());
        cs.close();
        connect.close();
        return imgData;
    }
}
