<template>
    <div>
        <cake-details></cake-details>\
        <nav>
            <router-link>Choose Text</router-link>
        </nav>
    </div>
</template>

<script>
import CakeDetails from '../components/CakeDetails.vue';

export default {
    components: {
        CakeDetails
    },

    computed: {

    }
}

</script>