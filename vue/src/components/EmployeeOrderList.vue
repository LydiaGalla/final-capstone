<template>
    <section>
        <div class="order-list" >
            <order-card v-for="order in pendingOrders" v-bind:order="order" v-bind:key="order.orderId"></order-card>
            <!-- <router-link v-bind:to="{ name: 'order-details-view', params: { orderId: order.id} }">
                {{ order.firstName }}
            </router-link> -->
            <!-- <order-card v-for="order in archivedOrders" v-bind:order="order" v-bind:key="order.orderId"></order-card> -->


        </div>
    </section>
    
</template>

<script>
import OrderCard from './OrderCard.vue';

export default {
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
    }
    
}

</script>

<style>
.order-list {
    display: flex;
    justify-content: space-around;
    align-items: center;
    flex-wrap: wrap;
}

</style>