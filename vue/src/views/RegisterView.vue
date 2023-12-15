<template>

  <div>
    <img src="Create_Account.png" alt="Create Account">
        <div role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
    <div id="register" class="text-center">
      <h3>For Employees Only</h3>
      <form v-on:submit.prevent="register">
        
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
        <div class="form-input-group">
          <label for="confirmPassword">Confirm Password</label>
          <br>
          <input class="input" type="password" id="confirmPassword" v-model="user.confirmPassword" required />
        </div>
        <button class="submit" type="submit">Create Account</button>
        <p><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
      </form>
    </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
h3{
  display: flex;
  justify-content: center;
}
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
.submit {
  background-color: #583b66;
    color:#ffffff;
    border: none;
    border-radius: 20px;
    font-family: 'Teko', sans-serif;
    font-size: large;
    width: 200x;
  display: flex;
  margin: auto;
  margin-bottom: 30px;
}

.submit:hover {
  background-color: #ffffff;
    color:#583b66;
}

#register{
  display:flex;
  justify-content: center;
  margin: auto;
  padding-top: 50px;
  flex-direction: column;
  max-width: 350px;
}
</style>
