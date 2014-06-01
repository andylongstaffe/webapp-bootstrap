<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC form handling example</title>
</head>
<body>
<h2>Submitted customer information:</h2>
<table>
<tr>
<td>firstName</td>
<td>${c.firstName}</td>
</tr>
<tr>
<td>lastName</td>
<td>${c.lastName}</td>
</tr>
<tr>
<td>address</td>
<td>${c.address}</td>
</tr>
<tr>
<td>postcode</td>
<td>${c.postcode}</td>
</tr>
<tr>
<td>emailAddress</td>
<td>${c.emailAddress}</td>
</tr>
</table>
</body>
</html>