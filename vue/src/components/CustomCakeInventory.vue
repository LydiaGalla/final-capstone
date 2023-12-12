<template>
<div>
    <h3>Ingredients</h3>
    <table>
        <thead>
            <tr>
                <th>Cake Flavors</th>  
                <th>Availability</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="flavor in flavors" :key="flavor.flavorName">
                <td>{{ flavor.flavorName }} </td>
                <td><button  value="CHANGE THIS">{{ flavor.isAvailable ? "Mark Unavailable" : "Mark Available"}}</button></td>
            </tr>
        </tbody>
    </table>
    <br>

    <table>
        <thead>
            <tr>
                <th>Cake Frostings</th>  
                <th>Availability</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="frosting in frostings" :key="frosting.frostingName">
                <td>{{ frosting.frostingName }} </td>
                <td><button v-on:click.prevent="toggleAvailability(frosting.frostingName)" value="CHANGE THIS">{{ frosting.isAvailable ? "Mark Unavailable" : "Mark Available"}}</button></td>
            </tr>
        </tbody>
    </table>
    <br>

    <table>
        <thead>
            <tr>
                <th>Cake Filling</th>  
                <th>Availability</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="filling in fillings" :key="filling.fillingName" >
                <td>{{ filling.fillingName }} </td>
                <td><button v-on:click.prevent="toggleAvailability(filling.fillingName)" class="status-button" value="CHANGE THIS">{{ filling.isAvailable ? "Mark Unavailable" : "Mark Available"}}</button></td>
            </tr>
        </tbody>
    </table>
    <br>

    <table>
        <thead>
            <tr>
                <th>Cake Sizes - </th>  
                <th> Availability</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="size in sizes" :key="size.sizeName">
                <td>{{ size.sizeName }} </td>
              <!--click event calls the method to toggle the  availability -->  
              <td><button v-on:click.prevent="toggleAvailability(size.sizeName)" value="CHANGE THIS">{{ size.isAvailable ? "Mark Unavailable" : "Mark Available"}}</button></td>
            </tr>
        </tbody>
    </table>
</div>
</template>



<script>
import CustomCakeInventoryService from '../services/CustomCakeInventoryService';

export default{
    data(){
        return{
            sizes: [],
            flavors: [],
            fillings: [],
            frostings: []
        }
    },
    methods:{
        toggleAvailability(option){
            if(option === 1){
                CustomCakeInventoryService.updateFilling()
            }
            else if(option === 2){
                CustomCakeInventoryService.updateFlavor()
            }
            else if(option === 3){
                CustomCakeInventoryService.updateFrosting()
            }
            else if(option === 4){
                CustomCakeInventoryService.updateSize()
            }
        }
    },
    created() {
            //created calls the service to get the list
            // assign the response data to the arrays for each one.
       this.sizes = CustomCakeInventoryService.getAllFillings();
       this.flavors = CustomCakeInventoryService.getAllFlavors();
       this.fillings = CustomCakeInventoryService.getAllFillings();
       this.frostings = CustomCakeInventoryService.getAllFrostings();

    }
}
</script>

<style>
h3 {
    font-family: 'Teko', sans-serif;
    font-size: 2rem;
}

th {
    font-family: 'Teko', sans-serif;
    font-size: 1rem;  
    color: #583b66; 
}

.status-button {
    background-color: white;
    border: none;
    border-radius: 10px;
    font-family: 'Teko', sans-serif;
    width: 50x;
    margin-left: 15px;
}

.status-button:hover {
    background-color: #583b66;
    color: white;
}
</style>