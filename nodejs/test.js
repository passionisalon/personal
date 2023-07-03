console.log("Hello world");

let a = 5;
let b = 3;
let c = a + 5;
console.log('c',c);

const nodemailer = require('nodemailer');
const email = {
    host: "sandbox.smtp.mailtrap.io",
    port: 2525,
    auth: {
      user: "b6b75e425eec8c",
      pass: "********74fb"
    }
};  // end email


const send = async (option) => {
    nodemailer.createTransport(email).sendMail(option,(error,info) =>{
    if(error){
        console.log(error);
    }else{
        console.log(info);
        return info.response;
    }   //  end if-else
    });
};

let email_data = {
    from: 'intelinger@gmail.com',
    to: 'intelinger@gmail.com',
    subject: '테스트 메일입니다.',
    text: 'nodejs 한시간만에 끝내보자.'
}

send(email_data);
