
//-----------------------------------------------------------//
// To set AJax global event lifecycle handlers for document
//-----------------------------------------------------------//

$(document).ajaxStart(function (e) {
    console.debug('*****************************************************************************')
    console.debug('* (1) ajaxStart() invoked. [Ajax global event lifecyle]')
    console.debug('*****************************************************************************')

    console.debug('\t+ e:', e)

})  // ajaxStart for document


$(document).ajaxSend(function (e, XHR, settings) {
    console.debug('*****************************************************************************')
    console.debug('* (2) ajaxSend(e, XHR, settings) invoked. [Ajax global event lifecyle]')
    console.debug('*****************************************************************************')

    console.debug('\t+ e:', e)
    console.debug('\t+ settings:', settings)
    
    printXHR2(XHR)
    
})  // ajaxSend for document


$(document).ajaxSuccess(function (e, XHR, settings) {
    console.debug('*****************************************************************************')
    console.debug('* (3) ajaxSuccess(e, XHR, settings) invoked. [Ajax global event lifecyle]')
    console.debug('*****************************************************************************')

    console.debug('\t+ e:', e)
    console.debug('\t+ settings:', settings)
    
    printXHR2(XHR)
    
})  // ajaxSuccess for document


$(document).ajaxError(function (e, XHR, settings, error) {
    console.debug('*****************************************************************************')
    console.debug('* (3) ajaxError(e, XHR, settings, error) invoked. [Ajax global event lifecyle]')
    console.debug('*****************************************************************************')

    console.debug('\t+ e:', e)
    console.debug('\t+ settings:', settings)
    console.debug('\t+ error:', error)
    
    printXHR2(XHR)
    
})  // ajaxError for document


$(document).ajaxComplete(function (e, XHR, settings) {
    console.debug('*****************************************************************************')
    console.debug('* (4) ajaxComplete(e, XHR, settings) invoked. [Ajax global event lifecyle]')
    console.debug('*****************************************************************************')

    console.debug('\t+ e:', e)
    console.debug('\t+ settings:', settings)

    printXHR2(XHR)
    
})  // ajaxComplete for docuemnt


$(document).ajaxStop(function (e) {
    console.debug('*****************************************************************************')
    console.debug('* (5) ajaxStop(e) invoked. [Ajax global event lifecyle]')
    console.debug('*****************************************************************************')

    console.debug('\t+ e:', e)
    
})  // ajaxStop for document


function printXHR2(XHR) {
    console.debug('\t+ XHR:', XHR)
    console.debug('\t\t1. readyState:', XHR.readyState)
    console.debug('\t\t2. state:', XHR.state())
    console.debug('\t\t3. status:', XHR.status)
    console.debug('\t\t4. statusText:', XHR.statusText)

} // printXHR