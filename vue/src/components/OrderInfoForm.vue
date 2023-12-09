<template>
    <img src="Checkout_Text.png" alt="Checkout">
    <div>
        <form v-on:submit.prevent="submitForm" class="order-info-form">

            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" v-model="createOrder.firstName">
            <br>

            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" v-model="createOrder.lastName">
            <br>

            <label for="phoneNumber">Phone Number: </label>
            <input type="text" id="phoneNumber" v-model="createOrder.phone">
            <br>

            <label for="dueDate">Pickup Date: </label>
            <input type="date" id="dueDate" v-model="createOrder.dueDate" :min="currentDatePlusTwoDays" :max="currentDatePlusMonth">
            
            <br>
            <label for="dueTime">Pickup Time: </label>
            <select id="dueTime" v-if="!isSunday" v-model="createOrder.dueTime">
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
            <select id="dueTime" v-if="isSunday" v-model="createOrder.dueTime">
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
            <button id="cancel" type="button" v-on:click="cancelForm">Cancel</button>
        </form>
    </div>
</template>

<script>
import StdCakeOrderService from '../services/StdCakeOrderService';
import StdCakeCard from './StdCakeCard.vue';

export default {
    props: {
        order: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
        //     
          createOrder: {
            
            writing: this.$store.state.writing,
            firstName: this.order.firstName,
            lastName: this.order.lastName,
            phone: this.order.phoneNumber,
            dueDate: this.order.dueDate,
            dueTime: this.order.dueTime,
            
          }
        };
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
            const selectedDate = new Date(this.createOrder.dueDate);
            if (selectedDate.getDay() === 6) {
                return true;
            }
            return false;
        },
        cakeInCart() {
            console.log(this.$store.state.cakes.find(cake => cake.inCart === true))
            return this.$store.state.cakes.find(cake => cake.inCart === true);
        
        }
    },
    methods: {
        submitForm() {

          if (!this.validateForm()) {
            return;
          }

          this.createOrder.standardCakeId = this.cakeInCart.standardCakeId,
          this.createOrder.total = this.cakeInCart.price
          this.createOrder.dueTime = null // TODO: fix this
            
            StdCakeOrderService
              .addStandardCakeOrder(this.createOrder)
              .then(response => {
                if (response.status === 201) {
                    this.$store.commit('CLEAR_CART')
                    this.$router.push({ name: 'home' });
                }
              })
              .catch(error => {
                alert("Something went wrong.");
              });
        },
        cancelForm() {
            this.$router.back();
        },
        
        validateForm() {
            return true;
            // TODO: write this method
        }
                
    }
}
</script>

<style>
#placeOrder, #cancel {
    background-color: white;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    width: 50x;    
}

#placeOrder:hover {
    background-color: #583b66;
    color: white;
}

</style>

