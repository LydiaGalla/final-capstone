<template>
    <div class="custom-order-card">
        <h2 v-if="!fromOrderCard">Custom Order Information</h2>
        <p class="custom-cake-flavor"><span class="bold">Cake Flavor:</span> {{ cake.cakeFlavor }}</p>
        <p class="custom-cake-frosting"><span  class="bold">Cake Frosting:</span> {{ cake.cakeFrosting }}</p>
        <p class="custom-cake-filling"><span class="bold">Cake Filling:</span> {{ cake.cakeFilling }}</p>
        <p class="custom-cake-style"><span class="bold">Style: </span>{{ cake.cakeStyle }} </p>
        <p class="custom-cake-size"><span class="bold">Size:</span> {{ cake.cakeSize }} </p>
        <p v-if="!fromOrderCard" class="custom-cake-price"><span class="bold">Price: $</span> {{ cake.cakePrice }}</p>
    </div>
</template>

<script>
import CustomOrderService from '../services/CustomOrderService';

    export default {
        props: {
            fromOrderCard: Boolean,
            cake: Object,
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
        background-color: white;
        width: 300px;
        /* height: 250px; */
        /* margin: 20px;
        padding: 20px; */
        border-radius: 10px;
}
.bold {
    font-weight: 600;
}

</style>