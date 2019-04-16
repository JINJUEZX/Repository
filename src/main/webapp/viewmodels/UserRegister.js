var app = new Vue({
    el: '#app',
    data: {
        username:'',
        password:'',
        repeatPassword:'',
    },

    methods:{

        handleRegister(){
            //判断两次密码是否一致
            if(this.password!==this.repeatPassword){
                alert("两次密码不一致!");
                return;
            }

            this.registerUser();
        },

        registerUser(){
            axios.post('http://localhost:8080/user/register',{
                username:this.username,
                password:this.password,
            })
            .then(function(response){
                alert("注册成功!");
                console.log(response);
            })
            .catch(function(error){
                alert("注册失败!");
                console.log(error);
            })
        }

    }
})