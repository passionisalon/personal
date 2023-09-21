import axios from "axios";

export const signInApi = async (data: any) => {

    const responseData = await axios.post("http://localhost:4000/aou/auth/signIn",data).catch((err)=>{
})

    await axios
    .post("http://localhost:4000/api/auth/signIn", data)
    .then((response) => {
        console.log("response : ", response.data);
        const responseData = response.data;
        console.log("checkResult : ", responseData.result);
        if (!responseData.result) {
            console.log('로그인에 실패했습니다.');
            return;
        }
        const { token, exprTime, user } = responseData.data;
        const expires = new Date();
        expires.setMilliseconds(expires.getMilliseconds() + exprTime);

        setCookies('token', token, { expires });
        // alert("cookies.token : "+cookies.token);
        setUser(user);
    })
    .catch((error) => {
        alert('로그인에 실패했습니다.');
        console.log(error);
        console.log("로그인에 실패했습니다.!!!!");
    });
}