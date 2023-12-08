<template>
    <div>
        <order-info-form v-bind:order="order"></order-info-form>
    </div>
</template>

<script>
import OrderInfoForm from '../components/OrderInfoForm.vue';

export default {
    components: {
        OrderInfoForm
    },
    data() {
        return {
            order: {
                id: 0,
                orderDate: new Date()
            }
        }
    }
}

</script>