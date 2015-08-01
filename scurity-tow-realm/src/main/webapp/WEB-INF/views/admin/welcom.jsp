<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Admin login user : ${user}
</h1>
<a href="/j_spring_security_logout">logout</a>
</body>
</html>
