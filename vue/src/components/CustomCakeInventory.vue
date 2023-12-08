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
            <tr>
                <td>Almond </td>
                <td><input class="status-button" type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Chocolate</td>
                <td><input class="status-button" type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Marble</td>
                <td><input class="status-button" type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Red Velvet</td>
                <td><input class="status-button" type="button" value="Available"></td>
            </tr>
            <tr>
                <td>White</td>
                <td><input class="status-button" type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Yellow</td>
                <td><input class="status-button" type="button" value="Available"></td>
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
            <tr>
                <td>Chocolate Buttercream </td>
                <td><input class="status-button" type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Cream Cheese Frosting </td>
                <td><input class="status-button" type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Vanilla Buttercream</td>
                <td><input class="status-button" type="button" value="Available"></td>
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
            <tr>
                <td>Custard </td>
                <td><input class="status-button" type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Fudge</td>
                <td><input class="status-button" type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Raspberry Jam</td>
                <td><input class="status-button" type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Vanilla Buttercream</td>
                <td><input class="status-button" type="button" value="Available"></td>
            </tr>
        </tbody>
    </table>

    <br>

    <table>
        <thead>
            <tr>
                <th>Cake Sizes</th>  
                <th>Availability</th>
            </tr>
        </thead>

        <tbody>
            <tr>
                <td>Small </td>
                <td><input class="status-button" type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Large </td>
                <td><input class="status-button" type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Cupcake </td>
                <td><input class="status-button" type="button" value="Available" v-on:click="changeAvailability"></td>
            </tr>
        </tbody>
    </table>
    
</div>

</template>

<script>
export default{
    data(){
        return{

        }
    },
    methods:{
        changeAvailability(){
            
        }
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