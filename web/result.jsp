<%-- 
    Document   : upload
    Created on : Nov 24, 2013, 10:56:55 AM
    Author     : quanghv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            <table> 
                <tr>
                    <td class="tbcat">Directory</td> <td class="inf">${path}</td>
                </tr>
            <tr>
                <td class="tbcat">Description</td><td class="inf">${Description}</td>
            </tr>
            <tr>
                <td class="tbcat">Locator</td><td class="inf">${Locator}</td>
            </tr>
            </table>
            <h3>${requestScope["message"]}</h3>
        </div>
    </body>
</html>
