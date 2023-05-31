
//-----------------------------------------------------------//
// To set AJax commmon settings.
// Especially, Ajax local events lifecycle handlers.
//-----------------------------------------------------------//

$.ajaxSetup({

    async: true,
    cache: true,

    // url: './xml/studentinfo.xml',
    // type: 'GET',
    // dataType: 'XML',
    // timeout: 1000,


    beforeSend: function (XHR) {
        console.log('----------------------------------------')
        console.log('1. beforeSend(XHR) invoked.')
        console.log('----------------------------------------')

        printXHR1(XHR)

    },  // beforeSend


    complete: function (XHR) {
        console.log('----------------------------------------')
        console.log('3. complete(XHR) invoked.')
        console.log('----------------------------------------')

        printXHR1(XHR)

    },  // complete
                    
    
    // error: function (XHR) {
    //     console.log('----------------------------------------')
    //     console.log('2. error(XHR) invoked.')
    //     console.log('----------------------------------------')

        // printXHR1(XHR)

    // } // error

})  // ajaxSetup


function printXHR1(XHR) {
    console.log('+ XHR:', XHR)
    console.log('\t1. readyState:', XHR.readyState)
    console.log('\t2. state:', XHR.state())
    console.log('\t3. status:', XHR.status)
    console.log('\t4. statusText:', XHR.statusText)

} // printXHR