<template>
    <img src="Order_Summary_Text.png" alt="Order Summary">

    <div id="checkout-container">
        <div class="cake-container">
            <div v-if="$store.state.customCakeInCart != null">
                <custom-order-card v-bind:cake="$store.state.customCakeInCart" class="pad-and-margin"></custom-order-card>
            </div>
            <div v-else>
                <std-cake-card v-for="cake in cakes" v-bind:cake="cake" v-bind:key="cake.name"></std-cake-card>
            </div>
 
        </div>

        <div id="form-container">
            <form v-on:submit.prevent="submitForm" class="add-text-form">
                <label for="addText">Add Writing to Cake (optional, $5 fee):</label>
                <br>
                <input class="input" type="text" placeholder="Custom Message..." id="addedText" v-model="addedText">
                <br>
                <router-link :to="{ name: 'home'}"><button class="continue-shopping"> Continue Shopping </button> </router-link><button class="checkout-button">Checkout</button>
                <br>
            </form>
        </div>
        
        <div v-if="($store.state.customCakeInCart == null) && '<!--standard cake in cart is null-->'">
                <h2> Your Cart Is Empty! </h2>
                <h3> Please add items to your cart to checkout.</h3>
            </div>

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
        },
        isSomethingInCart() {
            return this.cakes.length > 0 || this.$store.state.customCakeInCart != null;
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

.checkout-button{ 
    background-color: #583b66;
    color:#ffffff;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    font-size: 20px;
    width: auto;
    padding: 0px 10px;
    margin: 10px;
    
}

.continue-shopping {
    background-color: #ffffff;
    color:#583b66;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    font-size: 20px;
    padding: 0px 10px 0px 10px;
    margin: 10px;
}

 .checkout-button:hover {
    background-color: #ffffff;
    color:#583b66;
}

.continue-shopping:hover {
    background-color: #583b66;
    color:#ffffff;
}

.pad-and-margin {
    padding: 20px;
    margin: 20px;
}

#footer {
  column-count: 3;
  text-align: center;
}
.input{
    width: 250px;
    height: 30px;
}
#checkout-container{
    display: flex;
    align-items: center;
    justify-content: center;
}
#form_container{
    display: flex;
    flex-direction: column;
    align-items: center;
}
    
    


</style>