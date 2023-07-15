<template>
    <div class="discount">
        <h4>지금 결제하면 {{discountNumber}}% 할인</h4>
    </div>
</template>
<script>
    export default{
        name:'DiscountC',
        data(){
            return
        },
        props:{
            discountNumber:Object,
        },
    }
</script>
<style>
.discount{
    background:#eee;
    padding: 10px;
    margin:10px;
    border-radius:10px;
  }
</style>