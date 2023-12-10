<template>
    <div class="order-card">
        <h2 class="order-id">Order # {{ order.orderId }}</h2>
        <h3 class="order-name">{{ order.firstName }} {{ order.lastName }} </h3>
        <p class="order-phone">Phone: {{ order.phone }}</p>
        <p class="order-date-time">Pickup: {{ order.dueDate }} {{ order.dueTime }} </p>
        <!-- <p class="order-details"> Cake details: {{ order.cake_details }}</p> -->
        <p class="order-writing">Requested cake text: {{ order.writing }}</p>
        <!-- <p class="order-total">Total: ${{ order.total }}</p> -->
        <!-- <p class="order-status"> {{ order.status }}</p> -->
        <button class="status"> Edit Status</button>
    </div>
</template>

<script>

export default{
    props: {
        order: {
            type: Object,
            required: true
        }
    }
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

.status {
    background-color: #d1b8dd;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    width: 50x;
}

.status:hover {
    background-color: #583b66;
    color: white;
}

</style>