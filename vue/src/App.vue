<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token == ''">Home&nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'cart' }" v-if="$store.state.token == ''">Cart&nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Employee Login</router-link>
      <router-link v-bind:to="{ name: 'employee-home'}" v-if="$store.state.token != ''">Employee Home</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">&nbsp;|&nbsp;Logout</router-link>
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
          if(this.$store.state.token != '')
          {
            this.$router.push({name: 'employee-home'})
          }
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