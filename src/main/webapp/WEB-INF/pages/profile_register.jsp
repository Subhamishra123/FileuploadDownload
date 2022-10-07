<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register here</title>
</head>
<body>
<h1 style="color: green; text-align: center;">Marriage Registration Form</h1>
<form:form modelAttribute="profile" enctype="multipart/form-data">
<table border="1" align="center" bgcolor="cyan">
<tr>
<td>
Profile Name ::
</td>
<td>
<form:input path="profileName"/>
</td>
</tr>
<tr>
<td>
Profile Gender ::
</td>
<td>
Male <form:radiobutton path="profileGender" value="Male"/>  
 Female <form:radiobutton path="profileGender" value="Female"/> 
</td>
</tr>
<tr>
<td>
Profile Resume ::
</td>
<td>
<form:input path="resume" type="file"/>
</td>
</tr>
<tr>
<td>
Profile Photo ::
</td>
<td>
<form:input path="photo" type="file"/>
</td>
</tr>
<tr>
<td>
<input type="submit" value="register">
</td>
</tr>
</table>
<h1><a href="./">Home</a></h1>
</form:form>
</body>
</html>