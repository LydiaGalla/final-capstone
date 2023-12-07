<template>
    <div>
        
        <!--TBD For Routerlink-->
        <router-link v-bind:to="{ name: 'employee home'}"> Orders </router-link> &nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'inventory'}"> Inventory </router-link> &nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'edit inventory'}"> Edit Inventory </router-link>

    </div>  



</template>