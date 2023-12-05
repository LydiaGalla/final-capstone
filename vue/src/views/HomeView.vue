<template>
  <div id="home">
    <h1 id="welcomeTo">Welcome To Tragic Cakes!</h1>
      <h3>Fill with stuffs</h3>
      <std-cakes-list></std-cakes-list>

  </div>
  <div id="login" class="text-center">
      
    <img id="HomeCake" src= "\Sadcat.jpeg" alt="Picture of Cake">
  </div>

<div class="container"> dfs

	<h1 class="HomePageHeadLinks" id="StanHomeLink"><strong>Order one of our Tragic Standard Cakes</strong></h1>
  

  <div class="stan-cake-list">
    <div v-for="(product, index) in products" :key="index" class="stan-cake-card">
      <img :src="product.image" alt="Product Image" class="stan-cakes-image" />
      <h3 class="stan-cake-name">{{ stancake.name }}</h3>
      <p class="stan-cake-description">{{ product.description }}</p>
    </div>
  </div>
</div>
</template>


<script>
import StdCakesList from '@/components/StdCakesList.vue'
export default {

  components: {
    StdCakesList
  }


};
</script>

<style>
a:link {
  text-decoration: none;
  color: rgb(224, 166, 99);
  }


a:visited {
  text-decoration: none;
  color: rgb(224, 166, 99);
  }


a:hover {
  text-decoration: none;
  color: rgb(26, 80, 80);
  }


a:active {
  text-decoration: none;
  color: rgb(224, 166, 99);
  }

h3 {
    color:  rgb(10, 36, 168);
  }

#welcomeTo {
  text-decoration: underline;
  font-size: 300%;
  }



</style>
