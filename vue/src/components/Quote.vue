<template>
    <div>
        <header>
      <p>{{ randomQuote }}</p>
      <p>- {{ randomAuthor }}</p>
        </header>
    </div>
  </template>
  <script>
  import axios from 'axios';
  export default {
    data() {
      return {
        randomQuote: '',
      };
    },
    methods: {
      fetchRandomQuote() {
        const http = axios.create({ baseURL: 'https://api.api-ninjas.com/v1', headers: { 'X-Api-Key': 'nhJt+d9Aj9YoQbDr+ksKNA==lANgsP1MYhyxhO0f' }})
        http.get('/quotes?category=inspirational')
          .then(response => {
            this.randomQuote = response.data[0].quote;
            this.randomAuthor = response.data[0].author;
          })
          .catch(error => {
            console.error('Error fetching random quote:', error);
          });
      },
    },
    created() {
        this.fetchRandomQuote();
    }
  };
  </script>

<style scoped>

div {
  margin-top: 80px; 
}
</style>