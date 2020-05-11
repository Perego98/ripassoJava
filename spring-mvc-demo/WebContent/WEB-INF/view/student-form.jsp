<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" 
		  href="${pageContext.request.contextPath}/resources/css/my-test.css">
		  
	<title>Student Registration Form</title>
	
</head>

<body>

	<form:form action="processForm" modelAttribute="student" >
	
	First name: <form:input path="firstName" />
	
	<br><br>
	
	Last name: <form:input path="lastName" />
	
	<br><br>
	
	Country:
	
	<form:select path="country">
	
	<!--  Loaded by countries.properties file -->
 	<!--<form:options items="${theCountryOptions}" />-->	

	<!--  Loaded by Student HasLinkedMap -->
	  <form:options items="${student.countryOptions}"/> 
	
	<!--  
		<form:option value="Italy" label="Italy"/>
		<form:option value="France" label="France"/>
		<form:option value="Germany" label="Germany"/>
		<form:option value="India" label="India"/>
		<form:option value="Brazil" label="Brazil"/>
	-->	
	</form:select>
	
	<br><br>
	
		Favorite Language:
	
		 <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  />
	<!--
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		C++ <form:radiobutton path="favoriteLanguage" value="C++"/>
		C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		PHP <form:radiobutton path="favoriteLanguage" value="Php"/>
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
		Assembly <form:radiobutton path="favoriteLanguage" value="Assembly"/>
	-->	
	
	<br><br>
	
		Operating Systems:
		
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />
	
	<br><br>
	
	<input type="submit" value="Submit" />
	
	</form:form>


</body>
</html>