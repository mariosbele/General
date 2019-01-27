<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${article.title}</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
      <div class="container" style="margin-bottom: 5px;width: 100%;margin-left: 10%;">
         <section id="articles" class="row pt-4 justify-content-md-center" style="width: -moz-available;">            
             
                 
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="width: 100%;">
          <div class="carousel-inner" style="width: 100%;">
            <div class="carousel-item active">
              <img  src="${IMG.article_img}" alt="First slide" style="height: 460px;width: 90%;">
              <div class="carousel-caption d-none d-md-block">
<!--                    <h5>${IMG.caption}</h5>-->
                    <!--<p><a href="deleteimage/${IMG.id}">Delete</a></p>-->
                </div>
            </div>
              <c:forEach var="img" items="${artimglist}" begin="1">
            <div class="carousel-item">
                <img src="${img.article_img}" alt="..." style="height: 460px;width: 90%;">
                <div class="carousel-caption d-none d-md-block">
<!--                    <h5>${img.caption}</h5>-->
                    <!--<p><a href="deleteimage/${img.id}">Delete</a></p>-->
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
 
     <h3 style="width: 75%;margin-left: 10%;margin-top: 20px;">${article.title}</h3>
     <h5 style="width: 75%;margin-left: 10%;margin-bottom: 15px;">${creator.username}, ${article.category}, <h9>${article.pub_date}</h9></h5>

                
          
     <p rows = "25" cols = "40" style="width: 80%;margin-left: 10%;border-color: #6c757d;max-width: 1000px;">${article.article}</p>        
            
 <div style="margin-left: 10%; display: flex;">
        <span><input type="submit"  class="btn btn-dark"  value=" Like  " />   ${likes}  </span>
        <span><input type="submit"  class="btn btn-dark"  value="Dislike" />   ${dislikes}</span>
 </div> 
  
    
   <h3 style="margin-left: 10%;margin-top: 10px;">Comments:</h3>
    <c:forEach var="comm" items="${artcomm}" >
        <div style="border-color: #6c757d;width: 80%;margin-left: 10%;border-style: groove;max-width: 1000px;">
        <h6 style="margin-left: 1%;"><b>${comm.username}</b> at ${comm.sub_date}</h6>
        <h6 style="margin-left: 1%;">${comm.comment}</h6>
        </div>
        <br>
    </c:forEach>
    
          <jsp:include page="footer.jsp"/> 
         <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

    </body>
</html>








   