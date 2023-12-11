<template>
    <div>
        <h3>Employee Home - Inventory</h3>
        <EmployeeNav></EmployeeNav>
        <br>
        <button class="add-standard-cake"> Add New Standard Cake Option </button>
        <StdCakesListVue></StdCakesListVue>


    </div>



</template>

<script>
import StdCakesListVue from '../components/StdCakesList.vue';
import EmployeeNav from '../components/EmployeeNav.vue';

export default{
    data(){

    },
    components: {
        StdCakesListVue,
        EmployeeNav
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