<template>

    <div class="header-img">
        <img src="About_Us_Text.png" alt="About Us">
    </div>

      
        <br>
    <div class="about-info">
        <p class="about-description">
            Well imagine, you've found yourself in a tragic situation.
            <br>
            <br>
            Here at Tragic Cakes we realize that it's much better to face these kinds of things with a few sweets, but we present 
            them a bit dramatically.   
            <br>
            <br>
            Whether you're in the midst of a traumatic breakup, you sideswiped your roommates car in the driveway, or you're
            kicking an employee to the curb, we've got you covered.  
            <br>
            <br>
            Choose from a variety of pre-made cakes or customize your own tragedy. 
        </p>   
    
        <img class="store-front-image" src="Store_Front.jpg" alt="Store Front Image">
    
    </div>

    <br> 
    <br>

    <img src="Merch_Coming_Soon_Text.png" alt="Merch Coming Soon">

    <div class="merch">
        <div class="merch-card">
            <h2>Tragic Hat</h2>
            <img class="merch-image" src="Tragic_Hat.png" alt="Tragic Hat">
            <h3>$30</h3>
            <br>
            <p>Available in Black or White</p>
            <p>Size: Adult or Child</p>
        </div>

        <div class="merch-card">
            <h2>Tragic Hoodie</h2>
            <img class="merch-image" src="Tragic_Hoodies.png" alt="Tragic Hat">
            <h3>$40</h3>
            <br>
            <p>Available in Black or White</p>
            <p>Size: XS-XXXL</p>
        </div>
    </div>

    <div class="music">
        <audio src="I Write Sins Not Tragedies.mp3" controls autoplay></audio>
    </div> 
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

</script>

<style>
.header-img{
    margin: 50px;
}



.about-description {
    font-size:x-large;
    font-weight: 500;
    padding-right: 5%;
    
}

.about-info {
    display: flex;
    margin-left: 10%;
    margin-right: 10%;

}

.store-front-image {
    max-width: 100%;
    border-radius: 5%;
}

.merch-card {
  background-color: white;
  text-align: center;
  width: 300px;
  height: 420px;
  margin: 20px;
  padding: 20px;
  border-radius: 10px;
}

.merch-image{
    max-width: 60%;
}

.merch{
    display: flex;
    justify-content: center;
}

.music {
    display: flex;
    justify-content: center;
    margin: 50px;
}

</style>