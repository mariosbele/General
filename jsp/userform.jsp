<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=PT+Serif" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up!</title>
    </head>
    <body>
    <h3>${sessionScope.error3}</h3>
    <form:form method="post" action="/CBTeamProject/save"> 

     <table>  
      <tr>  
       <td>Username : </td> 
       <td><form:input path="username" pattern="[a-zA-Z0-9]+" maxlength="25" required="required" /></td>
      </tr>
      <tr>  
       <td>Password : </td> 
       <td><form:input type="password" path="password" maxlength="25"  required="required"/></td>
      </tr>  
      <tr>  
       <td>Email : </td> 
       <td><form:input type="email" path="email" maxlength="50"  required="required"/></td>
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
             <form:radiobutton path="gender" value="Other"/>Other</td>
      </tr>   
     </table>
      <div style="margin-top: 10px;margin-left: 105px;">
            <input type="submit" class="btn btn-dark" value="Register" />
        </div>
    </form:form>  
    </body>
</html>