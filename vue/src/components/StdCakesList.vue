<template>
    <section>
        <img id="home-image" src="HomePageImg_3.jpg" alt="You're Dead to Us Cake">

        <h2>Remedies for your Tragedies</h2>
        <p>
            At Tragic Cakes, we're prepared for the worst. We offer a variety of pre-made 
            tragedies to sweeten up any sour situation, choose from any standard cake below.  
        </p>
        <div class="std-cakes-list">
            <std-cake-card v-for="cake in cakes" v-bind:cake="cake" v-bind:key="cake.name"/>
        </div>
    </section>
    
</template>

<script>
import StdCakeCard from './StdCakeCard.vue';

export default {
    computed: {
        cakes() {
            return this.$store.state.cakes;
        }
    },
    components: {
        StdCakeCard
    }
}

</script>

<style>
h2 {
    font-family: 'Teko', sans-serif;
    font-size: 2rem;
    text-align: center;
}

p {
    text-align: center;
}
.std-cakes-list {
    display: flex;
    justify-content: space-around;
    align-items: center;
    flex-wrap: wrap;
}

#home-image {
    max-width: 100%;
    max-height: auto;
    opacity: 1;
}

</style>