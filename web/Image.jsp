<%-- 
    Document   : Image
    Created on : May 30, 2014, 12:26:12 AM
    Author     : smile_000
--%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@page import="java.sql.Connection"%>
<%@page import="path.Dir"%>
<%@page import="connectdb.OracleConnect"%>
<%@page import="process.GetPhoto"%>
<%@ page import = "java.io.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Connection connect = OracleConnect.getConnect(Dir.Host, Dir.Port, Dir.Service, Dir.UserName, Dir.PassWord);
            int iNumPhoto;
            if (request.getParameter("id") != null) {

                iNumPhoto = Integer.parseInt(request.getParameter("id"));

                try {
                    connect.setAutoCommit(false);

                    // get the image from the database
                    byte[] imgData = GetPhoto.getPhoto(iNumPhoto);
                    // display the image
                    response.setContentType("image/gif");
                    ServletOutputStream o = response.getOutputStream();
                    o.write(imgData);
                    o.flush();
                    o.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                } finally {

                    connect.close();
                }
            }
        %>
    </body>
</html>
