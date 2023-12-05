<template>
    <div>
        <h2>Cart</h2>
        
        <router-link>Cake Details
            <std-cake-card></std-cake-card>
        </router-link>

    </div>
</template>

<script>

export default {
    props: ['cake']
}

</script>