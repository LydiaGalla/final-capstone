<template>

    <div>
        
        <table id="cakeOrders">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Phone Number</th>
                    <th>Email</th>
                    <th>Order ID</th>
                    <th>Cake Details</th>
                    <th>Pickup Date</th>
                    <th>Status</th>
                    <th>Change Status</th>
                </tr>
            </thead>

            <tbody>
                <tr v-for="order in cake_orders" v-bind:key="order.order_id">
                    <td>{{ order.firstName }}</td>
                    <td>{{ order.lastName }}</td>
                    <td>{{ order.phoneNumber }}</td>
                    <td>{{ order.email }}</td>
                    <td>{{ order.order_id }}</td>
                    <td>{{ order.cake_details }}</td>
                    <td>{{ order.pickupDate }}</td>
                    <td>{{ order.status }}</td>
                    <td><button>Edit status</button></td>
                </tr>

            </tbody>
        
        </table>
        
    </div>

</template>



<script>


export default{
    data(){
        return{

        };
    

    },
    computed: {

    },
    methods: {

    }
}


</script>