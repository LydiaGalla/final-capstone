<template>
    <div class="order-card">
        <h2 class="order-id">Order # {{ editOrder.orderId }}</h2>
        <h3 class="order-name">{{ editOrder.firstName }} {{ editOrder.lastName }} </h3>
        <p class="order-phone"><span class="bold">Phone:</span> {{ editOrder.phone }}</p>
        <p class="order-date-time"><span class="bold">Pickup: </span>{{ editOrder.dueDate }} {{ editOrder.dueTime }} </p>
        <p class="order-details" v-if="cake || customCake"> <span class="bold">Cake Name: </span>{{ cake != null ? cake.cakeName : '(Custom Cake, see details below)' }} </p>
        <div class="custom-order-information">
             <custom-order-card :cake="customCake" v-if="customCake != null" from-order-card="true" />
        </div>
        <div class="images">
            <img class="cake-img" v-if="cake && cake.img" v-bind:src="cake.img">
            <img class="cake-img" v-else-if="cake && cake.standardCakeId != 0" v-bind:src="'/' + cake.cakeName.replace(' ', '') + 'Cake.jpg'">
        </div>
        <p class="order-writing"><span class="bold">Requested cake text: </span>{{ editOrder.writing }} </p>
        <p class="order-total"> <span class="bold">Total: </span> ${{ editOrder.total }}</p>
        <p :class="{ 'order-status': editOrder.status === 'Pending' }"> {{ editOrder.status }}</p>
        <select class="status" id="status" v-model="status">
            <option value="">&nbsp; &nbsp;Edit Status</option>
            <option value="Pending">&nbsp; &nbsp;Pending</option>
            <option value="Ready">&nbsp; &nbsp;Ready</option>
            <option value="Completed">&nbsp; &nbsp;Completed</option>
            <option value="Cancelled">&nbsp; &nbsp;Cancelled</option>
        </select>

        <button v-on:click.prevent="updateOrderStatus()" :disabled="status ===''" class="status"> Save </button>


    </div>
</template>

<script>
import stdCakeService from '../services/StdCakeService';
import stdCakeOrderService from '../services/StdCakeOrderService';
import CustomCakeInventoryService from '../services/CustomCakeInventoryService';
import CustomOrderService from '../services/CustomOrderService';
import CustomOrderCard from '../components/CustomOrderCard.vue'

export default{
    components: {
        CustomOrderCard
    },

    props: {
        order: {
            type: Object,
            required: true
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

    data() {
        return {
            cake: null,
            customCake: null,
            editOrder: { ...this.order},
            status: '',

            availableCakeFlavors: [],
            availableCakeFillings: [],
            availableCakeFrostings: [],
            availableCakeStyles: [],
            availableCakeSizes: []
        }
    },

    methods: {
        getCake(id) {
            stdCakeService.get(id)
              .then(response => {
                this.cake = response.data;
              })
              .catch(error => {
                //alert("Something went wrong.");
              });
        },
        getCustomCakeCake(id) {
            CustomOrderService
              .get(id)
              .then(response => {
                let newCake = response.data;
                    
                    const cakeFlavorText = this.availableCakeFlavors.find(flavor => flavor.flavorId === newCake.cakeFlavorId).flavorName;
                    const cakeFillingText = this.availableCakeFillings.find(filling => filling.fillingId === newCake.cakeFillingId).fillingName;
                    const cakeFrostingText = this.availableCakeFrostings.find(frosting => frosting.frostingId === newCake.cakeFrostingId).frostingName;
                    const cakeStyleText = this.availableCakeStyles.find(style => style.styleId === newCake.cakeStyleId).styleName;
                    const cakeSizeText = this.availableCakeSizes.find(size => size.sizeId === newCake.cakeSizeId).sizeName;

                    const customCakeWithText = {
                        cakeFlavor: cakeFlavorText,
                        cakeFilling: cakeFillingText,
                        cakeFrosting: cakeFrostingText,
                        cakeStyle: cakeStyleText,
                        cakeSize: cakeSizeText,
                        customCakeId: newCake.customCakeId
                    };
                    console.log(customCakeWithText);
                    this.customCake = customCakeWithText;

              })
        },
        updateOrderStatus() {
            stdCakeOrderService
              .updateStatus(this.status, this.order.orderId)
              .then(() => {
                this.editOrder.status = this.status
              })
        }
    },
    computed: {
        currCustomCake() {
            const currCustomCakeId = this.$route.params.customCakeId;
            return this.$store.state.customCakeInCart
        }
    },
    mounted() {
        if(this.order.standardCakeId) {
            this.getCake(this.order.standardCakeId);
        } else if(this.order.customCakeId) {
            this.getCustomCakeCake(this.order.customCakeId);
        }
    }
    



}

</script>

<style scoped>
.bold {
    font-weight: 600;
}

.custom-order-information {
    display: flex;
    justify-content: center;
    /* height: 155px;  */
    margin: 0px;
    padding: 0px;
    
}
.order-card {
  text-align: center;
  background-color: white;
  width: 800px;
  height: 500px;
  margin: 20px;
  padding: 20px;
  border-radius: 10px;
}

.order-status {
    color: red;
}

.cake-img {  
  max-width: 20%;
  height: auto;
  border-radius: 8px;
  margin-bottom: 10px;
}

.status {
    background-color: #d1b8dd;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    width: 50x;
}

.status:hover {
    background-color: white;
    color: #583b66;
}

</style>