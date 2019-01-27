

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--<head><meta charset="utf-8" />-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--<title>Netflix</title>-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
<!--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">-->
     <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet"> 
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Express yourself</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-secondary" style="margin-block-end: 5px;margin-bottom: -20px;margin-top: -15px;">
        <a class="navbar-brand" href="/CBTeamProject/HomePage" <h1 <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet" style="font-family: 'Pacifico',cursive;font-size: 55px;margin-bottom: 20px;"> Express yourself</h1></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav" style="justify-content: flex-end">              
                 <%
                 
                String username= (String) session.getAttribute("username"); 
                if (username == null) {
            %>

            <div class="navbar-nav" style="background-color: chocolate;">
                <button type="button" class="btn btn-info btn-sm btn-link"  style="color:whitesmoke"   data-toggle="modal" data-target="#myModalLogin">Login</button>
                <button type="button" class="btn btn-info btn-sm btn-link" style="color:whitesmoke"    data-toggle="modal" data-target="#myModalRegister">Register</button>
               
                <!--MODAL FOR LOGIN-->
                <div class="modal fade" id="myModalLogin" role="dialog">
                <div class="modal-dialog">

                  <!-- Modal content-->
                  <div class="modal-content" style="width: -moz-fit-content;">
                    <div class="modal-header" style="flex-direction: row-reverse;background-color: #6c757d;color: aliceblue;">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h2 class="modal-title" <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet" style="font-family: 'Pacifico',cursive;"> Ready to Express yourself? </h2>
                    </div>
                    <div class="modal-body">

                      <%--<jsp:include page="${pageContext.request.contextPath }/loginuser.jsp"/>--%>
                       <jsp:include page="loginuser.jsp"/>
                    </div>
<!--                    <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                      
                    </div>-->
                  </div> 
                </div>
                </div>
                    
                    
                    
                    <!--MODAL FOR REGISTER-->
                <div class="modal fade" id="myModalRegister" role="dialog">
                <div class="modal-dialog">

                  <!-- Modal content-->
                  <div class="modal-content" style="width: -moz-fit-content;">
                    <div class="modal-header" style="flex-direction: row-reverse;background-color: #6c757d;color: aliceblue;">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h2 class="modal-title" <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet" style="font-family: 'Pacifico',cursive;">Complete the form!</h2>
                    </div>
                    <div class="modal-body">

                      <jsp:include page="userform.jsp"/>
                    </div>
                  </div> 
                </div>
                </div>
                
                <!--<a class="nav-item nav-link"  href="loginuser">Login</a>-->
                <!--<a class="nav-item nav-link" href="/FteamProject/userform">Register</a>-->
            </div>
            
            <%     
           }  else if (username == "ADMIN") {
                
         %>  
            <a style="color: #212529;">Hi, <%=username %></a>
           <div class="navbar-nav">
                <a class="nav-item nav-link" href="/CBTeamProject/viewusers">View Users</a>
                <a class="nav-item nav-link" href="/CBTeamProject/viewunpublishedarticles">View Unpublished Articles</a>
                <a class="nav-item nav-link" href="/CBTeamProject/logout">Logout</a> 
           </div>
           
          <% } else {
         %> 
            <a style="color: #212529;">Hi, <%=username %></a>
            <div class="navbar-nav">
                
                <a class="nav-item nav-link" href="/CBTeamProject/createarticle">Create Article</a>
                <a class="nav-item nav-link" href="/CBTeamProject/viewsavedarticles">Saved Articles</a>
                <a class="nav-item nav-link" href="/CBTeamProject/mypublishedarticles">My Published Articles</a>
                <a class="nav-item nav-link" href="/CBTeamProject//usereditform/${user.id}">My Profile</a>
                <a class="nav-item nav-link" href="/CBTeamProject/logout">Logout</a>
            </div>
        <% }%>
        
            <div class="navbar-nav">
                <td style="color : red">${error}</td>
<!--                <td style="color : white" style="background-color: green">Hi, <%=username %></td>-->
                
            </div>
        
         
        </div>
    </nav>
                
<!--        <h1 <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet" style="font-family: 'Pacifico',cursive;font-size: 55px;margin-bottom: 20px;"> Express yourself</h1>-->
         
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<!--        <a class="navbar-brand" href="/SpringMVCPagination/HomePage">Home</a>-->
<!--        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>-->
        <div class="collapse navbar-collapse" id="navbarNav" style="margin: -5px;">
<!--            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/aboutus.jsp">About <span class="sr-only">(current)</span></a>
                </li>
              </ul>  -->
            
<div class="navbar-nav mr-auto" style="margin-inline-start: auto">
                <a class="navbar-brand" href="/CBTeamProject/HomePage" style="padding: 3px;">Home</a>
                <a class="nav-item nav-link" href="/CBTeamProject/viewArticlesBySCIENCE">Science</a>
                <a class="nav-item nav-link" href="/CBTeamProject/viewArticlesByTECHNOLOGY">Technology</a>
                <a class="nav-item nav-link" href="/CBTeamProject/viewArticlesByART">Art</a>
                <a class="nav-item nav-link" href="/CBTeamProject/viewArticlesByENVIRONMENT">Environment</a>
                <a class="nav-item nav-link" href="/CBTeamProject/viewArticlesByGENERAL">General</a>
                <a class="nav-link" href="/CBTeamProject/aboutus">About <span class="sr-only">(current)</span></a>
            </div>
  
<!--            <div class="navbar-nav">
                <td style="color : red">${error}</td>
                <td style="color : white" style="background-color: green">Hi, <%=username %></td>
                
            </div>-->
        
         
        </div>
                
<!--                 <div class="navbar-nav mr-auto">
                
                <a class="nav-item nav-link" href="science">Science</a>
                <a class="nav-item nav-link" href="technology">Technology</a>
                <a class="nav-item nav-link" href="Art">Art</a>
                <a class="nav-item nav-link" href="Enviroment">Enviroment</a>
            </div>-->
    </nav>
    




        
    </body>
</html>
