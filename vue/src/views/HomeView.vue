<template>
  <div id="home">
    <img id="logo" src="Tragic_Cakes_Logo.png" alt="Tragic Cakes: We bake tragedies, not sins.">
      <std-cakes-list v-bind:cakes="cakes"></std-cakes-list>
  </div>

  <div id="footer">
    <div>
      <h3>Hours</h3>
        <p>Sunday : 7:00am - 12:00pm</p>
        <p>Monday - Saturday : 7:00am - 3:00pm</p>

      <img src="Tiny_Cake_Logo.png" alt="Purple Cake Logo">  

      <h3>Contact</h3>
        <p>901 Pennsylvania Ave #3a</p>
        <p>Pittsburgh, PA 15233</p>
        <p>(877) 606-3203</p>
    </div>
    
  </div>
</template>


<script>
import StdCakeService from '../services/StdCakeService';
import StdCakesList from '../components/StdCakesList.vue';
export default {

  components: {
    StdCakesList
  },
  data() {
    return {
      cakes: []
    };
  },
  methods: {
    getCakes() {
      StdCakeService.list() 
        .then(response => {
          this.cakes = response.data;
        })
        .catch(error => {
          // handle error
        })
      
    }
  },
  created() {
    this.getCakes();
  }

};
</script>

<style>
a:link {
  text-decoration: none;
  color: #583b66;
  }

a:visited {
  text-decoration: none;
  color: #583b66;
  }

a:hover {
  text-decoration: underline;
  color: #ffffff;
  }

a:active {
  text-decoration: none;
  color: #583b66;
  }

h3 {
    font-family:'Teko', sans-serif;
    font-size: 2rem;
    color:  #583b66;
  }

#welcomeTo {
  text-decoration: underline;
  text-align: center;
  font-size: 300%;
  }

#footer {
  column-count: 3;
  text-align: center;
}

</style>
