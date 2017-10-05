<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="confrimPage">
	<h3 Style="text-align: center;">Incident Report Details</h3>
	<a href='#' onclick="getAllModules();"> &lt Home</a> <br /> <br />
	<c:if test="${status.statusCode != null}">
		<c:if test="${status.statusCode=='Success'}">
			<div class="alert alert-success"
				style="text-align: center;">
				 <strong><c:out
						value="${status.statusCode}" /></strong>
				<p>
					<c:out value="${status.statusMsg}" />
				</p>
				<p>
					your reference id:<b><c:out value="${status.userId}" /></b>
				</p>
			</div>
		</c:if>
		<c:if test="${status.statusCode == 'Problem'}">
			<div class="alert alert-warning"
				style="text-align: center;">
				<strong><c:out value="${status.statusCode}" /></strong>
				<p>
					<c:out value="${status.statusMsg}" />
				</p>
				<a href='#' onclick="getCreateIncidentPage();">
				Try again</a> 
			</div>
		</c:if>
	</c:if>

</div>