<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<div id="getForm">

			<a href='#' onclick="getAllModules();"> &lt Back</a> <br />
			<br />

			<div class="col-md-8 col-md-offset-2 panel panel-default">
				<div class="panel-heading">Report a Incident :</div>
				<div class="panel-body">

					<form class="form-horizontal" id="myForm"
						onsubmit="return createIncident();">


						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">Name*</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="name" id="name" required>
							</div>
						</div>




						<div class="form-group">
							<label for="mobile" class="col-sm-2 control-label">Mobile*
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="mobile" id="mobile" required>
							</div>
						</div>




						<div class="form-group">
							<label for="taluk" class="col-sm-2 control-label" >Taluk*</label>
							<div class="col-sm-10">
								<select class="form-control" name="taluk" id="taluk" required  onclick="showVillage(this.value);">
								<option value="" disabled selected>Select the taluk</option>
							    <option value="01">Thanjavur</option>
							    <option value="02">Thiruvaiyaru</option>
							    <option value="03">Orathanad</option>
							    <option value="04">Thiruvidaimaruthur</option>
							    <option value="05">Kumbakonam</option>
							    <option value="06">Papanasam</option>
							    <option value="07">Pattukottai</option>
							    <option value="08">Peravurani</option>
							    <option value="09">Budalur</option>
						     </select>
							</div>
						</div>



						<div class="form-group">
							<label for="village" class="col-sm-2 control-label">village*</label>
							<div class="col-sm-10">
							<p id="VList">Please select the taluk first</p>
							</div>
						</div>



						<div class="form-group">
							<label for="incidentType" class="col-sm-2 control-label">Incident-Type*</label>
							<div class="col-sm-10">
							<select class="form-control" name="incidentType" id="incidentType" required>
								<option value="" disabled selected>Select the Incident type</option>
							    <option value="101">Tank/Channal Breach</option>
							    <option value="51">Water Lodgging</option>
							    <option value="52">water Inundation</option>
							    <option value="53">Loss of life</option>
							    <option value="54">Hut damage</option>
							    <option value="55">Wall Collapse</option>
							    <option value="56">cattle death</option>
							    <option value="57">Fallen trees</option>
							    <option value="58">Lamp post fallen</option>
							    <option value="59">Electric line cut</option>
							    <option value="60">Fire accident</option>
						     </select>
							</div>
						</div>
						



						<div class="form-group">
							<label for="description" class="col-sm-2 control-label">Description*</label>
							<div class="col-sm-10">
								<textarea rows="5" type="text" class="form-control" name="description" id="description" required></textarea>
							</div>
						</div>


						<div>
							<div class="pull-right">



								<button type="button" class="btn btn-default"
									onclick="getAllModules();">Cancel</button>
								<button type="submit" class="btn btn-primary">Report</button>

							</div>
						</div>
					</form>


				</div>
			</div>
	</div>

