<template>
    <div class="new-standard-cake-form">
        <h3>Enter New Cake Details</h3>
        <form v-on:submit.prevent="addNewCake" class="form box">
            
            <label for="cakeName">Cake Name: </label>
            <br>
            <input class="input" type="text" id="cakeName" v-model="createdStandardCake.cakeName" placeholder="(must not be an existing standard cake name)">
            <br>

            <label for="description">Cake Description: </label>
            <br>
            <textarea class="textarea" placeholder="(specify style, size, flavor, frosting, filling, and extras)" 
                v-model="createdStandardCake.description"></textarea>
            
            <br>
            

            <label for="price">Cake Price: $ </label>
            <br>
            <input class="input" type="text" id="price" v-model="createdStandardCake.price">
            <br>
            
            <label for="image">Image (url): </label>
            <br>
            <input class="input" type="url" id="image" v-model="createdStandardCake.img">

            <br>
            <br>
            <div class="button-wrapper">
                <button id="add-cake" class="add-cake" type="submit"> Add Cake </button>
            </div>
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

<style scoped>

.button-wrapper{
    display: flex;
    justify-content: center;
}

.new-standard-cake-form{
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
}
.add-cake {
    margin: auto;
    background-color: #583b66;
    color: white;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    font-size: large;
    width: 100px;
    
    cursor: pointer;
}

.add-cake:hover {
    background-color: #ffffff00;
    color:#583b66;
    border: 1px solid #583b66;
}

.input {
    width: 350px;
}

.textarea {
    max-width: 350px;
}
</style>