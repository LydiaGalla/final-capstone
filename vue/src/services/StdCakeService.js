import axios from 'axios';

export default {
    list() {
        return axios.get('/standardcake');
    },

    get(id) {
        return axios.get(`/standardcake/${id}`);
    },

    addStandardCake(cake) {
        return axios.post(`/standardcake/create`);
    }

}