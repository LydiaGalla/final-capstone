<template>
    <div class="order-card">
        <h2 class="order-id">Order # {{ editOrder.orderId }}</h2>
        <h3 class="order-name">{{ editOrder.firstName }} {{ editOrder.lastName }} </h3>
        <p class="order-phone">Phone: {{ editOrder.phone }}</p>
        <p class="order-date-time">Pickup: {{ editOrder.dueDate }} {{ editOrder.dueTime }} </p>
        <p class="order-details"> Cake Name: {{ cake.cakeName != null ? cake.cakeName : '(Custom Cake, see details below)' }} </p>
        <custom-order-card :cake="this.customCake" v-if="order.customCakeId != 0" />
        <!-- <p v-if="customCake.customCakeId != null" class="custom-order-details"> {{ customCake.cakeFlavor }}</p> -->
        <p class="order-writing">Requested cake text: {{ editOrder.writing }} </p>
        <p class="order-total">Total: ${{ editOrder.total }}</p>
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
            cake: {},
            customCake: {},
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

<style>
.order-card {
  text-align: center;
  background-color: white;
  width: 800px;
  height: 300px;
  margin: 20px;
  padding: 20px;
  border-radius: 10px;
}

.order-status {
    color: red;
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