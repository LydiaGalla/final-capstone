<template>
    <div>
        <img src="Build_Custom_Cake_Text.png" alt="Build A Custom Cake">
        <div class="custom-order-form-container">
            
            <form v-on:submit.prevent="submitForm" class="custom-order-form">
                
                

                <h3> Cake Information</h3>
                <br>

                <label for="selectCakeFlavor">Select Cake Flavor </label>
                <select id="selectCakeFlavor" v-model="createdCustomCake.cakeFlavorId">
                    <!-- <option value="Almond">Almond Cake</option>
                    <option value="Chocolate">Chocolate Cake</option>
                    <option value="Marble">Marble Cake</option>
                    <option value="Red Velvet">Red Velvet Cake</option>
                    <option value="Yellow">Yellow Cake</option>
                    <option value="White">White Cake</option> -->
                    <option v-for="flavor in availableCakeFlavors" :key="flavor.flavorId" :value="flavor.flavorId"> {{ flavor.flavorName }}</option>


                </select>
                <br>
                <br>
                <label for="selectFilling">Select Cake Filling </label>
                <select id="selectFilling" v-model="createdCustomCake.cakeFillingId">
                    <!-- <option value="Custard">Custard Filling</option> -->
                    <!-- <option value="Fudge">Chocolate Fudge Filling</option> -->
                    <!-- <option value="Raspberry Jam">Raspberry Jam Filling</option> -->
                    <!-- <option value="Vanilla Buttercream">Vanilla Buttercream Filling</option> -->
                    <option v-for="filling in availableCakeFillings" :key="filling.fillingId" :value="filling.fillingId"> {{ filling.fillingName }}</option>
                </select>
                <br>
                <br>
                <label for="selectFrostingFlavor">Select Frosting Flavor </label>
                <select id="selectFrostingFlavor" v-model="createdCustomCake.cakeFrostingId">
                    <!-- <option value="Vanilla Buttercream">Vanilla Buttercream</option>
                    <option value="Cream Cheese">Cream Cheese Frosting</option>
                    <option value="Chocolate Buttercream">Chocolate Buttercream</option> -->
                    <option v-for="frosting in availableCakeFrostings" :key="frosting.frostingId" :value="frosting.frostingId"> {{ frosting.frostingName }}</option>

                </select>
                <br>
                <br>
                <label for="selectStyle">Select Cake Style </label>
                <select id="selectStyle" v-model="createdCustomCake.cakeStyleId">
                    <!-- <option value="Round">Round</option>
                    <option value="Square">Square</option>
                    <option value="Cupcake">Cupcake</option> -->
                    <option v-for="style in availableCakeStyles" :key="style.styleId" :value="style.styleId"> {{ style.styleName }}</option>

                </select>
                <br>
                <br>
                <label for="selectSize">Select Cake Size </label>
                <select id="selectSize" v-model="createdCustomCake.cakeSizeId">
                    <!-- <option value="Small">Small</option>
                    <option value="Large">Large</option>
                    <option value="Cupcake">Single Cupcake</option>
                    <option value="Bakers Dozen">Bakers Dozen, Cupcakes Only</option> -->
                    <option v-for="size in validCakeSizes" :key="size.sizeId" :value="size.sizeId"> {{ size.sizeName }}</option>

                </select>
                <br>
                <br>
                
                <button class="custom-cake-in-cart" > Add Custom Cake to Cart </button>
                

            </form>

        </div>
    </div>

</template>



