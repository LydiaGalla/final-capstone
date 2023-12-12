<template>
    <div class="custom-order-card">
        <h2>Custom Order Information</h2>
        <p class="custom-cake-flavor">Cake Flavor: {{ cake.cakeFlavor }}</p>
        <p class="custom-cake-frosting">Cake Frosting: {{ cake.cakeFrosting }}</p>
        <p class="custom-cake-filling">Cake Filling: {{ cake.cakeFilling }}</p>
        <p class="custom-cake-style">Style: {{ cake.style }} </p>
        <p class="custom-cake-size">Size: {{ cake.size }} </p>
        <p class="custom-cake-price">Price: $50</p>
    </div>
</template>

<script>
import CustomOrderService from '../services/CustomOrderService';

    export default {
        props: {
            cake: Object,
            data() {
                return {
                    cake: {}
                }
            }
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