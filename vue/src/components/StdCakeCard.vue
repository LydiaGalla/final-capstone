<template>
    <div class="standard-cake">
        <div class="card">
            <h2 class="cake-name">{{ cake.cakeName }}</h2>
            <img v-if="cake.imageUrl" v-bind:src="cake.imageUrl">
            <img v-else-if="cake.cakeName" v-bind:src="'/' + cake.cakeName.replace(' ', '') + 'Cake.jpg'">
            <h3 class="cake-price"> $ {{ cake.price }}</h3>
            <p class="description">{{ cake.description }}</p>
            <div class="button-container-employee" v-if="isAuthenticated">
                <!-- <button class="mark-available" v-on:click.prevent="setAvailabilityStatus(true)" v-if="!cake.available">Available</button>
                <button class="mark-unavailable" v-on:click.prevent="setAvailabilityStatus(false)" v-if="cake.available">Unavailable</button> -->
                <button v-bind:class="{'mark-unavailable' : cake.available, 'mark-available' : !cake.available}" v-on:click="toggleAvailable(cake)">{{ cake.available === true ? 'Mark Unavailable' : 'Mark Available' }}</button>
            </div>
            <div v-if="!isAuthenticated">
                <button class="add-to-cart" v-on:click.prevent="setInCart(true)" v-bind:disabled="anyCakesInCart">Add to Cart</button>
            </div>
            <!-- <div v-show="thisCakeInCart">
                <p>Hello</p>
            </div> -->
            <!-- <div>
                <button class="add-to-cart" v-if="cake.cakeName === thisCakeInCart.cakeName">Add to Cart</button>
            </div> -->
            <!-- <div v-if="anyCakesInCart"> -->
                <!-- <button class="delete-from-cart" v-bind:cake="thisCakeInCart" v-on:click.prevent="setInCart(false)">Remove from Cart</button> -->

            <!-- </div> -->
            
        </div>
    </div>
</template>

<script>
import stdCakeService from '../services/StdCakeService.js'

export default {
    props: {
        cake: Object

    },
    methods: {
        setInCart(value) {
            this.$store.commit('SET_IN_CART', { cake: this.cake, value: value});
            this.$router.push({ name: 'cart'});
        },
        toggleAvailable(cake){
            this.$store.commit('TOGGLE_AVAILABLE', cake);
            stdCakeService
              .updateAvailability(cake.standardCakeId, cake.available);
        }
    },
    computed: {
        thisCakeInCart() {
            const currCakeName = this.$route.params.cakeName;
            return this.$store.state.cakes.find(cake => cake.cakeName === currCakeName);
        },
        anyCakesInCart() {
            for (let cake of this.$store.state.cakes) {
                if (cake.inCart == true) {
                    return true;
                }
            }
            return false;
        },
        isAuthenticated() {
            return this.$store.state.token != '';
        }
    }
}

</script>

<style>
.card {
  text-align: center;
  width: 300px;
  height: 420px;
  margin: 20px;
  padding: 20px;
  border-radius: 10px;
}

.card .cake-name {
  font-size: 1.4rem;
  margin-bottom: 5px;
}

.card .cake-img {
  max-width: 100%;
  height: auto;
  border-radius: 8px;
  margin-bottom: 10px;
}

.card .cake-price {
  font-family: 'Teko', sans-serif;
  font-size: 1.5rem;
}

.card .cake-description {
    color: black;
}
.card .cake-name {
    font-family: 'Teko', sans-serif;
    font-size: 2rem;
    color: #583b66;
}

.add-to-cart, .delete-from-cart, .mark-available, .mark-unavailable {
    background-color: #d1b8dd;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    width: 50x;
    position: absolute;
    bottom: 15px;
    margin-left: -40px;
}

.addToCart:hover {
    background-color: #583b66;
    color: white;
}

</style>