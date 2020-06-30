<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Daniele Perego Home Page</title>
</head>

<body>

	<h2>Daniele Perego Home Page - yoohoo!!!</h2>
	<hr>
	<p>
		welcome to DP company HP!
	</p>
	<hr>
	
	<!-- display username and role -->
	<p> 
	
		User: <security:authentication property="principal.username"/>
		
		<br><br>
		
		Role(s): <security:authentication property="principal.authorities"/>
		
	</p>
	
	<hr>
	
	<!-- Add a link to point to /leaders... this is for manager -->
	
	<p>
		<a href="${pageContext.request.contextPath}/leaders"> LeaderShip Meeting</a>
		(only for manager peeps)
	</p>
	
	<hr>
	
	<!-- Add a link to point to /systems... this is for admins -->
	
	<p>
		<a href="${pageContext.request.contextPath}/systems"> IT Systems Meeting</a>
		(only for Admins peeps)
	</p>
	
	<hr>

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="logout"/>
		
	</form:form>

</body>

</html>