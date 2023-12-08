<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'cart' }">Cart</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }"> Employee Login</router-link>
      <router-link v-bind:to="{ name: 'employee home'}"> Employee Home</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
import StdCakeService from './services/StdCakeService';
import StdCakeOrderService from './services/StdCakeOrderService';

export default {
  
  methods: {
    getCakes() {
      StdCakeService.list()
        .then(response => {
          this.$store.commit('SET_CAKES', response.data);
        })
        .catch(error => {
          // handle error ?
        })
    }
    
  },
  created() {
    this.getCakes();
  }

}

</script>

<style>


</style>