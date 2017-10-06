


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

function showVillage(talukid)
{
	console.log("hi village"+talukid);
	$.ajax({
        url: appContextPath + "/getVillageList?id="+talukid,
        method: "GET",
        success: function (result) 
        {
            var htmlFiltered = $(result).filter("#villages");
            // console.log(htmlFiltered);
            var finalText = htmlFiltered.html();
             console.log(finalText);
            // console.log("final");
            $("#VList").html(finalText);
        }
    });
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


