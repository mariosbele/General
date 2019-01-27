<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Article</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    </head>
    <body>
       <jsp:include page="header.jsp"/>
       
       
        <h1 style="margin-left: 10%;">Edit Article</h1>   
       
       <form:form method="POST" action="/CBTeamProject/submitsavedarticle" style="display: flex;flex-direction: column;">  
         
         <form:hidden  path="id" />
         <form:hidden  path="creator_id" />
         <form:input path="title" required="required"  maxlength="80" style="width: 45%;margin-left: 10%;border-color: #6c757d;"/>
          <form:select path="category" required="required" style="width: 20%;margin-left: 70%;margin-bottom: 20px; margin-top: -25px;border-color: chocolate;">
                <form:option value="SCIENCE">Science</form:option>
                <form:option value="ART">Art</form:option>
                <form:option value="ENVIRONMENT">Environment</form:option>
                <form:option value="TECHNOLOGY">Technology</form:option>
                <form:option value="GENERAL">General</form:option>
            </form:select>

                
          
            <form:textarea path = "article" maxlength="10000" rows = "25" cols = "40" required="required" style="width: 80%;margin-left: 10%;border-color: #6c757d;"/>
           
            <div class="forflex" style="display: flex;">        
            <div style="margin-top: 15px;margin-left: 10%;width: 20%;">
             
             <a href="/CBTeamProject/addimg" style="color: chocolate;">ADD IMAGE</a> 
          </div>
            <div class="container">
         <section id="articles" class="row pt-4 justify-content-md-center">            
             
                   
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="width: 90%;">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img  src="${IMG.article_img}" alt="First slide" style="height: 460px;width: 90%;">
              <div class="carousel-caption d-none d-md-block">
<!--                    <h5>${IMG.caption}</h5>-->
                    <p><a href="deleteimage/${IMG.id}">Delete</a></p>
                </div>
            </div>
              <c:forEach var="img" items="${artimglist}" begin="1">
            <div class="carousel-item">
                <img src="${img.article_img}" alt="..." style="height: 460px;width: 90%;">
                <div class="carousel-caption d-none d-md-block">
<!--                    <h5>${img.caption}</h5>-->
                    <p><a href="deleteimage/${img.id}">Delete</a></p>
                </div>
            </div>  
             </c:forEach> 
 

          </div>
          <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next" style="margin-right: 10%;">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
             
             
         </section>          
</div>
        </div>
            <form:textarea path = "question" required="required" style="width: 80%;margin-left: 10%;margin-top: 10px;border-color: #6c757d;"/>
            
            
          <input type="submit" class="btn btn-dark" value="Submit" style="width: 80%;margin-left: 10%;margin-top: 15px;"/> 
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
 












	
