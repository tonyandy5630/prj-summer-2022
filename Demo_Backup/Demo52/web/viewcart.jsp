<%-- 
    Document   : viewcart
    Created on : Jun 14, 2022, 1:53:24 PM
    Author     : thanhtra
--%>

<%@page import="java.util.Date"%>
<%@page import="basicobject.Plant"%>
<%@page import="mydao.PlantDao"%>
<%@page import="myservlet.mainController"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function askConfirm() {
                var ans = window.confirm("Ban muon bo san phan nay?");
                if (ans === true)
                    return true;
                return false;
            }
        </script>

    </head>
    <body>
        <%
            //lay cart trong session memory
            HashMap<String, Integer> cart = (HashMap) session.getAttribute("cart");
            if (cart != null && cart.size() > 0) {


        %>

        <table>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>img</th>
                <th>price</th>
                <th>quantity</th>
            </tr>


            <%                int total = 0;
                for (String id : cart.keySet()) {

                    Plant p = PlantDao.getPlant(Integer.parseInt(id));
            %>
            <form action="mainController" method="post" >
                <input type="hidden" value="<%= id%>" name="txtid" />
                <tr>
                    <td><%= id%></td>
                    <td><%=  p.getName()%> </td>
                    <td> <img src="<%= p.getImgpath()%>" width="100"  height="100"/></td>
                    <td> <%= p.getPrice()%></td>
                    <td><input type="number" min="1" max="10" value="<%= cart.get(id)%>" name="txtQuantity">  </td>
                    <td>
                        <input type="submit" value="remove" name="action" onclick="return askConfirm()">
                        <input type="submit" value="update" name="action" >
                    </td>
                </tr>
            </form>
            <%
                    total = total + cart.get(id) * p.getPrice();
                }
            %>
        </table>
        <p>Tong tien thanh toan: <%= total%> vnd </p>
        <p>Ngay dat: <%= (new Date()).toString()%></p>
        <p>Ngay giao: du kien sau 7 ngay</p>
        <p>
        <form action="mainController" method="post">
            <p>Ten Kh: <input type="text" placeholder="nhap ten" /><font color="red">*</font></p>
            <p>sdt: <input type="text" placeholder="nhap sdt" /><font color="red">*</font></p>
            <p>email: <input type="text" placeholder="nhap email"/></p>
            <p> <%= request.getParameter("warningFillForm") != null ? request.getParameter("warningFillForm") : ""%> </p>
            <p><input type="submit" name="action" value="hoanthanhdonhang"></p>
        </form>
    </p>
    <%            } else {
            out.print("<p>Mua gi di ban oi!</p>");
            out.print("<p><a href='mainController'>tro ve </a></p>");
        }
    %>
    <%
        String msg = request.getParameter("warning");
        if (msg != null) {
    %>

    <script>
        var ans = window.confirm("Ban chua login. Ban co muon login khong?");
        alert(ans);
        if (ans === true)
            window.open("login.jsp");
        else
            window.open("viewcart.jsp?warningFillForm='Vui long dien form'");
    </script>
    <%
        }
    %>
</body>
</html>
