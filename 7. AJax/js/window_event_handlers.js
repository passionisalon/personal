
//-----------------------------------------------------------//
// To set the load / unload event handlers for window
//-----------------------------------------------------------//

$(window).load(function (e) {
    console.debug('>>> onload event for window triggered.')

    console.debug('\t+ e:', e)
})  // onload for window


$(window).unload(function (e) {
    console.debug('>>> onunload event for window triggered.')

    console.debug('\t+ e:', e)
})  // onunload for window