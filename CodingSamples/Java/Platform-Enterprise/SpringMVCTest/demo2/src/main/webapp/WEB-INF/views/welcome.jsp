<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title>demo-web-app</title>
	</head>
	<body>
		<h1>Our Visitors</h1>
		<table border="1">
			<tr>
				<th>Given Name</th>
				<th>Visit Count</th>
				<th>Last Visit</th>
				<th>Star Rating</th>
			</tr>
			<c:forEach var="person" items="${people}">
				<tr>
					<td>${person.givenName()}</td>
					<td>${person.visitCount()}</td>
					<td>${person.lastVisit()}</td>
					<td>${person.starRating()}</td>
				</tr>
			</c:forEach>
		</table>
		<hr/>
		<s:form method="post" action="register" modelAttribute="guest">
			<p>
				<b>Your Name:</b>
				<s:input path="name" required="required"/>
			</p>
			<p>
				<b>Experience:</b>
				<s:select path="rating">
					<option value="5">Fantastic</option>
					<option value="4">Good</option>
					<option value="3">Average</option>
					<option value="2">Poor</option>
					<option value="1">Pathetic</option>
				</s:select>
			</p>
			<input type="submit" value="Register"/>
		</s:form>
	</body>
</html>

