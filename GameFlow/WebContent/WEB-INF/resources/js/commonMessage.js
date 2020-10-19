/**
 * 
 */

<!--- csrf token validation start-->
function getToken() {
    var formURL = "./getTokenAdmin";
    var myToken = "";
    $.ajax({
        url: formURL,
        type: "POST",
        async:false,
        success: function(data) {
            console.log("data::::Token:>>" + data)
            if (data != null && data != "") {
                var ack = JSON.parse(data);
                console.log(ack);
                if (ack.errorMsg !="") {
                    myToken = ack.errorMsg;
                   $('#TOKEN').val(ack.errorMsg);
                }
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log('Failuer::>' + JSON.stringify(textStatus) + "---:>" + JSON.stringify(jqXHR) + ' ::errorThrown:>' + JSON.stringify(errorThrown));
            alert('Failuer::>' + JSON.stringify(textStatus) + "---:>" + JSON.stringify(jqXHR) + ' ::errorThrown:>' + JSON.stringify(errorThrown));
        }
    });

    return myToken;
}

$(function() {
    $(document).ajaxSend(function(e, xhr, options) {
        if (options.url !== "./getTokenAdmin") {
            console.log("inside Ajax Send" + options.url);
            var token = getToken();
            console.log("Token in ajaxSend:::::::"+token);
            var header = "TOKEN";
            xhr.setRequestHeader(header, token);
        }
    });
});



$(document).ready(function() {
$(document).ajaxError(function(event, jqxhr, settings, thrownError) {
    console.log('Failuer::BaseTraif:>>'+ JSON.stringify(thrownError) + "::>>jqXHR::>>"+ JSON.stringify(jqxhr));
    if(jqxhr.status=401) {
        window.location.href="${pageContext.request.contextPath}/permissionError";
    }
    if(jqxhr.status=403) {
        window.location.href="${pageContext.request.contextPath}/generalError";
    }
});
});