<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="getviewForm">

	<a href='#' onclick="getAllModules();"> &lt Back</a> <br /> <br />
<div class="col-md-4 col-md-offset-4">
	<div class="panel panel-default">
		<div class="panel-heading">Enter your reference id:</div>
		<div class="panel-body">

			<form class="form-horizontal" id="myForm"
				onsubmit="return viewIncident();">


				<div class="form-group">
					<label for="name" class="col-sm-5 control-label">Reference Id*</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="userId" id="userId" required>
					</div>
				</div>
					<div class="pull-right">

						<button type="button" class="btn btn-default"
							onclick="getAllModules();">Cancel</button>
						<button type="submit" class="btn btn-primary">Submit</button>

					</div>
			</form>

			</div>
		</div>
	</div>
</div>

