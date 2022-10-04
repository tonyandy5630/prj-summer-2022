<%-- 
    Document   : viewPlant
    Created on : Jul 5, 2022, 5:06:33 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="plantObj" class="sample.dto.Plant" scope="request" />
<!--        <table>
            <tr>
                <td rowspan="8">
                    <img src="<jsp:getProperty name="plantObj" property="imgpath" />" alt="" style="width:20vw">
                </td>
            </tr>
            <tr>
                <td>
                    id : <jsp:getProperty name="plantObj" property="id" ></jsp:getProperty>
                </td>
            </tr>
            <tr>
                <td>
                    product name = : <jsp:getProperty name="plantObj" property="name"></jsp:getProperty>
                </td>
            </tr>
            <tr>
                <td>
                    price : <jsp:getProperty name="plantObj" property="price" />
                </td>
            </tr>
            <tr>
                <td>
                    description : <jsp:getProperty name="plantObj" property="description" />
                </td>
            </tr>
            <tr>
                <td>
                    status : <jsp:getProperty name="plantObj" property="status" />
                </td>
            </tr>
            <tr>
                <td>
                    cate id : <jsp:getProperty name="plantObj" property="cateid" />
                </td>
            </tr>
            <tr>
                <td>
                    category : <jsp:getProperty name="plantObj" property="catename" />
                </td>
            </tr>
        </table>-->
        
        <table>
            <tr>
                <td rowspan="8">
                    <img src="${plantObj.imgpath}" alt="" style="width:20vw">
                </td>
            </tr>
            <tr>
                <td>
                    id : ${plantObj.id}
                </td>
            </tr>
            <tr>
                <td>
                    product name : ${plantObj.name}
                </td>
            </tr>
            <tr>
                <td>
                    price : ${plantObj.price}
                </td>
            </tr>
            <tr>
                <td>
                    description : ${plantObj.description}
                </td>
            </tr>
            <tr>
                <td>
                    status : ${plantObj.status}
                </td>
            </tr>
            <tr>
                <td>
                    cate id : ${plantObj.cateId}
                </td>
            </tr>
            <tr>
                <td>
                    category : ${plantObj.cateName}
                </td>
            </tr>
        </table>
    </body>
</html>
