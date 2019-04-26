var app = new Vue({
    el: '#app',
    data: {
        blockListDTOS:[],
        transactionListDTOS:[],
        i:true,
        inputs:"",
        amountUSD:"",
    },

    computed:{
        showBlockListDTOS(){
            var now = Date.now();
            this.blockListDTOS.forEach(block=>{
                block.showTime = parseInt((now-block.time)/1000/60);
                block.showSizeOnDisk=block.sizeOnDisk.toLocaleString('en');
            })
            return this.blockListDTOS;
        },

        amountUSD:function(){
            return this.transactionListDTOS.amount*5000;
        }
    },

    mounted(){
        this.getBlockListDTOS();
        this.getTransactionListDTOS();
    },

    methods:{

        getBlockListDTOS(){
            axios.get('http://localhost:8080/block/getRecentBlocks')
            .then(function(response){
                console.log(response);
                app.blockListDTOS=response.data;
            })
            .catch(function(error){
                console.log(error);
            })
        },

        getTransactionListDTOS(){
            axios.get('http://localhost:8080/transaction/getTransactions')
            .then(function(response){
                console.log(response);
                app.transactionListDTOS=response.data;
            })
            .catch(function(error){
                console.log(error);
            })
        },

        BlocksMore(){
            location.href="BlocksMore.html";
        },

        TransactionsMore(){

        },

        blocksClick(){
            this.i=true;
        },

        transactionClick(){
            this.i=false;
        },
        
    }
})