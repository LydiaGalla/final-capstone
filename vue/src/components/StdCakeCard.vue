<template>
    <div class="card">
        <h2 class="cake-name">{{ cake.name }}</h2>
        <img v-if="cake.name" v-bind:src="cake.image + 'Cake.jpg'">
        <h3 class="cake-price">{{ cake.price }}</h3>
        <p class="description">{{ cake.description }}</p>
        <button>Add to Cart</button>

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
  border: 1px solid #ccc;
  border-radius: 8px;
  text-align: center;
  width: 300px;
  height: 400px;
  margin: 20px;
  padding: 20px;
}

.card .cake-name {
  font-size: 1.4rem;
  margin-bottom: 5px;
}

.card .cake-img {
  max-width: 100%;
  height: auto;
  border-radius: 8px;
  margin-bottom: 10px;
}

.card .cake-price {
  font-size: 1rem;
}

.card .cake-description {
    color: #555;
}

</style>