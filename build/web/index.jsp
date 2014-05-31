<%-- 
    Document   : index
    Created on : Nov 24, 2013, 10:18:16 AM
    Author     : quanghv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.app.uploads.ImageUploads" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resource/css/style.css"/>
        <link rel="stylesheet" href="resource/css/form.css"/>
        <title>File Upload Example in JSP and Servlet - Java web application</title>
    </head>

    <body> 
        <div class="href"><a href="SearchEngine.jsp">|| Search</a>  ||  <a href="index.jsp">  Insert data ||</a></div>
        <div id="body">
            
            <h3> Choose File to Upload in Server </h3>
            <table>
                <form action="ImageUploads" method="post" enctype="multipart/form-data">
                    <tr>
                        <td class="tbcat"><label>Descrription</label></td><td><input type="text" size="45" name="descrip" /></td>
                    </tr>
                    <tr>
                        <td class="tbcat"><label>Location</label></td><td><input type="text" size="45" name="locator" /></td>
                    </tr>
                    <tr>
                        <td ></td> <td><input type="file" name="file" /></td>
                    </tr>
                    <tr>
                        <td style="text-align: center;">
                           
                        </td>
                        <td style="text-align: center;"> <input type="submit" value="upload" /><input type="reset" value="reset" /></td>
                    </tr>
                </form>
            </table>
        </div>

    </body>
</html>
