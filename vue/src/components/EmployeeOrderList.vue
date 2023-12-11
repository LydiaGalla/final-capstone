<template>
    <section>
        <div class="order-list" >
            <order-card v-for="order in orders" v-bind:order="order" v-bind:key="order.orderId"></order-card>
            <!-- <router-link v-bind:to="{ name: 'order-details-view', params: { orderId: order.id} }">
                {{ order.firstName }}
            </router-link> -->
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