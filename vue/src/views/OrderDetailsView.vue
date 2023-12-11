<template>
    <div>
        <order-card v-bind:order="order"></order-card>
    </div>
</template>

<script>
import stdCakeOrderService from '../services/StdCakeOrderService';
import OrderCard from '../components/OrderCard.vue';

export default {
    components: {
        OrderCard
    },
    data() {
        return {
            order: {}
        }
    },
    methods: {
        getOrder(id) {
            stdCakeOrderService.get(id)
              .then(response => {
                this.order = response.data;
              })
              .catch(error => {
                alert("Something went wrong.");
              });
        }
    },
    created() {
        this.getOrder(this.$route.params.orderId);
    }
}


</script>
