<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ attribute name="id" required="true" rtexprvalue="true" %>
<%@ attribute name="label" required="true" rtexprvalue="true" %>
<%@ attribute name="placeholder" required="true" rtexprvalue="true" %>
<%@ attribute name="size" required="true" rtexprvalue="true" %>
	<div class="form-group">
	<form:label for="${id}" class="control-label col-sm-2" path="${id}">${label}</form:label>
		<div class="col-sm-${size}">
			<form:input type="text" class="form-control" id="${id}" placeholder="${placeholder}" path="${id}"/>
		</div>
		<form:errors path="${id}" class="control-label"/>
	</div>