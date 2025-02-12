<template>
  <main>
    <table class="min-w-full border rounded overflow-hidden">
      <thead class="bg-gray-100">
        <tr>
          <th class="border py-2 px-4">ID</th>
          <th class="border py-2 px-4">Fecha de Inicio</th>
          <th class="border py-2 px-4">Fecha de Fin</th>
          <th class="border py-2 px-4">Libro</th>
          <th class="border py-2 px-4">Acciones</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="loan in loans" :key="loan.id">
          <td class="border py-2 px-4">{{ loan.id }}</td>
          <td class="border py-2 px-4">{{ loan.startDate }}</td>
          <td class="border py-2 px-4">{{ loan.endDate }}</td>
          <td class="border py-2 px-4">{{ loan.bookTitle }}</td>
          <td class="border py-2 px-4">
            <button @click="() => returnBook(loan.id)" class="bg-green-500 text-white py-1 px-2 rounded">Devolver</button>
          </td>
        </tr>
      </tbody>
    </table>
  </main>
</template>

<script>
const apiUrl = import.meta.env.VITE_API_URL;
export default {
  data() {
    return {
      loans: []
    };
  },
  created() {
    this.fetchBooks();
  },
  methods: {
    async fetchBooks() {
      try {
        const response = await fetch(`${apiUrl}/books`);
        const books = await response.json();
        this.loans = books.flatMap(book => 
          book.loans.map(loan => ({ ...loan, bookTitle: book.title }))
        );
      } catch (error) {
        console.error('Error al cargar los datos:', error);
      }
    },
    async returnBook(id) {
      try {
        await fetch(`${apiUrl}/loans/${id}`, {
          method: 'DELETE',
        });
        this.loans = this.loans.filter(loan => loan.id !== id);
      } catch (error) {
        console.error(`Error al devolver el libro con préstamo ${id}:`, error);
      }
    }
  }
};
</script>
