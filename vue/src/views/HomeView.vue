<template>
  <div id="home">
    <img id="welcome" src="Welcome.png" alt="Welcome">
      <std-cakes-list></std-cakes-list>
  </div>

  <div id="footer">
    <h3>Hours</h3>
    <p>Sunday : 7:00am - 12:00pm</p>
    <p>Monday - Saturday : 7:00am - 3:00pm</p>
  </div>
</template>


<script>
import StdCakesList from '../components/StdCakesList.vue';
export default {

  components: {
    StdCakesList
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
    font-size: x-large;
    color:  #583b66;
  }

#welcomeTo {
  text-decoration: underline;
  text-align: center;
  font-size: 300%;
  }

#welcome {
  
}

#footer {
  text-align: center;
}

</style>
