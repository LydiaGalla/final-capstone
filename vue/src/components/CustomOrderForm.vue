<template>
    <div>
        <!--Build form 
            cake type -- option 1, 2, 3, 4, 5, 6, 7 ... Customer info.. first, last, phone, pickup-->
        <form>
            <!--cake section-->
            <h1> Build A Custom Cake</h1>

            <h3> Cake Information</h3>

            <label for="selectCakeFlavor">Select Cake Flavor</label>
            <select id="selectCakeFlavor" v-model="cakeFlavor">
                <option>Vanilla</option>
                <option>Chocolate</option>
                <option>Funfetti</option>
            </select>

            <label for="selectIcingFlavor">Select Icing Flavor</label>
            <select id="selectIcingFlavor" v-model="icingFlavor">
                <option>Vanilla</option>
                <option>Chocolate</option>
                <option>Buttercream</option>
            </select>

            <label for="selectStyle">Select Cake Style</label>
            <select id="selectStyle" v-model="style">
                <option>Round</option>
                <option>Sheet</option>
                <option>Tiered</option>
            </select>

            <label for="selectSize">Select Cake Size</label>
            <select id="selectSize" v-model="size">
                <option>Small</option>
                <option>Large</option>
            </select>

            <label for="selectFilling">Select Cake Filling</label>
            <select id="selectFilling" v-model="filling">
                <option>Jam</option>
                <option>Icing</option>
            </select>

            <label for="customMessage">Add a Custom Message</label>
            <input type="text" id="customMessage">
            

            <!--customer section-->
            <h3>Customer Information</h3>
    
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" v-model="firstName">
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" v-model="lastName">
            <label for="phoneNumber">Phone Number: </label>
            <input type="text" id="phoneNumber" v-model="phoneNumber">
            <label for="email">E-mail: </label>
            <input type="text" id="email" v-model="email">

            <button type="submit" class="is-primary">Place Order</button>

        </form>
        <!---->

    </div>

</template>



<script>
    export default{
        data () {
            return{
                firstName: '',
                lastName: '',
                phoneNumber: '',
                email: '',
                cakeFlavor:'',
                icingFlavor:'',
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

</style>