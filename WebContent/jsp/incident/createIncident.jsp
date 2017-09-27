<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<div id="getForm">

			<a href='#' onclick="getAllModules();"> &lt Back</a> <br />
			<br />

			<div class="panel panel-default">
				<div class="panel-heading">Report a Incident :</div>
				<div class="panel-body">

					<form class="form-horizontal" id="myForm"
						onsubmit="return createIncident();">


						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">Name:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="name" id="name">
							</div>
						</div>




						<div class="form-group">
							<label for="mobile" class="col-sm-2 control-label">Mobile
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="mobile" id="mobile">
							</div>
						</div>




						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" name="email" id="email"
									>
							</div>
						</div>




						<div class="form-group">
							<label for="district" class="col-sm-2 control-label">District</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="district" id="district" value="Thanjavur" readonly>
							</div>
						</div>





						<div class="form-group">
							<label for="taluk" class="col-sm-2 control-label">Taluk</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="taluk"
									id="taluk">
							</div>
						</div>




						<div class="form-group">
							<label for="village" class="col-sm-2 control-label">village</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="village" id="village">
							</div>
						</div>



						<div class="form-group">
							<label for="incidentType" class="col-sm-2 control-label">Incident-Type</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="incidentType" id="incidentType" value="101" readonly>
							</div>
						</div>
						



						<div class="form-group">
							<label for="description" class="col-sm-2 control-label">Description</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="description" id="description">
							</div>
						</div>


						<div>
							<div class="pull-right">



								<button type="button" class="btn btn-default"
									onclick="getAllModules();">Cancel</button>
								<button type="submit" class="btn btn-primary">Save</button>

							</div>
						</div>
					</form>


				</div>
			</div>
	</div>

