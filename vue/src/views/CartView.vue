<template>
    <div>
        <cart></cart>
        <div>
            <router-link :to="{ name: 'order-info-form' }">Checkout</router-link>
        </div>
    </div>
</template>

<script>
import Cart from '@/components/Cart.vue'

export default {
    components: {
        Cart
    }
}


</script>