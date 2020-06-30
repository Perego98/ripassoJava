<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="logout"/>
		
	</form:form>

</body>

</html>