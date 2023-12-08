<template>
    <div class="order-card">
        <h2 class="order-id">Order # {{ order.order_id }}</h2>
        <h3 class="order-name">{{ order.firstName }} {{ order.lastName }} </h3>
        <p class="order-phone">Phone: {{ order.phoneNumber }}</p>
        <p class="order-date-time">Pickup: {{ order.pickupDate }} {{ order.pickupTime }} </p>
        <p class="order-details"> Cake details: {{ order.cake_details }}</p>
        <p class="order-writing">Requested cake text: {{ order.writing }}</p>
        <p class="order-total">Total: ${{ order.total }}</p>
        <p class="order-status"> {{ order.status }}</p>
        <button class="status-button"> Edit Status</button>
    </div>
</template>

<script>

export default{
    props:
        ['order']
    ,
    methods: {

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

.status-button {
    background-color: #d1b8dd;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    width: 50x;
}

.status-button:hover {
    background-color: #583b66;
    color: white;
}

</style>