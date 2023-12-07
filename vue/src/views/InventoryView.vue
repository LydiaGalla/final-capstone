<template>
    <div>
        <h3>Employee Home - Inventory</h3>
        <EmployeeNav></EmployeeNav>
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