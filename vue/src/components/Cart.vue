<template>
    <order-summary></order-summary>
    <form class="add-text-form">
        <label for="addText">Add Writing to Cake (optional, $5 fee): </label>
            <input type="text" id="addText" v-model="phoneNumber">
    </form>
    <router-link :to="{ name: 'home'}">Continue Shopping</router-link>

</template>

<script>
import OrderSummary from './OrderSummary.vue';

export default {
    components: {
        OrderSummary
    }
}

</script>