<template>
    <div>
        <form v-on:submit="addNewCake">
            <br>
            
            <label for="cakeName">Cake Name: </label>
            <input type="text" id="cakeName">

            <br>
            <br>

            <label for="description">Cake Description: </label>
            <br>
            <textarea name="description" id="description" cols="38" rows="10"></textarea>

            <br>
            <br>

            <label for="price">Cake Price: </label>
            <input type="text" id="price">

            <br>
            <br>
                <!--Does this work?-->
            <label for="image">Image (url): </label>
            <input type="url" id="image">

            <br>
            <br>

            <button class="add-cake"> Add Cake </button>

        </form>

    </div>
</template>

<script>
    export default {
        data() {
            return;
        },
        addNewCake: {
                cakeName: '',
                description: '',
                price: '',
        } 
    }

</script>

<style>
.add-cake {
    background-color: #583b66;
    color:#ffffff;
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