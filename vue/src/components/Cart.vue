<template>
    <img src="Order_Summary_Text.png" alt="Order Summary">
    <div class="cake-container">
        <div v-if="$store.state.customCakeInCart != null">
            <custom-order-card v-bind:cake="$store.state.customCakeInCart" class="pad-and-margin"></custom-order-card>
        </div>
        <div v-else>
            <std-cake-card v-for="cake in cakes" v-bind:cake="cake" v-bind:key="cake.name"></std-cake-card>
        </div>
    </div>
    <router-link :to="{ name: 'home'}">
        <button class="continue-shopping"> Continue Shopping </button> 
    </router-link>

    <div>
        <br>
    </div>
    <form v-on:submit.prevent="submitForm" class="add-text-form">
        <label for="addText">Add Writing to Cake (optional, $5 fee):</label>
        <input type="text" id="addedText" v-model="addedText">
        
        <div>
            <br>
            <button class="checkout-button">Checkout</button>
        </div>

    </form>
    
    <div >
    </div>
</template>

<script>
import StdCakeCard from './StdCakeCard.vue';
import StdCakeOrderService from '../services/StdCakeOrderService';
import CustomOrderCard from './CustomOrderCard.vue';
import CustomOrderService from '../services/CustomOrderService';

export default {
    
    data() {
        return {
            addedText: ''
        }
    },
    computed: {
        cakes() {
            return this.$store.state.cakes.filter((cake) => {
                return cake.inCart === true;
            })
        }
    },
    components: {
        StdCakeCard,
        CustomOrderCard
    },
    methods: {
        submitForm() {
            this.$store.commit('SET_WRITING', this.addedText)
            if (this.addedText != '' && this.cakes.length > 0) {
                this.$store.commit('CHARGE_FEE', { cake: this.cakes[0], value: 5});
            }
            this.$router.push({ name: 'order-info-form' });
        }
        
        
    }
}

</script>

<style>
h1 {
    text-align: center;
    font-size: 300%;
}

.continue-shopping, .checkout-button{ 
    background-color: #583b66;
    color:#ffffff;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    font-size: large;
    width: 200x;
    
}

.continue-shopping:hover, .checkout-button:hover {
    background-color: #ffffff;
    color:#583b66;
}

.pad-and-margin {
    padding: 20px;
    margin: 20px;
}
</style>