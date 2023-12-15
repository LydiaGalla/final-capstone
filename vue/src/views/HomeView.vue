<template>
    <div id="home">
      <img id="logo" src="Tragic_Cakes_Logo.png" alt="Tragic Cakes: We bake tragedies, not sins.">
    <div>
      <br>
      <img id="home-image" src="HomePageImg_3.jpg" alt="Home Page Image of Cake">
      <br>
      <br>

          <img src="Remedies_Text.png" alt="Remedies for your Tragedies">
          <p>
              At Tragic Cakes, we're prepared for the worst. We offer a variety of pre-made 
              tragedies to sweeten up any sour situation, choose from any standard cake below.  
          </p>
    </div>

    <div class="std-cake-list-container">
        <std-cakes-list></std-cakes-list>
    </div>

  </div>

  <br>
  <br>

  <div id="custom-cake-info">
    <div>
  
    <img src="Customize_Cake_Text.png" alt="Customize Your Tragic Cake">
    <p>
      Build your own custom cake for any tragic event. 
      Customize your terrible treats from the bottom up, choose everything from 
      cake flavors, fillings, frostings, and decorations. 
    </p>
    <br>
    <router-link :to="{ name: 'custom order form'}">
      <button class="custom-cake-order"> Order Now </button>
    </router-link>
    </div>
    <br>
    </div>

   
    <img id="home-image" src="HomePageImg_1.jpg" alt="Round Cake with Purple Flowers">

  <br>
  <br>

  <v-footer>
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
  </v-footer>
</template>


<script>
import StdCakeService from '../services/StdCakeService';
import StdCakesList from '../components/StdCakesList.vue';
export default {

  components: {
    StdCakesList
  }
  
};
</script>

<style>
.std-cake-list-container{
  margin: 75px 0px
}

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
  margin-top: 50px;
  margin-bottom: 50px;
  column-count: 3;
  text-align: center;
}

#home-image {
    padding-top: 50px;
    max-width: 100%;
    max-height: auto;
    opacity: 1;
}

.custom-cake-img {
  display: flex;
  max-width: 100%;
}

.custom-cake-order{
    background-color: #583b66;
    color:#ffffff;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    font-size: 35px;
    width: 200px;
    margin-left: 42%;
    
}

.custom-cake-order:hover {
    background-color: #ffffff;
    color:#583b66;

}

#home-image{
  margin-top: 50px;
}

#logo {
  padding-top: 100px;
}

</style>
