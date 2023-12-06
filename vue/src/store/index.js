import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},

      cakes: [
        {
          name: "Dead Pet",
          image: '/DeadPet',
          description: "“Sorry your cat died. LOL” Round Chocolate Cake with Custard Filling and Cream Cheese Frosting. Decorated with Red Buttercream Napping Cat, sorry that’ll be its last snooze.",
          price: 35,
          inCart: false
        },
        {
          name: "Ex Friend",
          image: '/ExFriend',
          description: "“You’re Dead to Us” Round Chocolate Cake with Vanilla Buttercream and Chocolate Ganache coating. Topped with a bloody knife, perfect for that back stabber.",
          price: 35
        },
        {
          name: "Breakup",
          image: '/Breakup',
          description: "“I think we should see other people” Round Red Velvet Cake with Fudge Filling and Cream Cheese Frosting. So delicious, your soon-to-be ex just might forget all about you.",
          price: 35
        },
        {
          name: "Robbed",
          image: '/Robbed',
          description: "“Sorry you were robbed” Elaborately decorated Marble Rectangle Cake with colorful Vanilla Buttercream Frosting. If they didn’t catch the guy, at least now they have cake.",
          price: 35
        },
        {
          name: "Divorce",
          image: '/Divorce',
          description: "“Happy Divorce” Three Tiered Round Cake with Red Velvet base, Chocolate layer, Vanilla top, and Raspberry Jam filling. Much more exciting than your failed marriage.",
          price: 35
        },
        {
          name: "Fired",
          image: '/Fired',
          description: "“You're Fired” Classic Yellow cake with Vanilla Buttercream Frosting and Filling. Boring and unoriginal, just like the terrible employee you’re about to kick to the curb.",
          price: 35
        },
        {
          name: "Failed",
          image: '/Failed',
          description: "“We hope you fail” Round Almond Cake with Vanilla Buttercream. Decorated with rainbow stripes and sprinkles to brighten the day of your favorite failure.",
          price: 35
        },
        {
          name: "Jail",
          image: '/Jail',
          description: "“Enjoy Prison!” Round Vanilla Cake with Chocolate Buttercream and Raspberry Jam filling decorated with prison stripes, it’ll match their orange jumpsuit soon enough. Enjoy this last taste of freedom.",
          price: 35
        },
        {
          name: "Sued",
          image: '/Sued',
          description: "“Sorry you're getting sued.” Round Red Velvet Cake with Fluffy Cream Cheese Frosting and simple red lettering. Much less surprising than being served with court papers.",
          price: 35
        },
        {
          name: "Wreck",
          image: '/Wreck',
          description: "“Sorry you're a terrible driver.” Rectangle White Sheet Cake with Fudge Filling and Vanilla Buttercream. It won’t pay for that ticket but it might ease the pain.",
          price: 35
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
      },
      SET_IN_CART(state, payload) {
        payload.cake.inCart = payload.value;
      },
      SAVE_CAKE(state, cake) {
        state.cakes.push(cake);
      }
    },
  });
  return store;
}
