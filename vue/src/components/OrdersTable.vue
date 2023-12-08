<template>

    <div>
        
        <table id="cakeOrders">
            <thead>
                <tr>
                    <th>First Name </th>
                    <th>Last Name </th>
                    <th>Phone Number </th>
                    <th>Email</th>
                    <th>Order ID</th>
                    <th>Cake Details</th>
                    <th>Pickup Date</th>
                    <th>Status</th>
                    <th>Button</th>
                </tr>
            </thead>

            <tbody>
                <tr>
                    <td>Laura</td>
                    <td>Daehler</td>
                    <td>555-555-5555</td>
                    <td>laura@laura.com</td>
                    <td>11111</td>
                    <td>Chocolate cake, chocolate icing....</td>
                    <td>1/1/2024</td>
                    <td>Pending</td>
                    <td><input type="button" value="Mark As Complete"/></td>
                </tr>
                <tr>
                    <td>Lydia</td>
                    <td>Gallagher</td>
                    <td>555-555-5555</td>
                    <td>lydia@lydia.com</td>
                    <td>22222</td>
                    <td>Chocolate cake, chocolate icing....</td>
                    <td>1/1/2024</td>
                    <td id="status">Pending</td>
                    <td><input type="button" value="Mark As Complete" id="Incomplete"/></td>
                </tr>
                <tr>
                    <td>John</td>
                    <td>Sparks</td>
                    <td>555-555-5555</td>
                    <td>John@John.com</td>
                    <td>22222</td>
                    <td>Chocolate cake, chocolate icing....</td>
                    <td>1/1/2024</td>
                    <td id="status">Pending</td>
                    <td><input type="button" value="Mark As Complete" id="Incomplete"/></td>
                </tr>
                <tr>
                    <td>Ryan</td>
                    <td>Counasse</td>
                    <td>555-555-5555</td>
                    <td>Ryan@Ryan.com</td>
                    <td>22222</td>
                    <td>Chocolate cake, chocolate icing....</td>
                    <td>1/1/2024</td>
                    <td id="status">Pending</td>
                    <td><input type="button" value="Mark As Complete" id="Incomplete"/></td>
                </tr>
                <tr>
                    <td>Spencer</td>
                    <td>Nicol</td>
                    <td>555-555-5555</td>
                    <td>spencer@spencer.com</td>
                    <td>22222</td>
                    <td>Chocolate cake, chocolate icing....</td>
                    <td>1/1/2024</td>
                    <td id="status">Pending</td>
                    <td><input type="button" value="Mark As Complete" id="Incomplete"/></td>
                </tr>
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

<style>
th {
  text-transform: uppercase;
  padding: 15px;
}
td {
  padding: 10px;
}
#Incomplete {
    background-color: gray;
    border-radius: 10px;
    border-color: white;
    color: white;
    padding: 5px;

} #status{
    color: red
}
</style>