<template>
    <div class="card">
        <h2 class="cake-name">{{ cake.cakeName }}</h2>
        <img v-if="cake.cakeName" v-bind:src="cake.cakeName.replace(' ', '') + 'Cake.jpg'">
        <h3 class="cake-price"> $ {{ cake.price }}</h3>
        <p class="description">{{ cake.description }}</p>
        <router-link :to="{ name: 'cart'}" style="position: absolute; bottom: 10px; margin-left: -25px;">
            <button class="addToCart" v-on:click="setInCart" v-bind:disabled="cake.inCart">Add to Cart</button>
        </router-link>
    </div>
</template>

<script>

export default {
    props:  
        ['cake']
    ,
    methods: {
        setInCart() {
            this.$store.commit('SET_IN_CART', { cake: this.cake, value: true});
        }
    },
    computed: {
        anyCakesInCart() {
            return false
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

.addToCart {
    background-color: #d1b8dd;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    width: 50x;
    
}

.addToCart:hover {
    background-color: #583b66;
    color: white;
}

</style>