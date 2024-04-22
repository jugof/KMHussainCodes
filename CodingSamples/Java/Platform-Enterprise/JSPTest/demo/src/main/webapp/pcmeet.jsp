<%@taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:useBean id="greeter" class="app.components.GreeterBean" scope="request"/>
<html>
	<head>
		<title>demo-web-app</title>
	</head>
	<body>
		<h1>${greeter.greetingMessage}</h1>
		<h3>Meeting Partcipants</h3>
		<ul>
			<c:forEach var="visitor" items="${greeter.people}">
				<li>${visitor}</li>
			</c:forEach>
		</ul>
	</body>
</html>

