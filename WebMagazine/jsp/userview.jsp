    <%@page import="com.cbfteam.beans.User"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<!-- HEAD -->

</head>
   
    <h1>Welcome ${sessionScope.user.getUsername()}!!</h1>
    <h3><a href="fteam">HOME</a></h3>
    <h4><a href="createarticle">Create Article</a></h4>
    <h4><a href="viewsavedarticles">My Saved Articles</a></h4>
    <h4>My Published Articles</h4>
    <h4><a href="edituser/${user.id}">Edit Info</a></h4>
    
    <h4><a href="logout">LOGOUT</a></h4>