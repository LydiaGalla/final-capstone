import axios from 'axios';

export default {
    list() {
        return axios.get('/standardcake');
    },

    get(id) {
        return axios.get(`/standardcake/${id}`);
    },

    updateAvailability(id, isAvailable) {
        return axios.put(`/standardcake/${id}?isAvailable=${isAvailable}`);
    }

}