<template>
  <main>
    <filter-bar :selectedCategory="selectedCategory" :categories="categories" @filter="filterBooks" />
    <div class="grid grid-cols-4 gap-4">
      <Book v-for="book in filteredBooks" :key="book.title" :title="book.title" :author="book.author" :genre="book.genre"
        :pages="book.number_of_pages" :synopsis="book.synopsis" class="max-w-sm rounded overflow-hidden shadow-lg" />
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