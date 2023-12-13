<template>
    <div class="order-card">
        <h2 class="order-id">Order # {{ editOrder.orderId }}</h2>
        <h3 class="order-name">{{ editOrder.firstName }} {{ order.lastName }} </h3>
        <p class="order-phone">Phone: {{ editOrder.phone }}</p>
        <p class="order-date-time">Pickup: {{ editOrder.dueDate }} {{ editOrder.dueTime }} </p>
        <p class="order-details"> Cake Name: {{ cake.cakeName != null ? cake.cakeName : '(Custom Cake, see details below)' }} </p>
        <custom-order-card :cake="$store.state.customCakeInCart" v-if="editOrder.customCakeId === $store.state.customCakeInCart.customCakeId" />
        <!-- <p v-if="customCake.customCakeId != null" class="custom-order-details"> {{ customCake.cakeFlavor }}</p> -->
        <p class="order-writing">Requested cake text: {{ editOrder.writing }} </p>
        <p class="order-total">Total: ${{ editOrder.total }}</p>
        <p :class="{ 'order-status': editOrder.status === 'Pending' }"> {{ editOrder.status }}</p>
        <select class="status" id="status" v-model="status">
            <option value="">&nbsp; &nbsp;Edit Status</option>
            <option value="Pending">&nbsp; &nbsp;Pending</option>
            <option value="Ready">&nbsp; &nbsp;Ready</option>
            <option value="Completed">&nbsp; &nbsp;Completed</option>
            <option value="Cancelled">&nbsp; &nbsp;Cancelled</option>
        </select>

        <button v-on:click.prevent="updateOrderStatus()" :disabled="status ===''" class="status"> Save </button>


    </div>
</template>

<script>
import stdCakeService from '../services/StdCakeService';
import stdCakeOrderService from '../services/StdCakeOrderService';
import CustomOrderService from '../services/CustomOrderService';
import CustomOrderCard from '../components/CustomOrderCard.vue'

export default{
    components: {
        CustomOrderCard
    },
    props: {
        order: {
            type: Object,
            required: true
        }
    
    },

    data() {
        return {
            cake: {},
            editOrder: { ...this.order},
            status: ''
        }
    },

    methods: {
        getCake(id) {
            stdCakeService.get(id)
              .then(response => {
                this.cake = response.data;
              })
              .catch(error => {
                //alert("Something went wrong.");
              });
        },
        updateOrderStatus() {
            stdCakeOrderService
              .updateStatus(this.status, this.order.orderId)
              .then(() => {
                this.editOrder.status = this.status
              })
        }
    },
    computed: {
        currCustomCake() {
            const currCustomCakeId = this.$route.params.customCakeId;
            return this.$store.state.customCakeInCart
        }
    },
    mounted() {
        this.getCake(this.order.standardCakeId);
    },
    



}

</script>

<style>
.order-card {
  text-align: center;
  background-color: white;
  width: 800px;
  height: 300px;
  margin: 20px;
  padding: 20px;
  border-radius: 10px;
}

.order-status {
    color: red;
}

.status {
    background-color: #d1b8dd;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    width: 50x;
}

.status:hover {
    background-color: white;
    color: #583b66;
}

</style>