<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Images</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    </head>
    <body>
       <jsp:include page="header.jsp"/>
       
       <div class="container">
         <section id="articles" class="row pt-4 justify-content-md-center">
        <c:forEach var="img" items="${artimglist}">
            
    <div class="col-12 col-sm-6 col-lg-4 mb-4">
        <div class="card">
            <img class="card-img-top" src="${img.article_img}">
            <div class="card-body">
            <h5 class="card-title">${img.caption}</h5>
            <h6><a href="deleteimage/${img.id}">Delete</a></h6>
            </div>
        </div>
    </div>
        </c:forEach> 
            
     </section>
    
        </div>
       
        <form:form method="post" action="saveimg" style="margin-left: 31%;">  
           
            
            <form:hidden path="article_id" value="${article.id}"/>
            <form:input path = "article_img" required="required" maxlength="1000" placeholder="Image Link"/>
            <form:input path = "caption" pattern="[a-zA-Z0-9]+" placeholder="Image Caption"/>
                              
            
            <input type="submit" class="btn btn-dark" value="Save Image" style="margin-top: -5px;"/>            
       </form:form>  
                
                
            <a href="/CBTeamProject/editarticle/${article.id}" style="color: chocolate;margin-left: 40%;"/>Return to Edit your Article</a>        
                
                
                
                
       <jsp:include page="footer.jsp"/>          
                
                
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
  
    </body>
</html>	
      