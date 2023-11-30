<script setup>
import Header from './components/Header.vue'
import BookList from './components/BookList.vue'
</script>

<template>
    <Header />
    <main class="max-w-[1200px]   items-center justify-center m-auto">
        <router-view />
    </main>
</template>