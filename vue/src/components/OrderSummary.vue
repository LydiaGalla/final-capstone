<template>
    <div class="cake-container">
        <std-cake-card v-for="cake in cakes" v-bind:cake="cake" v-bind:key="cake.name"></std-cake-card>
    </div>
    
</template>

<script>
import StdCakeCard from './StdCakeCard.vue';

export default {
    computed: {
        cakes() {
            return this.$store.state.cakes.filter((cake) => {
                return cake.inCart === true;
            })
        }
    },
    components: {
        StdCakeCard
    }
}

</script>