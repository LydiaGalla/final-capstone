<template>

<!-- Show all pending orders button or filter -- give an option to mark as: 
    complete, pending, ready, cancelled -- have it update in the view -->
    <div>
        <h3> Employee Home - Orders </h3>

        <!-- navigation component for employees
        -- Orders -- Add Cake -- Edit inventory -->
        <EmployeeNav></EmployeeNav>

        <!-- table component for orders
        -- Name, contact, pickup, status, button to change .. etc.. -->
        <OrderList></OrderList>

       
        



    </div>

<!--  -->

<!--  -->

</template>

<script>

import OrderList from '../components/OrderList.vue';
import EmployeeNav from '../components/EmployeeNav.vue';

export default{
    data(){
        return{

        }
    },
    components:{
        OrderList,
        EmployeeNav
    }
}


</script>