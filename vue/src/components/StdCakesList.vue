<template>
    <section>
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
            return this.$store.state.cakes.filter((cake) => {
                return cake.available;
            });
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


</style>