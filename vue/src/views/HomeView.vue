<template>
  <div id="home">
    <h1 id="welcomeTo">Welcome To Tragic Cakes!</h1>
      <h3>Fill with stuffs</h3>
      <std-cakes-list></std-cakes-list>

  </div>
  <div id="login" class="text-center">
      
    <img id="HomeCake" src= "\Sadcat.jpeg" alt="Picture of Cake">
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
