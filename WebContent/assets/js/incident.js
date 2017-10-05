


function getCreateIncidentPage()
{
	console.log("hi create");
	$.ajax({
        url: appContextPath + "/jsp/incident/createIncident.jsp",
        method: "GET",
        success: function (result) 
        {
            // console.log(finalText);
            $("#content").html(result);
        }
    });
}


function createIncident()
{
	console.log("hi loading");
	$.ajax({
        url: appContextPath + "/jsp/incident/loading.html",
        method: "GET",
        success: function (result) 
        {
            // console.log(finalText);
            $("#content").html(result);
        }
    });
	console.log("hi save");
	$.ajax({
        url: appContextPath + "/createIncident",
        type:"POST",
        data:$("#myForm").serialize(),
        success: function (result) 
        {
        	console.log(result);
        	console.log("hi da");
            $("#content").html(result);
        }
    });
	return false;
}

function showVillage(id)
{
	//console.log("hi village"+id);
	if(id==101){
	        $("#villageList").html("" +
	        		"<select name='village' id='village'>" +
	        		"<option value='' disabled selected>Select your village</option>" +
	        		"<option value='101'>vallam</option>"+
	        		"<option value='102'>thirumalaisamuthiram</option>"+
	        		"<option value='103'>thanjavur</option></select>");
	}
	if(id==102){
        $("#villageList").html("" +
        		"<select name='village' id='village'>" +
        		"<option value='' disabled selected>Select your village</option>" +
        		"<option value='104'>222</option>"+
        		"<option value='105'>2222</option>"+
        		"<option value='106'>22222</option></select>");
}
	if(id==103){
        $("#villageList").html("" +
        		"<select name='village' id='village'>" +
        		"<option value='' disabled selected>Select your village</option>" +
        		"<option value='107'>333</option>"+
        		"<option value='108'>3333</option>"+
        		"<option value='109'>33333</option></select>");
}
	if(id==104){
        $("#villageList").html("" +
        		"<select name='village' id='village'>" +
        		"<option value='' disabled selected>Select your village</option>" +
        		"<option value='110'>444</option>"+
        		"<option value='111'>4444</option>"+
        		"<option value='112'>44444</option></select>");
}
	if(id==105){
        $("#villageList").html("" +
        		"<select name='village' id='village'>" +
        		"<option value='' disabled selected>Select your village</option>" +
        		"<option value='113'>555</option>"+
        		"<option value='114'>5555</option>"+
        		"<option value='115'>55555</option></select>");
}
	if(id==106){
        $("#villageList").html("" +
        		"<select name='village' id='village'>" +
        		"<option value='' disabled selected>Select your village</option>" +
        		"<option value='116'>666</option>"+
        		"<option value='117'>6666</option>"+
        		"<option value='118'>66666</option></select>");
}
	if(id==107){
        $("#villageList").html("" +
        		"<select name='village' id='village'>" +
        		"<option value='' disabled selected>Select your village</option>" +
        		"<option value='119'>777</option>"+
        		"<option value='120'>7777</option>"+
        		"<option value='121'>77777</option></select>");
}
	if(id==108){
        $("#villageList").html("" +
        		"<select name='village' id='village'>" +
        		"<option value='' disabled selected>Select your village</option>" +
        		"<option value='122'>888</option>"+
        		"<option value='123'>8888</option>"+
        		"<option value='124'>88888</option></select>");
}
}

function getViewIncidentPage(regno)
{
	// console.log("hi view");
	$.ajax({
        url: appContextPath + "/viewStudent?regno="+regno,
        method: "GET",
        success: function (result) 
        {
            var htmlFiltered = $(result).filter("#viewStudent");
            // console.log(htmlFiltered);
            var finalText = htmlFiltered.html();
            // console.log(finalText);
            // console.log("final");
            $("#content").html(finalText);
        }
    });
}

function getViewIncidentPage()
{
	console.log("hi view");
	$.ajax({
        url: appContextPath + "/jsp/incident/viewForm.jsp",
        method: "GET",
        success: function (result) 
        {
            // console.log(finalText);
            $("#content").html(result);
        }
    });
}


function viewIncident()
{
	console.log("hi loading");
	$.ajax({
        url: appContextPath + "/jsp/incident/loading.html",
        method: "GET",
        success: function (result) 
        {
            // console.log(finalText);
            $("#content").html(result);
        }
    });
	console.log("hi save");
	$.ajax({
		url: appContextPath + "/viewIncident",
        type:"POST",
        data:$("#myForm").serialize(),
        success: function (result) 
        {
        	console.log(result);
            $("#content").html(result);
        }
    });
	return false;
}


