<%-- 
    Document   : SearchEngine
    Created on : May 11, 2014, 10:46:23 AM
    Author     : VietAnh
--%>

<%@page import="collection.Score"%>
<%@page import="process.SearchMethod"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="resource/css/style.css"/>
        <title>Tìm kiếm</title>
        <script type="text/javascript" src="ajax.js" ></script>
        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#ksimd img').hover(function(){
                var str = $(this).attr('data-tooltip');
                $('<p class="tooltip"></p>').text(str).appendTo('body').fadeIn(600);
            }, function(){
                $('.tooltip').remove();
            }).mousemove(function(e){
                var x = e.pageX + 20;
                var y = e.pageY;
                $('.tooltip').css({top : y, left : x});
            });
        });
    </script>
    </head>

    <body>
        <div class="href"><a href="SearchEngine.jsp">|| Search</a>  ||  <a href="index.jsp">  Insert data ||</a></div>
        <div id="sbox" class="sform">
            <div class="logoBKS">BKS</div>
            <div>
                <form action="ImageTest" method="post" enctype="multipart/form-data">
                    <div>

                        <input type="file" name="file" />
                        <select name="type" >
                            <option value="1">Hostogram</option>
                            <option value="2">Avg color</option>
                        </select>
                        <input class="bts" type="submit" value="Seach" style="background:url(resource/images/icon.png)" >




                    </div>
                </form>
            </div>

            <div id="showr">
                <%

                    List<Score> list = new ArrayList<Score>();
                    SearchMethod obj = new SearchMethod();
                    String nofi = (String) request.getAttribute("success");
                    if (nofi == "ok") {
                        String type = (String) request.getAttribute("type");
                        int i = Integer.parseInt(type);
                        long start = System.currentTimeMillis();
                        switch (i) {
                            case 1:
                                list = obj.Histogram();
                                break;
                            case 2:
                                list = obj.Avg();
                                break;
                            default:
                                break;
                        }
                        long end = System.currentTimeMillis();
                        long time = end - start;
                        out.print("Tìm kiếm được "+list.size()+"kết quả, trong "+time+"mini giây");
                %>
            </div><div id="ksimd">
            <%
                if (list.size() > 0) {
                    for (Score emp:list) {

                        int k = emp.getId_photo();


            %>
            <img src="Image.jsp?id=<%=k%>" width="220" height="150"data-tooltip="Score: <%=emp.getScore()%>" class="img"/>
            <%
                        }
                    }
                }
            %>
            
            </div>
        </div>
    </body>
</html>
