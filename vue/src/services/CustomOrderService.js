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

    },

    getFillings() {
        return Promise.resolve({ data: [
            {
                fillingId: 1,
                fillingName: 'Raspberry Jam' 
            },
            {
                fillingId: 2,
                fillingName: 'Fudge' 
            },
        ]});
    }
}