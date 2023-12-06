<template>
    <div>

        <!-- figure out -->
        
        <!-- <nav>
            <router-link>Cake Details View</router-link>
        </nav> -->
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