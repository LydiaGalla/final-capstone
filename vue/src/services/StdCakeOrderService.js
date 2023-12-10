import axios from 'axios';

export default {

  list() {
    return axios.get('/cakeorder');
  },

  get(id) {
    return axios.get(`/cakeorder/${id}`);
  },

  addStandardCakeOrder(order) {
    return axios.post('/cakeorder/create', order);
  }

  

//   updateStandardCakeOrder(order) {
//     return axios.put(`/standard-cake-orders/${order.id}`, order);
//   }

}
