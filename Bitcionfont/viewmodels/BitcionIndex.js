var app = new Vue({
    el: '#app',
    data: {
        blockListDTOS:[]
    },

    computed:{
        showBlockListDTOS(){
            var now = Date.now();
            this.blockListDTOS.forEach(block=>{
                block.showTime = parseInt((now-block.time)/1000/60);
                block.showSizeOnDisk=block.sizeOnDisk.toLocaleString('en');
            })
            return this.blockListDTOS;
        }
    },

    mounted(){
        this.getBlockListDTOS();
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
        
    }
})