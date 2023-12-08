<template>
    <div>
        
        <!--TBD For Routerlink-->
        <router-link v-bind:to="{ name: 'employee home'}"> Orders </router-link> &nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'inventory'}"> Cake Inventory </router-link> &nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'edit inventory'}"> Edit Custom Inventory </router-link>

    </div>  



</template>