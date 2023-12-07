<template>
    <img src="Checkout_Text.png" alt="Checkout">
    <div>
        <form class="order-info-form">

            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" v-model="firstName">
            <br>

            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" v-model="lastName">
            <br>

            <label for="phoneNumber">Phone Number: </label>
            <input type="text" id="phoneNumber" v-model="phoneNumber">
            <br>

            <label for="pickupDate">Pickup Date: </label>
            <input type="date" id="pickupDate" v-model="pickupDate" :min="currentDatePlusTwoDays" :max="currentDatePlusMonth">
            
            <br>
            <label for="pickupTime">Pickup Time: </label>
            <select id="pickupTime" v-if="!isSunday" v-model="pickupTime">
                <option>7:30 AM</option>
                <option>8:00 AM</option>
                <option>8:30 AM</option>
                <option>9:00 AM</option>
                <option>9:30 AM</option>
                <option>10:00 AM</option>
                <option>10:30 AM</option>
                <option>11:00 AM</option>
                <option>11:30 AM</option>
                <option>12:00 PM</option>
                <option>12:30 PM</option>
                <option>1:00 PM</option>
                <option>1:30 PM</option>
                <option>2:00 PM</option>
                <option>2:30 PM</option>
            </select>
            <select id="pickupTime" v-if="isSunday" v-model="pickupTime">
                <option>7:30 AM</option>
                <option>8:00 AM</option>
                <option>8:30 AM</option>
                <option>9:00 AM</option>
                <option>9:30 AM</option>
                <option>10:00 AM</option>
                <option>10:30 AM</option>
                <option>11:00 AM</option>
                <option>11:30 AM</option>
            </select>

            <br>

            <button id="placeOrder" type="submit" class="is-primary">Place Order</button>
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
            phoneNumber: '',
            pickupDate: '',
            pickupTime: ''
        }
    },
    computed: {
        currentDatePlusTwoDays() {
            const date = new Date();
            date.setDate(date.getDate()+2);
            const twoDaysFromToday = new Date(date.getFullYear(), date.getMonth(), date.getDate()).toISOString().split('T')[0];
            return twoDaysFromToday;
        },
        currentDatePlusMonth() {
            const date = new Date();
            date.setDate(date.getDate()+2);
            date.setMonth(date.getMonth()+1);
            const oneMonthAndTwoDaysFromToday = new Date(date.getFullYear(), date.getMonth(), date.getDate()).toISOString().split('T')[0];
            return oneMonthAndTwoDaysFromToday;
        },
        isSunday() {
            const selectedDate = new Date(this.pickupDate);
            if (selectedDate.getDay() === 6) {
                return true;
            }
            return false;
        }
    },
    methods: {
        
    }
}
</script>

<style>
#placeOrder{
    
    font-family: 'Teko', sans-serif;
    
}

</style>

