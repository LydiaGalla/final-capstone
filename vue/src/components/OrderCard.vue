<template>
    <div class="order-card">
        <h2 class="order-id">Order # {{ order.orderId }}</h2>
        <h3 class="order-name">{{ order.firstName }} {{ order.lastName }} </h3>
        <p class="order-phone">Phone: {{ order.phone }}</p>
        <p class="order-date-time">Pickup: {{ order.dueDate }} {{ order.dueTime }} </p>
        <p class="order-details"> Cake Name: {{ cake.cakeName }}</p>
        <p class="order-writing">Requested cake text: {{ order.writing }}</p>
        <p class="order-total">Total: ${{ order.total }}</p>
        <p class="order-status"> {{ order.status }}</p>

        <select class="status" id="status" v-model="status">
            <option value="">&nbsp; &nbsp;Edit Status</option>
            <option value="Pending">&nbsp; &nbsp;Pending</option>
            <option value="Ready">&nbsp; &nbsp;Ready</option>
            <option value="Completed">&nbsp; &nbsp;Completed</option>
            <option value="Cancelled">&nbsp; &nbsp;Cancelled</option>
        </select>

        <button class="status"> Save </button>


    </div>
</template>

<script>
import stdCakeService from '../services/StdCakeService';
import stdCakeOrderService from '../services/StdCakeOrderService';

export default{
    props: {
        order: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            status: ''
        }
    },
    computed: {
    

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
            stdCakeOrderService.updateStatus(status, this.cake.standardCakeId);
            //TODO COME BACK AND FINISH
        }
    },
    mounted() {
        this.getCake(this.order.standardCakeId)
    }
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