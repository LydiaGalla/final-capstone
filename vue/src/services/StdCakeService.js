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
    },
    
    updateAvailability(id, isAvailable) {
        return axios.put(`/standardcake/${id}?isAvailable=${isAvailable}`);
    }
}
