<template>
  <form @submit.prevent="submitForm" class="max-w-md mx-auto mt-8">
    <h2 class="text-2xl font-bold mb-4">
      {{ isUpdate ? 'Update Book' : 'Create Book' }}
    </h2>
    <div class="mb-4">
      <label for="title" class="block text-gray-700 text-sm font-bold mb-2">Title:</label>
      <input v-model="book.title" type="text" id="title" class="w-full border rounded py-2 px-3" required>
    </div>
    <div class="mb-4">
      <label for="author" class="block text-gray-700 text-sm font-bold mb-2">Author:</label>
      <input v-model="book.author" type="text" id="author" class="w-full border rounded py-2 px-3" required>
    </div>
    <div class="mb-4">
      <label for="genre" class="block text-gray-700 text-sm font-bold mb-2">Genre:</label>
      <input v-model="book.genre" type="text" id="genre" class="w-full border rounded py-2 px-3" required>
    </div>
    <div class="mb-4">
      <label for="pages" class="block text-gray-700 text-sm font-bold mb-2">Pages:</label>
      <input v-model="book.pages" type="number" id="pages" class="w-full border rounded py-2 px-3" required>
    </div>
    <div class="mb-4">
      <label for="synopsis" class="block text-gray-700 text-sm font-bold mb-2">Synopsis:</label>
      <textarea v-model="book.synopsis" id="synopsis" class="w-full border rounded py-2 px-3" required></textarea>
    </div>
    <div>
      <button type="submit" class="bg-blue-500 text-white py-2 px-4 rounded">
        {{ isUpdate ? 'Update' : 'Submit' }}
      </button>
    </div>
  </form>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const bookId = ref(null);
const book = ref({
  title: '',
  author: '',
  genre: '',
  pages: 0,
  synopsis: '',
  id: null,
});

const isUpdate = computed(() => !!book.value.id);

onMounted(() => {
  if (router.currentRoute.value.params) {
    bookId.value = router.currentRoute.value.params.id;

    if (bookId.value) {
      loadBookDetails();
    } else {
      book.value.id = null;
    }
  }
});

const loadBookDetails = async () => {
  try {
    const response = await fetch(`http://localhost:8082/api/books/${bookId.value}`);
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }
    const data = await response.json();

    book.value.id = data.id;
    book.value.title = data.title;
    book.value.author = data.author;
    book.value.genre = data.genre;
    book.value.pages = data.pages;
    book.value.synopsis = data.synopsis;
  } catch (error) {
    console.error('Error loading book details:', error);
  }
};

const submitForm = async () => {
  if (validateForm()) {
    try {
      if (isUpdate && book.value.id) {
        await updateBook();
      } else {
        await createBook();
      }
    } catch (error) {
      alert(`Error: ${error.message}`);
      console.error('Error:', error);
    }
  }
};

const updateBook = async () => {
  try {
    const url = `http://localhost:8082/api/books/${book.value.id}`;
    const method = 'PUT';

    const response = await fetch(url, {
      method,
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(book.value),
    });

    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    console.log(`Book updated successfully:`, book.value);
    resetForm();
    alert(`Libro actualizado exitosamente`);
    router.push('/');
  } catch (error) {
    throw new Error(`Error updating book: ${error.message}`);
  }
};

const createBook = async () => {
  try {
    const url = 'http://localhost:8082/api/books';
    const method = 'POST';

    const response = await fetch(url, {
      method,
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(book.value),
    });

    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    console.log(`Book created successfully:`, book.value);
    resetForm();
    alert(`Libro creado exitosamente`);
    router.push('/');
  } catch (error) {
    throw new Error(`Error creating book: ${error.message}`);
  }
};

const validateForm = () => {
  if (!book.value.title || !book.value.author || !book.value.genre || !book.value.pages || !book.value.synopsis) {
    console.error('All fields must be filled');
    return false;
  }
  return true;
};

const resetForm = () => {
  book.value = {
    title: '',
    author: '',
    genre: '',
    pages: 0,
    synopsis: '',
    id: null,
  };
};
</script>
