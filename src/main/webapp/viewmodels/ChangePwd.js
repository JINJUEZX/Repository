var app = new Vue({
    el: '#app',
    data: {

        oldPassword:'',
        newPassword:'',
        repeatNewPassword:''

    },

    methods:{
        handleReset(){
            location.reload();
        },

        handleChangePwd(){

            if(this.newPassword!==this.repeatNewPassword){
                alert("两次密码不一致!");
                return;
            }

            axios.post('http://localhost:8080/user/changePwd',{
                oldPassword:this.oldPassword,
                newPassword:this.newPassword,
            })
            .then(function(response){
                console.log(response);
                alert("修改成功!");
                location.href="UserLogin.html";
            })
            .catch(function(error){
                console.log(error);
                alert("修改失败!");
            })

        }
    }
})