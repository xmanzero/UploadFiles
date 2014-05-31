

<%@page import="path.Dir"%>
<%@page import="com.sun.crypto.provider.RSACipher"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.*"%>
<%@page import="connectdb.OracleConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery.js"></script>
    </head>
    <body>
        <%
            response.setContentType("image/jpeg");
            Blob ePhoto = null;
            byte[] rawBytes = null;

            Connection connection = OracleConnect.getConnect(Dir.Host, Dir.Port, Dir.Service, Dir.UserName, Dir.PassWord);
            Statement st = connection.createStatement();
            ResultSet rs1 = null;

            try {
                
                ServletOutputStream outPut = response.getOutputStream();
                String id = request.getParameter("id");
                String query = "SELECT image FROM photos_SI where id = " + id;
                rs1 = st.executeQuery(query);
                while (rs1.next()) {
                    rawBytes = rs1.getBytes("image");
                    outPut.write(rawBytes);
                    outPut.flush();
                }
                st.close();
            } catch (Exception e) {
            } finally {
                rs1.close();
                st.close();
                connection.close();
            }
        %>

    </body>
</html>
