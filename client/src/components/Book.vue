<template>
  <div class="max-w-sm rounded overflow-hidden shadow-lg bg-blue-200">
    <div class="px-6 py-4">
      <div class="font-bold text-xl mb-2">{{ title }}</div>
      <p class="text-gray-700 text-base">{{ truncateString(synopsis) }}</p>
    </div>
    <div class="px-6 pt-4 pb-2">
      <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2">{{
        author }}</span>
      <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2">{{ genre
      }}</span>
      <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2"> {{
        pages }} pages</span>
    </div>
  </div>
</template>

<script>
import { truncateString } from '../helpers'

export default {
  props: {
    title: String,
    author: String,
    genre: String,
    pages: Number,
    synopsis: String,
    coverImage: String,
  },
  methods: {
    truncateString
  },
}

</script>

