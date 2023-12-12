<template>
    <div class="custom-order-card">
        <h2>Custom Order Information</h2>
        <p class="custom-cake-flavor">Cake Flavor: </p>
        <p class="custom-cake-frosting">Cake Frosting: </p>
        <p class="custom-cake-filling">Cake Filling: </p>
        <p class="custom-cake-style">Style: </p>
        <p class="custom-cake-size">Size: </p>
        <p class="custom-cake-price">Price: $50</p>
    </div>
</template>

<script>
import CustomOrderService from '../services/CustomOrderService';

    export default {
        data(){
            return;
        },
        methods: {
       
        },
        computed: {

        }
    }
    

</script>

<style>
    .custom-order-card {
        text-align: center;
        width: 300px;
        height: 420px;
        margin: 20px;
        padding: 20px;
        border-radius: 10px;
}

</style>