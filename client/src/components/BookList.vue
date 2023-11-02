<template>
  <main>
    <div class="py-4">
      <div class="categories flex space-x-2">
        <button @click="filterBooks('')" :class="{ 'bg-blue-500 text-white': selectedCategory === '' }">
          Todos
        </button>
        <button v-for="category in categories" :key="category" @click="filterBooks(category)"
          :class="{ 'bg-blue-500 text-white': selectedCategory === category, 'bg-gray-300': selectedCategory !== category }"
          class="hover:bg-blue-600 hover:text-white transition-all">
          {{ category }}
        </button>
      </div>
    </div>
    <div class="grid grid-cols-4 gap-4">
      <Book v-for="book in filteredBooks" :key="book.title" :title="book.title" :author="book.author" :genre="book.genre"
        :pages="book.number_of_pages" :synopsis="book.synopsis" class="max-w-sm rounded overflow-hidden shadow-lg" />
    </div>
  </main>
</template>

<script>
import Book from './Book.vue'

export default {
  components: {
    Book
  },
  data() {
    return {
      books: [],
      selectedCategory: '',
      categories: []
    };
  },
  created() {
    fetch('/books.json')
      .then(response => response.json())
      .then(data => {
        this.books = data;
        this.categories = this.getCategories(data);
      })
      .catch(error => {
        console.error('Error al cargar los datos:', error);
      });
  },
  computed: {
    filteredBooks() {
      if (this.selectedCategory === '')
        return this.books;

      return this.books.filter(book => book.genre === this.selectedCategory);
    }
  },
  methods: {
    getCategories(data) {
      const categories = data.map(book => book.genre);
      const uniqueCategories = []
      categories.forEach(category => {
        if (!uniqueCategories.includes(category)) {
          uniqueCategories.push(category);
        }
      })

      return uniqueCategories
    },
    filterBooks(category) {
      this.selectedCategory = category;
    }
  }
};
</script>