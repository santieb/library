<template>
  <div class="py-4">
    <div class="flex space-x-2">
      <button @click="filterBooks('')" :class="{
        'bg-blue-500 text-white': selectedCategory === '',
        'bg-gray-300 text-gray-700': selectedCategory !== ''
      }" class="px-4 py-2 rounded-full">
        Todos
      </button>
      <button v-for="category in categories" :key="category" @click="filterBooks(category)" :class="{
        'bg-blue-500 text-white': selectedCategory === category,
        'bg-gray-300 text-gray-700': selectedCategory !== category
      }" class="px-4 py-2 rounded-full hover:bg-blue-600 hover:text-white transition-all">
        {{ category }}
      </button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    selectedCategory: String, // Puedes pasar la categoría seleccionada como prop
    categories: Array, // Puedes pasar la lista de categorías como prop
  },
  methods: {
    filterBooks(category) {
      this.$emit('filter', category); // Emite un evento para aplicar el filtro
    },
  },
};
</script>