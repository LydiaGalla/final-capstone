<template>
    <div>
        <h3>Employee Home - Inventory</h3>
        <EmployeeNav></EmployeeNav>
        <br>
        <button class="add-standard-cake"> Add New Standard Cake Option </button>
        <div class="std-cakes-list">
            <std-cake-card v-for="cake in cakes" v-bind:cake="cake" v-bind:key="cake.id"/>
        </div>

    </div>



</template>

<script>
import EmployeeNav from '../components/EmployeeNav.vue';
import StdCakeCard from '../components/StdCakeCard.vue';

export default{
    // data(){

    // },
    components: {
        StdCakeCard,
        EmployeeNav
    },
    computed: {
        cakes() {
            return this.$store.state.cakes;
        }
    }

}

</script>

<style>
.add-standard-cake {
    background-color: #583b66;
    color: white;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    font-size: large;
    width: 50x;
}
.add-standard-cake:hover {
    background-color: #ffffff;
    color:#583b66;
}



</style>