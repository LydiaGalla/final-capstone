<template>
    <section>
        <div class="order-list">
            <order-card v-for="order in orders" v-bind:order="order" v-bind:key="order.name"/>
        </div>
    </section>
    
</template>

<script>
import OrderCard from './OrderCard.vue';

export default {
    computed: {
        orders() {
            return this.$store.state.orders;
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