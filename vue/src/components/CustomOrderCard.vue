<template>
    <div class="custom-order-card">
        <h2 v-if="!fromOrderCard">Custom Order Information</h2>
        <p class="custom-cake-flavor">Cake Flavor: {{ cake.cakeFlavor }}</p>
        <p class="custom-cake-frosting">Cake Frosting: {{ cake.cakeFrosting }}</p>
        <p class="custom-cake-filling">Cake Filling: {{ cake.cakeFilling }}</p>
        <p class="custom-cake-style">Style: {{ cake.cakeStyle }} </p>
        <p class="custom-cake-size">Size: {{ cake.cakeSize }} </p>
        <p v-if="!fromOrderCard" class="custom-cake-price">Price: $ {{ cake.cakePrice }}</p>
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
        height: 250px;
        margin: 20px;
        padding: 20px;
        border-radius: 10px;
}

</style>