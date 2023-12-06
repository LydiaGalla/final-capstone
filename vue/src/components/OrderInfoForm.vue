<template>
    <div>
        <form class="customer-info-form">

            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" v-model="firstName">

            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" v-model="lastName">

            <label for="phoneNumber">Phone Number: </label>
            <input type="text" id="phoneNumber" v-model="phoneNumber">

            <label for="pickupDate">Pickup Date: </label>
            <input type="text" id="pickupDate" v-model="pickupDate">

            <label for="pickupTime">Pickup Time: </label>
            <input type="text" id="pickupTime" v-model="pickupTime">

            <button type="submit" class="is-primary">Place Order</button>
        </form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            cake: {},
            firstName: '',
            lastName: '',
            phoneNumber: ''
        }
    },
    methods: {
        
    }
}
</script>

<style>
</style>

