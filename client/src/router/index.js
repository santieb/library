import { createRouter, createWebHistory } from 'vue-router';
import BooksPage from '@/views/BooksPage.vue'; // Ajusta la ruta según tu estructura de carpetas

const routes = [
  {
    path: '/',
    component: BooksPage,
  },
  // Otras rutas
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;