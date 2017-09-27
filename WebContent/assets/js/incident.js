


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
	console.log("hi save");
	$.ajax({
        url: appContextPath + "/createIncident",
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



