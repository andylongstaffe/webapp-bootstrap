<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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


	<div class="container">
		<form:form method="POST" action="/sample/addCustomer" class="form-horizontal" role="form" >
			<h2>Sample Form</h2>

			<div class="form-group">
				<label for="invoiceNumber" class="control-label col-sm-2">Invoice Number</label> <input type="text" class="col-sm-2" id="invoiceNumber"
					placeholder="Enter invoice number">
			</div>
			<h3>Customer details</h3>
			<div class="form-group">
				<form:label for="firstName" class="control-label col-sm-2" path="firstName">First Name</form:label> 
				<form:input type="text" class="col-sm-4" id="firstName" placeholder="Enter first name" path="firstName"/>
				<form:label for="lastName" class="control-label col-sm-2" path="lastName">Last Name</form:label> 
				<form:input type="text" class="col-sm-4" id="lastName" placeholder="Enter last name" path="lastName"/>
			</div>
		
			<div class="form-group">
				<form:label path="address" for="address" class="control-label col-sm-2">Address</form:label> 
				<form:input type="text" class="col-sm-10" id="address" placeholder="Enter address" path="address"/>
			</div>
		
			<div class="form-group">
				<form:label for="postcode" class="control-label col-sm-2" path="postcode">Postcode</form:label> 
				<form:input type="text" class="col-sm-2" id="postcode" placeholder="Enter postcode" path="postcode"/>
			</div>
			<div class="form-group">
				<form:label for="exampleInputEmail1" class="control-label col-sm-2" path="emailAddress">Email address</form:label> 
				<form:input type="email" class="col-sm-6" id="exampleInputEmail1" placeholder="Enter email" path="emailAddress"/>
			</div>
			<div class="form-group">
				<label for="invoiceDate" class="control-label col-sm-2">Invoice date</label> <input type="datetime" class="col-sm-6" id=invoiceDate
					placeholder="Enter invoice date">
			</div>
			<div class="input-append date" id="dp3" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
				<input class="span2" size="16" type="text" value="12-02-2012"> <span class="add-on"><i class="icon-th"></i></span>
			</div>
			<div class="form-group">
				<div class="checkbox">
					<label class="col-sm-2"> </label> <input type="checkbox"> Online discount
				</div>
			</div>
			<div class="form-group">
				<label for="notes" class="control-label col-sm-2">Notes</label>
				<textarea id="notes" rows="3"></textarea>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary col-sm-1">Submit</button>
			</div>
		</form:form>
	</div>
	
	<div class="container">
    <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
            });
        </script>
    </div>
</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="../res/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>