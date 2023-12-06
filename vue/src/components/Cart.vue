<template>
    <h1>Hello</h1>
    <order-summary></order-summary>
    <order-info-form></order-info-form>
</template>

<script>
import OrderSummary from './OrderSummary.vue';
import OrderInfoForm from './OrderInfoForm.vue';

export default {
    components: {
        OrderSummary,
        OrderInfoForm
    }
}

</script>