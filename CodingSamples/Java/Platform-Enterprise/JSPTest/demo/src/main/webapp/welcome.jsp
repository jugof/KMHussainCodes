<jsp:useBean id="now" class="java.util.Date"/>
<html>
	<head>
		<title>demo-web-app</title>
	</head>
	<body>
		<h1>Welcome Visitor ${param.name}</h1>
		<b>Current Time: </b>${now}
	</body>
</html>

