<template>
  <main>
    <table class="min-w-full border rounded overflow-hidden">
      <thead class="bg-gray-100">
        <tr>
          <th class="border py-2 px-4">Title</th>
          <th class="border py-2 px-4">Author</th>
          <th class="border py-2 px-4">Genre</th>
          <th class="border py-2 px-4">Pages</th>
          <th class="border py-2 px-4">Synopsis</th>
          <th class="border py-2 px-4">Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="book in books" :key="book.id">
          <td class="border py-2 px-4">{{ book.title }}</td>
          <td class="border py-2 px-4">{{ book.author }}</td>
          <td class="border py-2 px-4">{{ book.genre }}</td>
          <td class="border py-2 px-4">{{ book.pages }}</td>
          <td class="border py-2 px-4">{{ book.synopsis }}</td>
          <td class="border py-2 px-4">
            <button @click="() => deleteBook(book.id)" class="bg-red-500 text-white py-1 px-2 rounded">Delete</button>
            <button @click="() => editBook(book.id)" class="bg-blue-500 text-white py-1 px-2 rounded">Update</button>
          </td>
        </tr>
      </tbody>
    </table>
  </main>
</template>

<script>
import FilterBar from './FilterBar.vue';

export default {
  components: {
    FilterBar,
  },
  data() {
    return {
      books: [],
      selectedCategory: '',
      categories: [],
    };
  },
  created() {
    this.fetchBooks();
  },
  methods: {
    async fetchBooks() {
      try {
        const response = await fetch('http://localhost:8082/api/books');
        const data = await response.json();
        console.log(data);
        this.books = data;
        this.categories = this.getCategories(data);
      } catch (error) {
        console.error('Error al cargar los datos:', error);
      }
    },
    async deleteBook(bookId) {
      try {
        const response = await fetch(`http://localhost:8082/api/books/${bookId}`, {
          method: 'DELETE',
        });

        if (response.status === 200) {
          console.log(`Book with ID ${bookId} deleted successfully`);
          // Actualizar la lista de libros después de eliminar
          this.fetchBooks();
        } else {
          console.error(`Error deleting book with ID ${bookId}:`, response.statusText);
        }
      } catch (error) {
        console.error(`Error deleting book with ID ${bookId}:`, error);
      }
    },
    editBook(bookId) {
      this.$router.push(`/book-form/${bookId}`);
    },
    getCategories(data) {
      const categories = data.map(book => book.genre);
      return [...new Set(categories)];
    },
  },
};
</script>