<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Log in</title>
    </head>
    <body>
       <%--<jsp:include page="header.jsp"/>--%>
       <!--<h1>Sign In</h1>-->
       <form:form method="post" action="/CBTeamProject/login" style="display: flex;">  
      	<table>  
         <tr>  
          <td>Username : </td> 
          <td><form:input path="username" pattern="[a-zA-Z0-9]+"/></td>
         </tr>
         <tr>  
          <td>Password : </td> 
          <td><form:input type="password" path="password"  /></td>
         </tr>  
        </table>
        <div style="margin: auto;">
            <input type="submit" class="btn btn-dark" value="Sign In" />
        </div>
<!--          <h5>${error}</h5>-->
       </form:form> 
       
       
    </body>
</html>