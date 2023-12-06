<template>
    <div>
        <cart></cart>
        <nav class="actions">
            <router-link :to="{ name: 'order-info-form' }">Order Information</router-link>
        </nav>
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