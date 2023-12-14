import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},

      customCakeInCart: null,

      cakes: [
        // {
        //   name: "Dead Pet",
        //   image: '/DeadPet',
        //   description: "“Sorry your cat died. LOL.” Round chocolate cake with custard filling and cream cheese frosting. Decorated with red buttercream napping cat, sorry that’ll be its last snooze.",
        //   price: 35,
        //   inCart: false
        // },
        // {
        //   name: "Ex Friend",
        //   image: '/ExFriend',
        //   description: "“You’re Dead to Us.” Round Chocolate Cake with Vanilla Buttercream and Chocolate Ganache coating. Topped with a bloody knife, perfect for that back stabber.",
        //   price: 35,
        //   inCart: false
        // },
        // {
        //   name: "Breakup",
        //   image: '/Breakup',
        //   description: "“I think we should see other people.” Round Red Velvet Cake with Fudge Filling and Cream Cheese Frosting. So delicious, your soon-to-be ex just might forget all about you.",
        //   price: 35,
        //   inCart: false
        // },
        // {
        //   name: "Robbed",
        //   image: '/Robbed',
        //   description: "“Sorry you were robbed.” Elaborately decorated Marble Rectangle Cake with colorful Vanilla Buttercream Frosting. If they didn’t catch the guy, at least now they have cake.",
        //   price: 40,
        //   inCart: false
        // },
        // {
        //   name: "Divorce",
        //   image: '/Divorce',
        //   description: "“Happy Divorce.” Three Tiered Round Cake with Red Velvet base, Chocolate layer, Vanilla top, and Raspberry Jam filling. Much more exciting than your failed marriage.",
        //   price: 50,
        //   inCart: false
        // },
        // {
        //   name: "Fired",
        //   image: '/Fired',
        //   description: "“You're Fired.” Classic Yellow cake with Vanilla Buttercream Frosting and Filling. Boring and unoriginal, just like the terrible employee you’re about to kick to the curb.",
        //   price: 35,
        //   inCart: false
        // },
        // {
        //   name: "Failed",
        //   image: '/Failed',
        //   description: "“We hope you fail.” Round Almond Cake with Vanilla Buttercream. Decorated with rainbow stripes and sprinkles to brighten the day of your favorite failure.",
        //   price: 35,
        //   inCart: false
        // },
        // {
        //   name: "Jail",
        //   image: '/Jail',
        //   description: "“Enjoy Prison!” Round Vanilla Cake with Chocolate Buttercream and Raspberry Jam filling decorated with prison stripes, it’ll match their orange jumpsuit soon enough. Enjoy this last taste of freedom.",
        //   price: 35,
        //   inCart: false
        // },
        // {
        //   name: "Sued",
        //   image: '/Sued',
        //   description: "“You've Been Served.” Round Red Velvet Cake with Fluffy Cream Cheese Frosting and simple red lettering. Much less surprising than being served with court papers.",
        //   price: 35,
        //   inCart: false
        // },
        // {
        //   name: "Wreck",
        //   image: '/Wreck',
        //   description: "“Sorry you're a terrible driver.” Rectangle White Sheet Cake with Fudge Filling and Vanilla Buttercream. It won’t pay for that ticket but it might ease the pain.",
        //   price: 40,
        //   inCart: false
        // }
        
      ],
      // orders: [
      //   {
      //     orderId: 1,
      //     firstName: "Lydia",
      //     lastName: "Gallagher",
      //     phoneNumber: "555-555-5555",
      //     dueDate: "1/1/2024",
      //     dueTime: "2:00pm",
      //     cakeDetails: "A cute cake",
      //     writing: "cute",
      //     total: 10,
      //     status: "Pending"
      //   },
      //   {
      //     orderId: 2,
      //     firstName: "Spencer",
      //     lastName: "Nicol",
      //     phoneNumber: "555-555-5555",
      //     dueDate: "1/1/2024",
      //     dueTime: "3:00pm",
      //     cakeDetails: "Another cute cake",
      //     writing: "cuter",
      //     total: 20,
      //     status: "Pending"
      //   }
      // ]
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
      SET_CAKES(state, cakes) {
        state.cakes = cakes;
      },
      SET_WRITING(state, writing) {
        state.writing = writing;
      },
      CHARGE_FEE(state, payload) {
        payload.cake.price += payload.value;
      },
      CLEAR_CART(state) {
        state.cakes.forEach(cake => {
          cake.inCart = false;
        })
      },
      TOGGLE_AVAILABLE(state, cake){
        cake.available = !cake.available;
      },
      TOGGLE_FLAVOR(state, flavor) {
        flavor.available = !flavor.available;
      },
      TOGGLE_FROSTING(state, frosting){
        frosting.available = !frosting.available;
      },
      TOGGLE_FILLING(state, filling){
        filling.available = !filling.available;
      },
      TOGGLE_SIZE(state, size){
        size.available = !size.available;
      },
      
      ADD_STANDARD_CAKE(state, cake) {
        state.cakes.push(cake)
        state.cakes.sort((cake1, cake2) => {
            if (cake1.cakeName < cake2.cakeName) {
              return -1
            }
            if (cake1.cakeName === cake2.cakeName) {
              return 0
            }
            return 1
        })
      },

      ADD_CUSTOM_CAKE_TO_CART(state, cake){
        state.customCakeInCart = cake
      }
      
    },
  });
  return store;
}
