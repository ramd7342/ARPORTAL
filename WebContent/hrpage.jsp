<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Show people</title>
    </head>
    <body>
                    <c:forEach var="per" items="${qData}">
                    	<div id="${per.questionid}">
                    		<div>
                    			<span><c:out value="${per.question}"/></span>
                    		</div>
                    		<div>
                    			<div class="radio">
								  <label><input type="radio" name="optradio_${per.questionid}">${per.answer1}</label>
								</div>
								<div class="radio">
								  <label><input type="radio" name="optradio_${per.questionid}">${per.answer2}</label>
								</div>
								<div class="radio">
								  <label><input type="radio" name="optradio_${per.questionid}">${per.answer3}</label>
								</div>
								<div class="radio">
								  <label><input type="radio" name="optradio_${per.questionid}">${per.answer4}</label>
								</div>
                    		</div>
                    	</div>
                    </c:forEach>
    </body>    
</html>