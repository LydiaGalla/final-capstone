<template>
    <div>
        <cart></cart>
        <nav>
            <router-link>Cake Details View</router-link>
        </nav>
        <nav class="actions">
            <router-link :to="{ name: 'customer-info-form' }">Order Information</router-link>
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