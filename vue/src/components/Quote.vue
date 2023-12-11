<template>
  <div>
    <h1>Random Quote</h1>
    <p>{{ fetchQuote() }}</p>
    <p>- {{ fetchQuote() }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      quote: {},
    };
  },
  mounted() {
    this.fetchQuote();
  },
  methods: {
    async fetchQuote() {
      try {
        const response = await fetch("https://zenquotes.io/api/quotes/");
        const data = await response.json();
        this.quote = data[0];
      } catch (error) {
        console.error("Error fetching quote:", error);
      }
    },
  },
};
</script>
