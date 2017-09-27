<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${status.statusCode != null}">
	<c:if test="${status.statusCode=='Success'}">
		<div class="alert alert-success alert-dismissable"
			style="text-align: center;">
			<a href="#" class="close" data-dismiss="alert">×</a> <strong><c:out
					value="${status.statusCode}" /></strong>
			<c:out value="${status.statusMsg}" />
		</div>
	</c:if>
	<c:if test="${status.statusCode == 'Problem'}">
		<div class="alert alert-warning alert-dismissable"
			style="text-align: center;">
			<a href="#" class="close" data-dismiss="alert">×</a> <strong><c:out
					value="${status.statusCode}" /></strong>
			<c:out value="${status.statusMsg}" />
		</div>
	</c:if>
</c:if>

<br>