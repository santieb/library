<template>
  <main>
    <div class="grid grid-cols-4 gap-4">
      <Book v-for="book in books" :key="book.title" :title="book.title" :author="book.author" :genre="book.genre"
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
      books: [
        {
          "title": "The Catcher in the Rye",
          "author": "J.D. Salinger",
          "genre": "Fiction",
          "number_of_pages": 224,
          "synopsis": "The Catcher in the Rye is a novel by J.D. Salinger. It follows the story of Holden Caulfield, a disenchanted teenager, as he navigates the challenges of adolescence in New York City. The book is known for its exploration of teenage angst and the search for meaning in a complex world."
        },
        {
          "title": "To Kill a Mockingbird",
          "author": "Harper Lee",
          "genre": "Fiction",
          "number_of_pages": 324,
          "synopsis": "To Kill a Mockingbird is a classic novel by Harper Lee. It tells the story of a young girl named Scout Finch and her brother Jem as they witness their father, Atticus Finch, defend an African American man accused of rape in a racially divided Southern town. The book explores themes of racism, justice, and morality."
        },
        {
          "title": "1984",
          "author": "George Orwell",
          "genre": "Dystopian Fiction",
          "number_of_pages": 328,
          "synopsis": "1984 is a dystopian novel by George Orwell. It is set in a totalitarian society where the government exercises total control over every aspect of people's lives. The story follows the life of Winston Smith, who begins to question the oppressive regime and seeks to rebel against it."
        }
      ]
    };
  }
};
</script>