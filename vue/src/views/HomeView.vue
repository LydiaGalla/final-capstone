<template>
  <div id="home">
    <img id="logo" src="Tragic_Cakes_Logo.png" alt="Tragic Cakes: We bake tragedies, not sins.">
    <div>
    <img id="home-image" src="HomePageImg_3.jpg" alt="Home Page Image of Cake">

        <h2>Remedies for your Tragedies</h2>
        <p>
            At Tragic Cakes, we're prepared for the worst. We offer a variety of pre-made 
            tragedies to sweeten up any sour situation, choose from any standard cake below.  
        </p>

      <std-cakes-list></std-cakes-list>
    </div>
  </div>

  <div id="custom-cake-info">
    <h2>
      Customize Your Tragic Cake
    </h2>
    <p>
      Build your own custom cake for any tragic event. 
      Customize your terrible treats from the bottom up, choose everything from 
      cake flavors, fillings, frostings, and decorations. 
    </p>
    <img id="custom_cake_img" src="HomePageImg_1.jpg" alt="Round Cake with Purple Flowers">
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

#home-image {
    max-width: 100%;
    max-height: auto;
    opacity: 1;
}

#custom-cake-info {
  column-count: 2;
}

#custom-cake-img {
  max-width: 500px;
}

</style>
