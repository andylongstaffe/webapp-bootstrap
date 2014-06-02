Sample project using spring mvc and boostrap

http://hostname.com/contextPath/servletPath/pathInfo
- how to get the context path
1.
// somewhere on the top of your JSP
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

...
<a href="${contextPath}/admin/listPeople">Go to People List</a>

Also had to add 
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
and
remove DOCTYPE (2.4/3 specific)

TODO
====
1. Use tiles or sitemesh to remove duplication for website navigation etc.
2. Read servlet spec.

test update