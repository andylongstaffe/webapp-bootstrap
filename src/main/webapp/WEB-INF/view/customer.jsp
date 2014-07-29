<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="html" uri="http://hollywood.com/fast/tags/html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="resources/images/favicon.ico">

<title>Input Form demo</title>

<!-- Bootstrap core CSS -->
<link href="${contextPath}/res/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../res/css/starter-template.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">FAST</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="/index.jsp">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<script type="text/javascript">
		var formJsonUrl = "<spring:url value="/sample/customer.json"/>";
	</script>

	<div class="container">
		<form:form method="POST" modelAttribute="customer" action="/sample/addCustomer" class="form-horizontal errorsForm" role="form" id="addCustomer">
			<h2>Sample Form</h2>

			<fieldset>

				<div class="panel panel-default">
					<div class="panel-heading">Customer details</div>
					<div class="panel-body">

						<html:inputField id="firstName" label="First Name" placeholder="Enter first name" size="4" />
						<html:inputField id="lastName" label="Last Name" placeholder="Enter last name" size="4" />
						<html:inputField id="emailAddress" label="Email Address" placeholder="Enter email address" size="4" />
						<html:inputField id="address" label="Address" placeholder="Enter address" size="4" />
						<html:inputField id="postcode" label="Postcode" placeholder="Enter postcode" size="4" />

					</div>
				</div>

				<div class="form-actions">
					<button type="submit" class="btn btn-primary">Save changes</button>
					<button type="reset" class="btn">Cancel</button>
				</div>
			</fieldset>
		</form:form>
	</div>

	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="../res/bootstrap/js/bootstrap.min.js"></script>
	<script src="../res/js/fastforms.js"></script>

</body>
</html>