var app = new Vue({
    el: '#app',
    data: {
        username:'',
        password:''
    },

    methods:{

        handleLogin(){
            this.userLogin();
        },

        handleRegister(){
            location.href="/UserRegister.html";
        },

        userLogin(){
            axios.get('http://localhost:8080/user/login',{
               params:{
                username:this.username,
                password:this.password,
               }
            })
            .then(function(response){
                console.log(response);
                alert("登录成功!");
                location.href="ChangePwd.html";
            })
            .catch(function(error){
                console.log(error);
                alert("登录失败!");
            })
        }

    }
})