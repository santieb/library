<template>
  <main>
    <filter-bar :selectedCategory="selectedCategory" :categories="categories" @filter="filterBooks" />
    <div class="grid grid-cols-4 gap-4">
      <Book v-for="book in filteredBooks" :key="book.id" :title="book.title" :author="book.author" :genre="book.genre"
        :pages="book.pages" :synopsis="book.synopsis" class="max-w-sm rounded overflow-hidden shadow-lg" />
    </div>
  </main>
</template>

<script>
import Book from './Book.vue'
import FilterBar from './FilterBar.vue';

export default {
  components: {
    Book,
    FilterBar
  },
  data() {
    return {
      books: [],
      selectedCategory: '',
      categories: []
    };
  },
  created() {
    fetch('http://localhost:8082/api/books')
        .then(response => response.json())
        .then(data => {
            console.log(data)
            this.books = data; // Corregir esta línea
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

      console.log("filter", this.books)
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