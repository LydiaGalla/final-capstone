<template>

<div>

<h3> Employee Home - Edit Inventory</h3>
<EmployeeNav></EmployeeNav>
<br>
<br>
<CustomCakeInventory></CustomCakeInventory>
<br>



</div>

</template>

<script>
import EmployeeNav from '../components/EmployeeNav.vue';
import CustomCakeInventory from '../components/CustomCakeInventory.vue';


export default{
    data(){
        return{}
    },
    components: {
        EmployeeNav,
        CustomCakeInventory
    }
    
}

</script>

<style>

</style>