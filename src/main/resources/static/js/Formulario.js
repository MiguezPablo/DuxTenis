console.log("Ejecutando js");

setInterval(updateEventCount, 500);
setInterval(updateFinished, 1000);

function updateEventCount() {
    $.get("event-count").done(function(fragment) { // get from controller
        $("#eventCount").replaceWith(fragment); // update snippet of page
    });
}

function updateFinished() {
    $.get("finalizado").done(function(fragment) { // get from controller
        $("#finished").replaceWith(fragment); // update snippet of page
    });
}