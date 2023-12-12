import axios from "axios";

export default {
    getAllFlavors(){
        return axios.get('/customcake/flavors')
    },
    getAllFrostings(){
        return axios.get('/customcake/frostings')
    },
    getAllFillings(){
        return axios.get('/customcake/fillings')
    },
    getAllSizes(){
        return axios.get('/customcake/cakesize')
    },
    getAllStyles(){
        return axios.get('/customcake/cakestyle')
    },


    updateFlavor(id, isAvailable){
        return axios.put(`/customcake/flavors/${id}?isAvailable=${isAvailable}`)
    },
    updateFrosting(id, isAvailable){
        return axios.put(`/customcake/frostings/${id}?isAvailable=${isAvailable}`)
    },
    updateFilling(id, isAvailable){
        return axios.put(`/customcake/fillings/${id}?isAvailable=${isAvailable}`)
    },
    updateSize(id, isAvailable){
        return axios.put(`/customcake/sizes/${id}?isAvailable=${isAvailable}`)
    },
    updateStyle(id, isAvailable){
        return axios.put(``)
    }

}