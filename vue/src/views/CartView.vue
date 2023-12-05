<template>
    <div>
        <cart></cart>
        <nav>
            <router-link>Cake Details View</router-link>
        </nav>
        <nav>
            <router-link>Customer Info Form View</router-link>
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