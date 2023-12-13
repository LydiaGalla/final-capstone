<template>
    <section class="all-orders">
        <div id="active-orders-title">
            <p class="active-orders">&nbsp; Active Orders &nbsp;</p>
        </div>
        <div class="pending-orders-list">
            <order-card v-for="order in pendingOrders" v-bind:order="order" v-bind:key="order.orderId"></order-card>
            <!-- <router-link v-bind:to="{ name: 'order-details-view', params: { orderId: order.id} }">
                {{ order.firstName }}
            </router-link> -->
        </div>
        <div id="button-container">
            <button v-on:click.prevent="showArchived = !showArchived" class="show-archived-orders">&nbsp;{{!showArchived ? 'Show Archived Orders' : 'Hide Archived Orders'}}&nbsp;</button>
        </div>
        <div v-if="showArchived" class="archived-orders-list">
            <order-card v-for="order in archivedOrders" v-bind:order="order" v-bind:key="order.orderId"></order-card>
        </div>
    </section>
    
</template>

<script>
import OrderCard from './OrderCard.vue';

export default {

    data() {
        return {showArchived: false};
    },
    props: {
      orders: {
        type: Array,
        required: true
      }
    },
    computed: {
        pendingOrders() {
            return this.orders.filter((order) => {
                return order.status === "Pending" || order.status === "Ready";
            }) 
        },
        archivedOrders() {
            return this.orders.filter((order) => {
                return order.status === "Cancelled" || order.status === "Completed";
            })
        }
    },
    components: {
        OrderCard
    },
    methods: {
        
    }
    
}

</script>

<style>
.pending-orders-list, .archived-orders-list {
    display: flex;
    justify-content: space-around;
    align-items: center;
    flex-wrap: wrap;
}
.active-orders {
    display: flex;
    justify-content: center;
    background-color: #583b66;
    color: white;
    border: none;
    border-radius: 12px;
    font-family: 'Teko', sans-serif;
    font-size: 30px;
}
#active-orders-title {
    display: flex;
    justify-content: center;
}
#button-container {
    display: flex;
    justify-content: center;
}
.show-archived-orders {
    background-color: #583b66;
    color: white;
    border: none;
    border-radius: 12px;
    font-family: 'Teko', sans-serif;
    font-size: 30px;
}
.show-archived-orders:hover {
    background-color: #ffffff;
    color:#583b66;
}

</style>