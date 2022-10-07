<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table  bgcolor="yellow">
<tr>
<th>Profile Id</th><th>Profile Name</th><th>Profile Gender</th><th>Resume Path</th><th>Photo Path</th>
</tr>
<c:choose>
<c:when test="${!empty profilesList}">
<c:forEach var="profile" items="${profilesList}">
<tr bgcolor="pink">
<td>
${profile.profileId}
</td>
<td>
${profile.profileName}
</td>
<td>
${profile.profileGender}
</td>
<td>
<a href="download?fileName=${profile.resumePath}">${fn:substringAfter(profile.resumePath, 'D:download/')}</a>
</td>
<td>
<a href="download?fileName=${profile.photoPath}">${fn:substringAfter(profile.photoPath, 'D:download/')}</a>
</td>
</tr>
</c:forEach>
</c:when>
</c:choose>
</table>
<a href="./">Home</a>
</body>
</html>