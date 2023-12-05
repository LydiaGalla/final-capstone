import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},

      cakes: [
        {
          name: "Dead Cat",
          description: "“Sorry your cat died. LOL” Round Chocolate Cake with Custard Filling and Cream Cheese Frosting. Decorated with Red Buttercream Napping Cat, sorry that’ll be its last snooze.",
          price: 50
        },
        {
          name: "Ex Friend",
          description: "“You’re Dead to Us” Round Chocolate Cake with Vanilla Buttercream and Chocolate Ganache coating. Topped with a bloody knife, perfect for that back stabber.",
          price: 50
        }
      ]
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      }
    },
  });
  return store;
}
