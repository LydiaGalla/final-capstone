<template>
    <div>
        
        <form>
            
            <img src="Build_Custom_Cake_Text.png" alt="Build A Custom Cake">

            <h3> Cake Information</h3>
            <br>

            <label for="selectCakeFlavor">Select Cake Flavor </label>
            <select id="selectCakeFlavor" v-model="cakeFlavor">
                <option value="Almond">Almond Cake</option>
                <option value="Chocolate">Chocolate Cake</option>
                <option value="Marble">Marble Cake</option>
                <option value="Red Velvet">Red Velvet Cake</option>
                <option value="Yellow">Yellow Cake</option>
                <option value="White">White Cake</option>
            </select>
            <br>
            <br>
            <label for="selectFilling">Select Cake Filling </label>
            <select id="selectFilling" v-model="filling">
                <option value="Custard">Custard Filling</option>
                <option value="Fudge">Chocolate Fudge Filling</option>
                <option value="Raspberry Jam">Raspberry Jam Filling</option>
                <option value="Vanilla Buttercream">Vanilla Buttercream Filling</option>
            </select>
            <br>
            <br>
            <label for="selectFrostingFlavor">Select Frosting Flavor </label>
            <select id="selectFrostingFlavor" v-model="frostingFlavor">
                <option value="Vanilla Buttercream">Vanilla Buttercream</option>
                <option value="Cream Cheese">Cream Cheese Frosting</option>
                <option value="Chocolate Buttercream">Chocolate Buttercream</option>
            </select>
            <br>
            <br>
            <label for="selectStyle">Select Cake Style </label>
            <select id="selectStyle" v-model="style">
                <option value="Round">Round</option>
                <option value="Square">Square</option>
                <option value="Cupcake">Cupcake</option>
            </select>
            <br>
            <br>
            <label for="phone">Phone Number: </label>
            <input type="text" id="phone" v-model="phone">
            <label for="selectSize">Select Cake Size </label>
            <select id="selectSize" v-model="size">
                <option value="Small">Small</option>
                <option value="Large">Large</option>
                <option value="Cupcake">Single Cupcake</option>
                <option value="Bakers Dozen">Bakers Dozen, Cupcakes Only</option>
            </select>
            <br>
            <label for="phone">Phone Number: </label>
            <input type="text" id="phone" v-model="phone">
            <br>
            <router-link :to="{ name: 'cart'}">
                <button class="custom-cake-in-cart"> Add Custom Cake to Cart </button>
            </router-link>

        </form>

    </div>

</template>



<script>
    export default{
        data () {
            return{
                cakeFlavor:'',
                frostingFlavor:'',
                style:'',
                size:'',
                filling:''
            }
        },
        methods: {

        },
        computed:{

        },

    }


</script>



<style>
.custom-cake-in-cart {
    background-color: #583b66;
    color:#ffffff;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    font-size: large;
    width: 200px;
}

.custom-cake-in-cart:hover {
    background-color: #ffffff;
    color:#583b66;
}
</style>