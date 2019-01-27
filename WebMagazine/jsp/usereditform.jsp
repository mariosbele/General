<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    </head>
    <body>
       <jsp:include page="header.jsp"/>
       <div class="container justify-content-md-center">
           <h1>Edit User</h1>
                <h3>${errorUsername}</h3>
       <form:form method="POST" action="/CBTeamProject/editsave"> 
           
          <table >  
          <tr>
          <td></td>  
         <td><form:hidden  path="id" /></td>
          
          
          
          <td><form:hidden path="username" pattern="[a-zA-Z0-9]+" required="required"/></td>
         
         
         <tr>  
          <td>Password : </td> 
          <td><form:input type="password" maxlength="25" path="password" required="required" /></td>
         </tr>  
         <tr>  
          <td>Email : </td> 
          <td><form:input type="email" path="email" maxlength="50" required="required"  /></td>
         </tr>  
         <tr>  
          <td>First Name : </td> 
          <td><form:input path="fname" maxlength="45" required="required" /></td>
         </tr>  
         <tr>  
          <td>Last Name : </td> 
          <td><form:input path="lname" maxlength="45" required="required" /></td>
         </tr>
        <tr>
             <td>Date of birth : </td>
             <td><form:input type="date" pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                      path="birthdate" max="2005-01-01" value="2005-01-01" required="required"  /></td>
         </tr>
         <tr>  
          <td>Gender : </td> 
          <td><form:radiobutton path="gender" value="Male"/>Male 
                <form:radiobutton path="gender" value="Female"/>Female
                <form:radiobutton path="gender" value="Other"/>Other
          </td>
         </tr>  
         <tr>  
          <td>Profile Status : </td> 
          <td><form:radiobutton path="is_active" value="Active"/>Active
              <form:radiobutton path="is_active" value="Inactive"/>Inactive</td> 
         </tr>         
       <td><form:hidden  path="reg_date" /></td>
         
         <tr>  
          <td> </td>  
          <td><input type="submit" class="btn btn-dark" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
 
       
       </div>
        <jsp:include page="footer.jsp"/>
       <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
    <script src="main.js"></script> 
    </body>
</html>