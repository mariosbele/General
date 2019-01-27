

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Unpublished Articles</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <h1 style="margin-left: 10%;">Unpublished Articles</h1>
        
        <table border="2" width="80%" cellpadding="2" style="margin-top: 20px;margin-left: 10%;">
            <tr><th style="width: 10%;">Creator</th><th style="width: 10%;">Category</th><th style="width: 25%;">Title</th><th style="width: 25%;">Question</th><th style="width: 10%;">Submitted</th><th style="width: 1%;">View</th></tr>
   
            <c:forEach var="article" items="${lista}" varStatus="status"> 
         
            <tr>
              
            <a href="openarticle/${article.id}">    
            <td>${unames[status.index]}</td>
            <td>${article.category}</td>
            <td>${article.title}</td>
            <td>${article.question}</td>
            <td>${article.sub_date}</td>
            </a>
            <td><a href="adminOpenUnpublished/${article.id}">view</a></td>
            </tr>
            
           
            </c:forEach>
            </table>
            <br/>
             <jsp:include page="footer.jsp"/>
          <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

        
    </body>
</html>
