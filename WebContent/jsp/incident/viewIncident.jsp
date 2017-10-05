<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="viewIncident">


	<a href='#' onclick="getAllModules();"> &lt Back</a> <br />
	<br />

	<div class="panel panel-default">
		<div class="panel-heading">Incident details</div>
		<div class="panel-body">

			<table class="table table-striped">
				<tr>
					<th>Name:</th>
					<td><c:out value="${incident.name}" /></td>
				</tr>
				<tr>
					<th>Mobile:</th>
					<td><c:out value="${incident.mobile}" /></td>
				</tr>
				<tr>
					<th>Description:</th>
					<td><c:out value="${incident.description}" /></td>
				</tr>
				<tr>
					<th>Time:</th>
					<td><c:out value="${incident.date}" /></td>
				</tr>
				<tr>
					<th>Message Notification:</th>
					<td></td>
				</tr>
				<tr>
					<th>Action:</th>
					<td></td>
				</tr>
			</table>
		</div>
	</div>

</div>
