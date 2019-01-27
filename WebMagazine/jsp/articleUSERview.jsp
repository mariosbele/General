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
        <script>
            function myFunction1() {
                var x = document.getElementById("lk");
                var y = document.getElementById("la");
                x === y;
              }
        </script>
    </head>
    <body>
  

        <jsp:include page="header.jsp"/>


<!--      <div class="container" style="max-width: -moz-available;margin-bottom: 5px;">
         <section id="articles" class="row pt-4 justify-content-md-center">
        <c:forEach var="img" items="${artimglist}">
            
   <div class="col-97 col-sm-81 col-lg-63 mb-83" style="width: 80%;">
       <div class="card" style="margin-right: -50px;margin-bottom: 0px;width: 100%;">
            <img class="card-img-top" src="${img.article_img}" style="height: 460px;">
            <div class="card-body" style="margin-top: -5%;">
            </div>
        </div>
   </div>
        </c:forEach> 
            
     </section>
    
        </div>    -->

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

                
          
     <p rows = "25" cols = "40" style="width: 80%;margin-left: 10%;border-color: #6c757d;">${article.article}</p>   


    <div style="margin-left: 10%; display: flex;">
    <c:choose>
    <c:when test="${LI=='L'}">     
        <span><jsp:include page="formLIKE.jsp"/></span><div style="display: flex">   ${likes} </div>
        <span><jsp:include page="formDISLIKE.jsp"/></span><div style="display: flex">   ${dislikes}</div>
    </c:when>
 
    <c:otherwise>
        <span><input type="submit"  class="btn btn-dark"  value=" Like  " />   ${likes}  </span>
        <span><input type="submit"  class="btn btn-dark"  value="Dislike" />   ${dislikes}</span>
    </c:otherwise>
</c:choose>
       </div> 
     
     
    <br>
    <br>
    <c:if test="${QU == 'Q'}">
    <jsp:include page="formQUESTION.jsp"/>
    </c:if>    
    <br><br>
    
    <c:if test="${res == 'R'}">
    <jsp:include page="results.jsp"/>
    </c:if>
    
    
    <h3 style="margin-left: 10%;margin-top: 10px;">Comments:</h3>
    <c:forEach var="comm" items="${artcomm}" >
        <div style="border-color: #6c757d;width: 80%;margin-left: 10%;border-style: groove;">
        <h6 style="margin-left: 1%;"><b>${comm.username}</b> at ${comm.sub_date}</h6>
        <h6 style="margin-left: 1%;">${comm.comment}</h6>
        </div>
        <br>
    </c:forEach>
    
        
        
    <form:form method="POST" action="/CBTeamProject/comment">
        <form:hidden  path="id" />
        <form:hidden  path="article_id" value="${article.id}"/>
        <form:hidden  path="reader_id" value="${reader.id}"/>
        <form:hidden  path="question_answer"/>
        <form:hidden  path="sub_date"/>
        <form:hidden  path="is_like" />
        <form:textarea path = "comment" rows = "15" cols="25" placeholder="Add Comment" style="width: 80%;margin-left: 10%;border-color: #6c757d;height: 70px;"/>
        <input type="submit" class="btn btn-dark" style="width: 10%;margin-left: 80%;margin-top: 25px;" value="Submit" />
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








   