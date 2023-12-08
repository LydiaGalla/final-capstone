import axios from 'axios';

export default {
    list() {
        return axios.get('/standard-cakes');
    },

    get(id) {
        return axios.get(`/standard-cakes/${id}`);
    }

}