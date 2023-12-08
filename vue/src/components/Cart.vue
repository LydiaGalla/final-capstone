<template>
    <img src="Order_Summary_Text.png" alt="Order Summary">
    <div class="cake-container">
        <std-cake-card v-for="cake in cakes" v-bind:cake="cake" v-bind:key="cake.name"></std-cake-card>
    </div>
    <router-link :to="{ name: 'home'}">Continue Shopping</router-link>

    <div>
        <br>
    </div>
    <form class="add-text-form">
        <label for="addText">Add Writing to Cake (optional, $5 fee): </label>
        <input type="text" id="addText" v-model="addText">
        <div>
            <router-link :to="{ name: 'order-info-form' }">Checkout</router-link>
        </div>

    </form>
    
    <div >
    </div>
</template>

<script>
import StdCakeCard from './StdCakeCard.vue';
import StdCakeOrderService from '../services/StdCakeOrderService';

export default {
    
    data() {
        
    },
    computed: {
        cakes() {
            return this.$store.state.cakes.filter((cake) => {
                return cake.inCart === true;
            })
        }
    },
    components: {
        StdCakeCard
    },
    methods: {
        
    }
}

</script>

<style>
h1 {
    text-align: center;
    font-size: 300%;
}
</style>