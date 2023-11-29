import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import BooksPage from '@/pages/BooksPage.vue';
import BookFormPage from '@/pages/BookFormPage.vue';
import RegisterPage from '@/pages/RegisterPage.vue';
import LoginPage from '@/pages/LoginPage.vue';

const routes = [
  {
    path: '/',
    component: Home,
  },
  {
    path: '/books',
    component: BooksPage,
  },
  {
    path: '/book-form/:id?',
    component: BookFormPage,
  },
  {
    path: '/register',
    component: RegisterPage,
  },
  {
    path: '/login',
    component: LoginPage,
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;