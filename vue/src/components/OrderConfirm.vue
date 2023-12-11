<template>
    <div class="order-confirmation">
      <div class="confirmation-card">
        <h2>Thank you for your order!</h2>
        <p>You'll receive text updates on your cake's status, and when it's ready to be picked up! </p>
        <button @click="goHomePage">Back to Home</button>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'OrderConfirmation',
    props: {
    quote: Object,
  },
    methods: {
      goHomePage() {
        this.$router.push({ name: 'home' });
        console.log("Navigate to home page");
      },
    },
  };
  </script>
  
  <style scoped>
  .order-confirmation {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
  }
  
  .confirmation-card {
    background: #fff;
    padding: 20px;
    border-radius: 10px;
    text-align: center;
  }
  </style>