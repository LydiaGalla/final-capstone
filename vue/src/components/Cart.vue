<template>
    <div>
        <router-link>Cake Details
            <std-cake-card></std-cake-card>
        </router-link>
    </div>
</template>

<script>
import StdCakeCard from '../components/StdCakeCard.vue';

export default {
    components: {
        StdCakeCard
    }
}

</script>