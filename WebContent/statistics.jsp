<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 
    Document   : statistics
    Created on : Jul 22, 2019, 5:36:10 PM
    Author     : FALCON
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistics</title>
    </head>
    <body>
        <h1>Statistics</h1>
       <br>
       <table>
           <tr>
               <th>Theft</th>
               <td>${theft}</td>
           </tr>
           <tr>
               <th>Robbery</th>
               <td>${robbery}</td>
           </tr>
           <tr>
               <th>Assault</th>
               <td>${assault}</td>
           </tr>
           <tr>
               <th>Attempted Murder</th>
               <td>${attempted_murder}</td>
           </tr>
           <tr>
               <th>Murder</th>
               <td>${murder}</td>
           </tr>
       </table>
       
       <h1><a href="<c:url value="../logout"/>">Log in</a></h1>
       
    </body>
</html>
