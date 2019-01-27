

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Express Yourself</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
       <jsp:include page="header.jsp"/>
       <div class="container pt-4">
        <form id="search-form">
            <div class="form-row">
                <div class="col-8 col-sm-10 pr-0">
                    <input id="search" type="search" class="form-control rounded-right-0" placeholder="Search by title">
                </div>
                <div class="col-4 col-sm-2 pl-0">
                    <button type="submit" class="btn btn-primary btn-block rounded-left-0" style="background-color: chocolate;">Search</button>
                </div>
            </div>
        </form>
        <section id="movies" class="row pt-4">
        </section>
    </div>
       
       <% String cat = (String) session.getAttribute("cat"); %>
             
       
       <% if (cat.equals("ALL")){ %>
       <div class="justify-content-md-center">
        <jsp:include page="viewALLpublishedarticles.jsp"/>
       </div>
       <% } else if(cat.equals("science")){ %>        
       <jsp:include page="viewArticlesBySCIENCE.jsp"/>
       <% } else if(cat.equals("environment")){ %>
       <jsp:include page="viewArticlesByENVIRONMENT.jsp"/>
       <% } else if(cat.equals("technology")){ %>
       <jsp:include page="viewArticlesByTECHNOLOGY.jsp"/>
       <% } else if(cat.equals("art")){ %>
       <jsp:include page="viewArticlesByART.jsp"/>
       <% } else if(cat.equals("general")){ %>
       <jsp:include page="viewArticlesByGENERAL.jsp"/>
       <% }  %>       
        
         
       
       <jsp:include page="footer.jsp"/>
       
      <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
    
    </body>
</html>
