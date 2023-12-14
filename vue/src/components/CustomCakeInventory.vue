<template>
<div class="CakeComponents">
    
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
                <td><button v-on:click.prevent="toggleAvailFlavor(flavor)" class="status-button">{{ flavor.available ? "Available" : "Mark Available"}}</button></td>
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
                <td><button v-on:click.prevent="toggleAvailFrosting(frosting)" class="status-button">{{ frosting.available ? "Available" : "Mark Available"}}</button></td>
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
                <td><button v-on:click.prevent="toggleAvailFilling(filling)" class="status-button">{{ filling.available ? "Available" : "Mark Available"}}</button></td>
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
              <td><button v-on:click.prevent="toggleAvailSize(size)" class="status-button">{{ size.available ? "Available" : "Mark Available"}}</button></td>
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
           
        // DONT DO THIS
        // toggleAvailability(option){
        //     if(option === 1){
        //         CustomCakeInventoryService.updateFilling(filling_id, filling.isAvailable)
        //     }
        //     else if(option === 2){
        //         CustomCakeInventoryService.updateFlavor(flavor_id, flavor.isAvailable)
        //     }
        //     else if(option === 3){
        //         CustomCakeInventoryService.updateFrosting(frosting_id, frosting.isAvailable)
        //     }
        //     else if(option === 4){
        //         CustomCakeInventoryService.updateSize(size_id, size.isAvailable)
        //     }
        // },

        toggleAvailFlavor(flavor){
            this.$store.commit('TOGGLE_FLAVOR', flavor);
            // flavor.isAvailable = !flavor.isAvailable; (happening in store because of above line)
            CustomCakeInventoryService.updateFlavor(flavor.flavorId, flavor.available);
        },
        toggleAvailFrosting(frosting){
            this.$store.commit('TOGGLE_FROSTING', frosting);
            // frosting.isAvailable = !frosting.isAvailable;
            CustomCakeInventoryService.updateFrosting(frosting.frostingId, frosting.isAvailable);

        },
        toggleAvailFilling(filling){
            this.$store.commit('TOGGLE_FILLING', filling);
            // filling.isAvailable = !filling.isAvailable;
            CustomCakeInventoryService.updateFilling(filling.fillingId, filling.isAvailable)

        },
        toggleAvailSize(size){
            this.$store.commit('TOGGLE_SIZE', size);
            // size.isAvailable = !size.isAvailable
            CustomCakeInventoryService.updateSize(size.sizeId, size.isAvailable)

        }

    },

    //created calls the service to get the lists
    created() {
            // assign the response data to the arrays for each one.
        CustomCakeInventoryService.getAllFillings().then(response => {this.fillings = response.data});
        CustomCakeInventoryService.getAllFlavors().then(response => {this.flavors = response.data})
        CustomCakeInventoryService.getAllFrostings().then(response => {this.frostings = response.data});
        CustomCakeInventoryService.getAllSizes().then(response => {this.sizes = response.data});

    }
}
</script>

<style scoped>
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
    border-radius: 25px;
    font-family: 'Teko', sans-serif;
    margin: 0px 10px 0px 10px;
    padding: 5px 15px 5px 15px;
    cursor: pointer;
}

.status-button:hover {
    background-color: #583b66;
    color: white;
}

td {
    width: 150px;
    height:40px;
}

table{
    align-items: center;
}
.CakeComponents {
     display: flex;
     flex-direction: column;
     justify-content: center;
     align-items: center;
}

</style>