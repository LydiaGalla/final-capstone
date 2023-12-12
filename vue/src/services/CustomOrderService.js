import axios from 'axios';

export default {
    list() {
        return axios.get('/cakeorder');
    },

    get(id) {
        return axios.get(`/customcake/${id}`);

    },

    addCustomCakeOrder(order){
        return axios.post('/cakeorder/customcake', order);

    }
}