<template>
    <section>
        <h2>Standard Cakes</h2>
        <div class="standard-cakes-list">
            <std-cake-card v-for="cake in cakes" v-bind:cake="cake" v-bind:key="cake.name" v:bind:enable-add="true"/>
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
.standard-cakes-list {
    display: flex;
    justify-content: space-around;
    align-items: center;
    flex-wrap: wrap;
}

</style>