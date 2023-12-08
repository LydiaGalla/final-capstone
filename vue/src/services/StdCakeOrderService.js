import axios from 'axios';

export default {
    
  addStandardCakeOrder(order) {
    return axios.post('/standard-cake-orders', order);

  },

//   updateStandardCakeOrder(order) {
//     return axios.put(`/standard-cake-orders/${order.id}`, order);
//   }

}