<script>
import CustomOrderService from '../services/CustomOrderService';
import CustomCakeInventoryService from '../services/CustomCakeInventoryService';

    export default{
        computed: {
            validCakeSizes() {
                return this.availableCakeSizes.filter((cakeSize) => {
                    if (!this.createdCustomCake.cakeStyleId) {
                        return false;
                    }

                    const cakeStyleText = this.availableCakeStyles.find(style => style.styleId === this.createdCustomCake.cakeStyleId).styleName;

                    if (cakeStyleText === 'Cupcake') {
                        return (cakeSize.sizeName === 'Cupcake' || cakeSize.sizeName === "Bakers Dozen");
                    }
                    if (cakeStyleText === 'Round' || cakeStyleText === 'Square') {
                        return (cakeSize.sizeName === 'Small' || cakeSize.sizeName === 'Large');
                    }

                    return false;
                })
            }
        },

        created() {
            // TODO: change to CustomCakeService
            CustomCakeInventoryService
                .getAllFlavors()
                .then(response => {
                    this.availableCakeFlavors = response.data.filter(flavor => flavor.available === true);
                });

            CustomCakeInventoryService
                .getAllFillings()
                .then(response => {
                    this.availableCakeFillings = response.data.filter(filling => filling.available === true);
                });

            CustomCakeInventoryService
                .getAllFrostings()
                .then(response => {
                    this.availableCakeFrostings = response.data.filter(frosting => frosting.available === true);
                });    

            CustomCakeInventoryService
                .getAllStyles()
                .then(response => {
                    this.availableCakeStyles = response.data.filter(style => style.available === true);
                });
            
            CustomCakeInventoryService
                .getAllSizes()
                .then(response => {
                    this.availableCakeSizes = response.data.filter(size => size.available === true);
                });    
        },
        
        data () {
            return{

                availableCakeFlavors: [],
                availableCakeFillings: [],
                availableCakeFrostings: [],
                availableCakeStyles: [],
                availableCakeSizes: [],

                createdCustomCake: {
                    cakeFlavorId:'',
                    cakeFillingId:'',
                    cakeFrostingId:'',
                    cakeStyleId:'',
                    cakeSizeId:''
                }
            }
        },
        methods: {
            getPriceBySize(size) {
                if (size == 'Small') {
                    return 35;
                } else if (size == 'Large') {
                    return 50;
                } else if (size == 'Cupcake') {
                    return 4;
                } else if (size == 'Bakers Dozen') {
                    return 48;
                }        
            },

            submitForm(){
                if (!this.validateForm()) {
                    return;

                }

            CustomOrderService
                .addCustomCakeOrder(this.createdCustomCake)
                .then(response => {
                        
                    const cakeFlavorText = this.availableCakeFlavors.find(flavor => flavor.flavorId === this.createdCustomCake.cakeFlavorId).flavorName;
                    const cakeFillingText = this.availableCakeFillings.find(filling => filling.fillingId === this.createdCustomCake.cakeFillingId).fillingName;
                    const cakeFrostingText = this.availableCakeFrostings.find(frosting => frosting.frostingId === this.createdCustomCake.cakeFrostingId).frostingName;
                    const cakeStyleText = this.availableCakeStyles.find(style => style.styleId === this.createdCustomCake.cakeStyleId).styleName;
                    const cakeSizeText = this.availableCakeSizes.find(size => size.sizeId === this.createdCustomCake.cakeSizeId).sizeName;


                    const customCakeWithText = {
                        cakeFlavor: cakeFlavorText,
                        cakeFilling: cakeFillingText,
                        cakeFrosting: cakeFrostingText,
                        cakeStyle: cakeStyleText,
                        cakeSize: cakeSizeText,
                        cakePrice: this.getPriceBySize(cakeSizeText),
                        customCakeId: response.data.customCakeId
                    };

                    this.$store.commit('ADD_CUSTOM_CAKE_TO_CART', customCakeWithText)
                    this.$router.push({ name: 'cart'});
                })
            },

            validateForm() {
                return true;
                // TODO: write this method
            },
        }

    }


</script>



<style>

 /* .custom-order-form {
    display: flex;
    justify-content: center;
    align-items: center;
} */

 .custom-order-form-container {
    display: flex;
    justify-content: center;
    align-items: center;
}  

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