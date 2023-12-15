<template>
    <div>
        <img src="Checkout_Text.png" alt="Checkout">

            <div class="order-info-form-container">
                <h3> Please Enter Your Contact Information </h3>
                <form v-on:submit.prevent="submitForm" class="order-info-form box">

                    <label for="firstName">First Name:</label>
                    <br>
                    <input class="input" type="text" id="firstName" v-model="createOrder.firstName">
                    <br>
                    <br>

                    <label for="lastName">Last Name: </label>
                    <br>
                    <input class="input" type="text" id="lastName" v-model="createOrder.lastName">
                    <br>
                    <br>

                    <label for="phone">Phone Number: </label>
                    <br>
                    <input class="input" type="text" id="phone" v-model="createOrder.phone">
                    <br>
                    <br>

                    <label for="dueDate"> Pickup Date: </label>
            
                    <input type="date" id="dueDate" v-model="createOrder.dueDate" :min="currentDatePlusTwoDays"
                        :max="currentDatePlusMonth">

                    
                    <label for="dueTime"> Pickup Time: </label>
                    <select id="dueTime" v-if="!isSunday" v-model="createOrder.dueTime">
                        <option value="07:30">7:30 AM</option>
                        <option value="08:00">8:00 AM</option>
                        <option value="08:30">8:30 AM</option>
                        <option value="09:00">9:00 AM</option>
                        <option value="09:30">9:30 AM</option>
                        <option value="10:00">10:00 AM</option>
                        <option value="10:30">10:30 AM</option>
                        <option value="11:00">11:00 AM</option>
                        <option value="11:30">11:30 AM</option>
                        <option value="12:00">12:00 PM</option>
                        <option value="12:30">12:30 PM</option>
                        <option value="13:00">1:00 PM</option>
                        <option value="13:30">1:30 PM</option>
                        <option value="14:00">2:00 PM</option>
                        <option value="14:30">2:30 PM</option>
                    </select>
                    <select id="dueTime" v-if="isSunday" v-model="createOrder.dueTime">
                        <option value="07:30">7:30 AM</option>
                        <option value="08:00">8:00 AM</option>
                        <option value="08:30">8:30 AM</option>
                        <option value="09:00">9:00 AM</option>
                        <option value="09:30">9:30 AM</option>
                        <option value="10:00">10:00 AM</option>
                        <option value="10:30">10:30 AM</option>
                        <option value="11:00">11:00 AM</option>
                        <option value="11:30">11:30 AM</option>
                    </select>
                    <br>
                    <br>
                    <div class="button-group-order-info">
                        <button id="placeOrder" type="submit" class="is-primary">Place Order</button>
                        <button id="cancel" type="button" v-on:click="cancelForm">Cancel</button>
                    </div>
                </form>
            </div>
    </div>
</template>

<script>
import StdCakeOrderService from '../services/StdCakeOrderService';
import StdCakeCard from './StdCakeCard.vue';

export default {
    
    data() {
        return {
            //     
            createOrder: {

                writing: this.$store.state.writing,
                firstName: '',
                lastName: '',
                phone: '',
                dueDate: '',
                dueTime: '',

            }
        };
    },
    computed: {
        currentDatePlusTwoDays() {
            const date = new Date();
            date.setDate(date.getDate() + 2);
            const twoDaysFromToday = new Date(date.getFullYear(), date.getMonth(), date.getDate()).toISOString().split('T')[0];
            return twoDaysFromToday;
        },
        currentDatePlusMonth() {
            const date = new Date();
            date.setDate(date.getDate() + 2);
            date.setMonth(date.getMonth() + 1);
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

            if (this.$store.state.customCakeInCart == null) {
                this.createOrder.standardCakeId = this.cakeInCart.standardCakeId,
                this.createOrder.total = this.cakeInCart.price
            } else {
                this.createOrder.customCakeId = this.$store.state.customCakeInCart.customCakeId;
                this.createOrder.total = this.$store.state.customCakeInCart.cakePrice;
                if (this.writing != '') {
                    this.createOrder.total += 5;
                }
            }

            StdCakeOrderService
                .addStandardCakeOrder(this.createOrder)
                .then(response => {
                    if (response.status === 201) {
                        this.$store.commit('CLEAR_CART')
                        this.$router.push({ name: 'order-confirmation' });
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

.button-group-order-info{
    display: flex;
    justify-content: center;
    padding: 10px;
    
}
.order-info-form-container{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-top: 50px;
}

#placeOrder, #cancel {
    
    background-color: #583b66;
    color: white;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    font-size: large;
    width: 100x;
    margin: 0 10px 0 10px;
}

#placeOrder:hover, #cancel:hover {
    background-color: #ffffff00;
    color:#583b66;
    border: 1px solid #583b66;
    cursor: pointer;
}
</style> 
