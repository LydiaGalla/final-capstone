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
                <td><input type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Chocolate</td>
                <td><input type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Marble</td>
                <td><input type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Red Velvet</td>
                <td><input type="button" value="Available"></td>
            </tr>
            <tr>
                <td>White</td>
                <td><input type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Yellow</td>
                <td><input type="button" value="Available"></td>
            </tr>
        </tbody>
    </table>

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
                <td><input type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Cream Cheese Frosting </td>
                <td><input type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Vanilla Buttercream</td>
                <td><input type="button" value="Available"></td>
            </tr>
        </tbody>
    </table>

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
                <td><input type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Fudge</td>
                <td><input type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Raspberry Jam</td>
                <td><input type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Vanilla Buttercream</td>
                <td><input type="button" value="Available"></td>
            </tr>
        </tbody>
    </table>

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
                <td><input type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Large </td>
                <td><input type="button" value="Available"></td>
            </tr>
            <tr>
                <td>Cupcake </td>
                <td><input type="button" value="Available"></td>
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
</style>