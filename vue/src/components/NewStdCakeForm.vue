<template>
    <div>
        <form v-on:submit.prevent="addNewCake">
            <br>
            
            <label for="cakeName">Cake Name (must not be the same as one of the existing standard cakes): </label>
            <input type="text" id="cakeName" v-model="createdStandardCake.cakeName">

            <br>
            <br>

            <label for="description">Cake Description (specify style, size, flavor, frosting, filling, and extras): </label>
            <br>
            <textarea name="description" id="description" cols="38" rows="10" v-model="createdStandardCake.description"></textarea>

            <br>
            <br>

            <label for="price">Cake Price: $ </label>
            <input type="text" id="price" v-model="createdStandardCake.price">

            <br>
            <br>
                <!--Does this work?-->
            <label for="image">Image (url): </label>
            <input type="url" id="image" v-model="createdStandardCake.img">
            <!-- create image url string property in backend and in database -->

            <br>
            <br>

            <button id="add-cake" class="add-cake"> Add Cake </button>

        </form>

    </div>
</template>

<script>
import stdCakeService from '../services/StdCakeService';

    export default {
        data() {
            return {
                createdStandardCake: {
                    cakeName: '',
                    description: '',
                    price: '',
                    img: ''
                }
            };
        },
        methods: {
            addNewCake(){
                if (!this.validateForm()) {
                    return;
                }

                stdCakeService
                  .addStandardCake(this.createdStandardCake)
                  .then(response => {
                    if (response.status === 201) {
                        this.$store.commit('ADD_STANDARD_CAKE', response.data)
                        this.$router.push({ name: 'inventory'});
                    }
                  })
            },

            validateForm() {
                return true;
                // TODO: write this method
            }
        }
    }

</script>

<style>
.add-cake {
    background-color: #583b66;
    color: white;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    font-size: large;
    width: 100px;
    
}

.add-cake:hover {
    background-color: #ffffff;
    color:#583b66;
}

</style>