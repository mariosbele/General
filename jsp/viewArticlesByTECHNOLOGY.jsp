<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
    <head>
       <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Technology Articles</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
        <script js>
            $('#search').keyup(function (){
            $('.card').removeClass('d-none');
            var filter = $(this).val(); // get the value of the input, which we filter on
            $('.card-deck').find('.card .card-body .ol:not(:contains("'+filter+'"))').parent().parent().addClass('d-none');
        });
        </script>
    </head>
    <body>
       
       
        <div class="container">
         <section id="articles" class="row pt-4 justify-content-md-center">
             
        <c:forEach var="articlecard" items="${lista}"> 
            
   
                
                <div class="col-12 col-sm-6 col-lg-4 mb-4">
                    <div class="card-deck">
                    <div class="card">
                        <img class="card-img-top" src="${articlecard.article_img}" alt="${articlecard.category}" style="height:235px;">
                        <div class="card-body" style="background-color: #6c757d;color: whitesmoke;height: 235px;">
                            <h4 <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet" style="margin-top: -10px;font-family: 'Pacifico',cursive;"  class="card-title">${articlecard.category}</h4>
                            <h4 class="ol card-title" maxlength="60" style="margin-top: -10px;">${articlecard.title}</h4>
                            <h5 class="card-subtitle" style="color: #343a40;margin-top: -10px;">${articlecard.username}, ${articlecard.pub_date}</h5>        
                            
                        
                        </div>
                                                        <a href="openarticle/${articlecard.id}" style="margin-top: -38px;background-color: chocolate;" class="btn btn-primary btn-block">View Article</a>

                    </div>
                    </div>     
                </div>
        
   
        
        
        
        
        
        </c:forEach>
        </section>
    
        </div>
    
    
    
    
    
    
    
    
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

        </body>
</html>	
    
