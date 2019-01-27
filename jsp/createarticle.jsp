<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Article</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    </head>
    <body>
       <jsp:include page="header.jsp"/>
       <h1 style="margin-left: 10%;">Create Article</h1>
        <form:form method="post" action="savearticle" style="display: flex;flex-direction: column;"> 
            <form:input path="title"  required="required" placeholder="Write Title" maxlength="80" style="width: 45%;margin-left: 10%;border-color: #6c757d;"/>
            <form:select path="category" required="required" style="width: 20%;margin-left: 70%;margin-bottom: 20px; margin-top: -25px;border-color: chocolate;">
                <option value="" disabled selected>Choose Category</option>
                <form:option value="SCIENCE">Science</form:option>
                <form:option value="ART">Art</form:option>
                <form:option value="ENVIRONMENT">Environment</form:option>
                <form:option value="TECHNOLOGY">Technology</form:option>
                <form:option value="GENERAL">General</form:option>
            </form:select>
            
            
            <form:textarea path = "article" maxlength="10000" rows = "25" cols = "40" required="required" placeholder="Write Article" style="width: 80%;margin-left: 10%;border-color: #6c757d;" />
            <form:textarea path = "question"  maxlength="400" required="required" placeholder="Write Question" style="width: 80%;margin-left: 10%;margin-top: 25px;border-color: #6c757d;" />
                <input type="submit" class="btn btn-dark" value="Save Article" style="width: 20%;margin-left: 70%;margin-top: 25px;" />
       </form:form>  
                
                
                
                
                
                
                
                
                
                
         <jsp:include page="footer.jsp"/>        
       <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

    </body>
</html>	
      