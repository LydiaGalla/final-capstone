<template>
    <div class="card">
        <h2 class="cake-name">{{ cake.name }}</h2>
        <img src="" alt="">
        <h3 class="cake-price">{{ cake.price }}</h3>
        <p class="description">{{ cake.description }}</p>
        <button v-if="enableAdd">Add to Cart</button>

    </div>
</template>

<script>

export default {
    props: ['cake'],

    methods: {

    }
}

</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
}

.card.read {
  background-color: lightgray;
}

.card .book-title {
  font-size: 1.5rem;
}

.card .book-author {
  font-size: 1rem;
}
</style>