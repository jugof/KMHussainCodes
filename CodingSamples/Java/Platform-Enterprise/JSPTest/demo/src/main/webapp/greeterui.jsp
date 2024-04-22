<jsp:useBean id="greeter" class="app.components.GreeterBean" scope="session"/>
<jsp:setProperty name="greeter" property="person" param="visitor"/>
<jsp:setProperty name="greeter" property="period"/>
<html>
	<head>
		<title>demo-web-app</title>
	</head>
	<body>
		<h1>${greeter.greetingMessage}</h1>
        <p>
            <b>Number of Greetings: </b>${greeter.greetCount}
        </p>
        <form method="post">
            <p>
                <b>Person: </b>
                <input type="text" name="visitor"/>
            </p>
            <p>
                <b>Period: </b>
                <select name="period">
                    <option>Night</option>
                    <option>Morning</option>
                    <option>Afternoon</option>
                    <option>Evening</option>
                </select>
            </p>
            <input type="submit" value="Greet"/>
        </form>
	</body>
</html>

