var app = new Vue({
    el: '#app',
    data: {
        blockListDTOS:[],
        transactionListDTOS:[],
        i:true,
        inputs:"",
        activeColor: 'blue',
        fontSize: 40,        
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

        
    },

    

    mounted(){
        this.getBlockListDTOS();
        this.getTransactionListDTOS();
    },

    methods:{

        handleSearch(){
            // axios.get('',{
                
            // })
            // .then(function(response){
            //     console.log(response);
                
            // })
            // .catch(function(error){
            //     console.log(error);
            // })
        },

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
            location.href="TransactionMore.html";
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