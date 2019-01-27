<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Question</title>
    </head>
    <body>
        
            <h1 style="width: 80%;margin-left: 10%;margin-top: 10px;">${article.question}</h1>
            <form:form method="POST" action="/CBTeamProject/question" style="margin-left: 10%;">
                <form:hidden  path="id" />
                <form:hidden  path="article_id" value="${article.id}"/>
                <form:hidden  path="reader_id" value="${reader.id}"/>
                <form:radiobutton path="question_answer" value="YES"/>Yes 
                <form:radiobutton path="question_answer" value="NO"/>No
                <form:radiobutton path="question_answer" value="OTHER" checked="checked"/>I don't know
                <form:hidden  path="comment"/>
                <form:hidden  path="sub_date"/>
                <form:hidden  path="is_like"/>
                <input type="submit" class="btn btn-dark" value="Submit" />
            </form:form>
    </body>
</html>
