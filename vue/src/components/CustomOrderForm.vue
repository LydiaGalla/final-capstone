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
                <option value="vanilla">Vanilla</option>
                <option value="chocolate">Chocolate</option>
                <option value="funfetti">Funfetti</option>
            </select>
            <br>
            <label for="selectIcingFlavor">Select Icing Flavor</label>
            <select id="selectIcingFlavor" v-model="icingFlavor">
                <option value="vanilla">Vanilla</option>
                <option value="chocolate">Chocolate</option>
                <option value="buttercream">Buttercream</option>
            </select>
            <br>
            <label for="selectStyle">Select Cake Style</label>
            <select id="selectStyle" v-model="style">
                <option value="round">Round</option>
                <option value="sheet">Sheet</option>
                <option value="tiered">Tiered</option>
            </select>
            <br>
            <label for="selectSize">Select Cake Size</label>
            <select id="selectSize" v-model="size">
                <option value="small">Small</option>
                <option value="large">Large</option>
                <option value="cupcake">Cupcakes</option>
            </select>
            <br>
            <label for="selectFilling">Select Cake Filling</label>
            <select id="selectFilling" v-model="filling">
                <option value="jam">Jam</option>
                <option value="vanilla buttercream">Vanilla Buttercream</option>
                <option value="fudge">Fudge</option>
                <option value="custard">Custard</option>
            </select>
            <br>
            <label for="customMessage">Add a Custom Message</label>
            <input type="text" id="customMessage">
            
            <br>
            <!--customer section-->
            <h3>Customer Information</h3>
            <br>
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" v-model="firstName">
            <br>
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" v-model="lastName">
            <br>
            <label for="phoneNumber">Phone Number: </label>
            <input type="text" id="phoneNumber" v-model="phoneNumber">
            <br>
            <label for="email">E-mail: </label>
            <input type="text" id="email" v-model="email">
            <br>
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