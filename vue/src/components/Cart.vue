<template>
    <img src="Order_Summary_Text.png" alt="Order Summary">
    <div class="cake-container">
        <std-cake-card v-for="cake in cakes" v-bind:cake="cake" v-bind:key="cake.name"></std-cake-card>
    </div>
    <router-link :to="{ name: 'home'}">Continue Shopping</router-link>

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
        StdCakeCard
    },
    methods: {
        submitForm() {
            this.$store.commit('SET_WRITING', this.addedText)
            if (this.addedText != '') {
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

.checkout-button{ 
    background-color: #583b66;
    color:#ffffff;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    font-size: large;
    width: 200x;
    
}

.checkout-button:hover {
    background-color: #ffffff;
    color:#583b66;
}
</style>