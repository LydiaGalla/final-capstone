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
        <employee-order-list v-bind:orders="orders"></employee-order-list>
       

    </div>

<!--  -->

<!--  -->

</template>

<script>

import stdCakeOrderService from '../services/StdCakeOrderService';
import EmployeeOrderList from '@/components/EmployeeOrderList.vue';
import EmployeeNav from '../components/EmployeeNav.vue';

export default{
    components:{
        EmployeeOrderList,
        EmployeeNav
    },
    data() {
        return {
            orders: []
        };
    },
    methods: {
        getOrders() {
            stdCakeOrderService.list()
              .then(response => {
                this.orders = response.data;
              })
              .catch(error => {
                alert("Something went wrong.");
              });
        }
    },
    created() {
        this.getOrders();
    }

    
}

</script>