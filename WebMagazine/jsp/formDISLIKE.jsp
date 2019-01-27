<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Like</title>
    </head>
    <body>

        <div>
    <form:form method="POST" action="/CBTeamProject/like">
        <form:hidden  path="id" />
        <form:hidden  path="article_id" value="${article.id}"/>
        <form:hidden  path="reader_id" value="${reader.id}"/>
        <form:hidden  path="question_answer"/>
        <form:hidden  path="comment"/>
        <form:hidden  path="sub_date"/>
        <form:hidden  path="is_like" value="D"/>
        <input type="submit"  class="btn btn-dark" value="Dislike" />
    </form:form>
        </div>
    </body>
</html>

