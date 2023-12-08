import axios from 'axios';

export default {

  addStandardCakeOrder(order) {
    return axios.post('/cakeorder/create', order);

  },

//   updateStandardCakeOrder(order) {
//     return axios.put(`/standard-cake-orders/${order.id}`, order);
//   }

}
