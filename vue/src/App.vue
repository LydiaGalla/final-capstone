<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token == ''" class="nav-link">Home </router-link> 
      <router-link v-bind:to="{ name: 'about' }" v-if="$store.state.token == ''" class="nav-link separator">About </router-link> 
      <router-link v-bind:to="{ name: 'cart' }" v-if="$store.state.token == ''" class="nav-link separator"> Cart </router-link> 
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''" class="nav-link separator"> Employee Login</router-link> 
      <router-link v-bind:to="{ name: 'employee-home'}" v-if="$store.state.token != ''" class="nav-link separator"> Employee Home</router-link> 
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" class="nav-link separator"> Logout</router-link>
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
.separator {
  border-left: 1.5px solid #583b66;
  margin-left: 8px;
  padding-left: 8px;
}
.nav-link {
  font-size: 20px;
  font-weight: 500;
}

</style>