    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet"> 
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    </head>
    <body>
       <jsp:include page="header.jsp"/>
       
       
       
        <h1 style="margin-left: 10%;">Welcome ${sessionScope.user.getUsername()}!</h1>
        <h1 style="margin-left: 10%;">Users List</h1>
	<table border="2" width="80%" cellpadding="2" style="margin-top: 20px;margin-left: 10%;">
            <tr><th>Id</th><th>Username</th><th>Email</th><th>First Name</th><th>Last Name</th><th>Date Of Birth</th><th>Gender</th><th>Profile Status</th><th>Registration Date</th><th>Delete</th></tr>
    
    <c:forEach var="user" items="${list}"> 
    <tr>
    
    <td>${user.id}</td>
    <td>${user.username}</td>
    <td>${user.email}</td>
    <td>${user.fname}</td>
    <td>${user.lname}</td>
    <td>${user.birthdate}</td>
    <td>${user.gender}</td>
    <td>${user.is_active}</td>
    <td>${user.reg_date}</td>
     <td><a href="deleteuser/${user.id}" style="color: chocolate;">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    

       
       
       
       
       
       
       
       
       
        <jsp:include page="footer.jsp"/>
       
      <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

    </body>
</html>

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
