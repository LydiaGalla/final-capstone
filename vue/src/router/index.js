import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import CartView from '@/views/CartView.vue';
import OrderInfoFormView from '../views/OrderInfoFormView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import EmployeeHomeView from '../views/EmployeeHomeView.vue';
import InventoryView from '../views/InventoryView.vue';
import EditInventoryView from '../views/EditInventoryView.vue';
import CustomOrderFormView from '../views/CustomOrderFormView.vue';
import OrderConfirmView from '../views/OrderConfirmedView.vue';
import AddNewStdCakeView from '../views/AddNewStdCakeView.vue';

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
  {
    path: '/employeehome/inventory/new-standard-cake',
    name: 'new standard cake',
    component: AddNewStdCakeView,
    meta: {
      requiresAuth: true
    }

  },
  {
    path: '/custom-order-form',
    name: 'custom order form',
    component: CustomOrderFormView,
    meta: {
      requiresAuth: false
    }
  },

  {
    path: '/employeehome/editinventory',
    name: 'edit-inventory',
    component: EditInventoryView,
    meta: {
      requiresAuth: false
    }
  },

  {
    path: '/employeehome/inventory',
    name: 'inventory',
    component: InventoryView,
    meta: {
      requiresAuth: false
    }
  },


   { 
    path: '/employeehome',
    name: 'employee-home',
    component: EmployeeHomeView,
    meta:{
      requiresAuth: false
    }
  },

  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: false
    }
  },

  {
    name: 'cart',
    path: '/cart',
    component: CartView,
    meta: {
      requiresAuth: false
    }
  },

  {
    name: 'order-info-form',
    path: '/orderInfoForm',
    component: OrderInfoFormView
  },
  {
    name: 'order-confirmation',
    path: '/orderInfoForm/orderConfirmation',
    component: OrderConfirmView
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  }
];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
