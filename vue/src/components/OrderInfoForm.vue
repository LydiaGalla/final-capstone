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
            <input type="text" id="phoneNumber" v-model="createOrder.phoneNumber">
            <br>

            <label for="pickupDate">Pickup Date: </label>
            <input type="date" id="pickupDate" v-model="createOrder.pickupDate" :min="currentDatePlusTwoDays" :max="currentDatePlusMonth">
            
            <br>
            <label for="pickupTime">Pickup Time: </label>
            <select id="pickupTime" v-if="!isSunday" v-model="createOrder.pickupTime">
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
            // name: this.cake.name,
            // price: this.cake.price,
            // writing: this.cake.writing,
            // total: this.cake.total,
            firstName: this.order.firstName,
            lastName: this.order.lastName,
            phoneNumber: this.order.phoneNumber,
            pickupDate: this.order.pickupDate,
            pickupTime: this.order.pickupTime
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
            const selectedDate = new Date(this.pickupDate);
            if (selectedDate.getDay() === 6) {
                return true;
            }
            return false;
        }
    },
    methods: {
        submitForm() {

          if (!this.validateForm()) {
            return;
          }

          if (this.createOrder.id === 0) {
            
            StdCakeOrderService
              .addStandardCakeOrder(this.createOrder)
              .then(response => {
                if (response.status === 201) {
                    this.$store.commit('SET_NOTIFICATION', { message: 'A new cake order was added.', type: 'success'});
                    this.$router.push({ name: 'order-info-form', params: { id: this.createOrder.id } });
                }
              })
              .catch(error => {
                alert("Something went wrong.");
              });

          } else {
            //  StdCakeOrderService
            //    .updateStandardCakeOrder(this.createOrder)
            //    .then(response => {
            //     if (response.status === 200) {
            //         this.$store.commit('SET_NOTIFICATION', { message: `Standard Cake ${this.createOrder.id} was updated.`, type: 'success'});
            //         this.$router.push({name: 'home', params: { id: this.createOrder.id } });
            //     }
            //    })
            //    .catch(error => {
            //      this.handleErrorResponse(error, 'updating');
            //   });
          }
        },
        cancelForm() {
            this.$router.back();
        },
        
        validateForm() {
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

