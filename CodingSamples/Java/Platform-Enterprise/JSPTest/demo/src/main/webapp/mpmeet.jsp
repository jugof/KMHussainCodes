<jsp:useBean id="greeter" class="app.components.GreeterBean" scope="request"/>
<html>
	<head>
		<title>demo-web-app</title>
	</head>
	<body style="background-color: black;color: white;">
		<h1>${greeter.greetingMessage}</h1>
		<b>Number of Particpants: </b>${greeter.people.size()}
	</body>
</html>

