<template>
  <div id="login">
    <img src="Please_Sign_In_Text.png" alt="Please Sign In">
      <div role="alert" v-if="invalidCredentials">Invalid username and password!
      </div>
        <div id="form_container">
          <h3>Employee Login: </h3>
        <form v-on:submit.prevent="login">
          <div role="alert" v-if="this.$route.query.registration">
            Thank you for registering, please sign in.
          </div>
          <div class="form-input-group">
            <label for="username">Username</label>
            <br>
            <input class="input" type="text" id="username" v-model="user.username" required autofocus />
          </div>
          <div class="form-input-group">
            <label for="password">Password</label>
            <br>
            <input class="input" type="password" id="password" v-model="user.password" required />
          </div>
          
          <button id="submit" type="submit">Sign in</button>
          <br>
          <p><router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
        </form>
      </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/employeehome");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
h3 {
  display: flex;
  justify-content: center;
}
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

#form_container{
  max-width: 350px;
  padding-top: 50px;
  display: flex;
  margin: auto;
  justify-content: center;
  flex-direction: column;
  
}

#submit{
    display: flex;
    background-color: #583b66;
    color: white;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    font-size: large;
    width: 200x;
    margin: auto;
}

#submit:hover {
    background-color: white;
    color: #583b66;
}

</style>