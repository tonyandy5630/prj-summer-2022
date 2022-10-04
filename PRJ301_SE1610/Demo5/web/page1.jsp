<%-- 
    Document   : page1
    Created on : Jun 7, 2022, 4:25:07 PM
    Author     : user
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="page2.jsp?data='anh yeu em'&data2=100"> link</a>
        <%
          String s=request.getParameter("result");          
        %>
        <p><%= (s!=null)? s: "" %></p>
        <hr/>
        <form action='Servlet1' method="get">
            <input type="text" name="txtsearch" value="<%= request.getParameter("keyword") %>"/>
            <input type="submit" value='find'/>
        </form>
        <!-- cho nay de xuat ket qua sau khi find -->
        <%
           ArrayList<String> list=(ArrayList)request.getAttribute("foundlist");
           if(list!=null && list.size()>0){
        %>
        <table>
            <% for(String str: list) {%>
            <form action='Servlet2' method='post'>
                <input type="hidden" value="<%= str %>" name="txt"/>
                <tr>
                    <td><%= str %></td>
                    <td><input type="submit" value='remove'/></td>
                </tr>
            </form>
            <%}%>
        </table>
        
        <%
           }
           else
           {
               out.println("not found");
           }
        %>
        <a href="Servlet3"> click vao day de doc cookie</a>
    </body>
</html>
