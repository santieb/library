<template>
  <form @submit.prevent="handleSubmitForm" class="max-w-md mx-auto mt-8 rouded-lg shadow-md border-2 p-5">
    <h2 class="text-2xl font-bold mb-4">
      {{ isLogin ? 'Login' : 'Register' }}
    </h2>
    <div class="mb-4">
      <label for="username" class="block text-gray-700 text-sm font-bold mb-2">Username:</label>
      <input v-model="authForm.username" type="text" id="username" class="w-full border rounded py-2 px-3" required>
    </div>
    <div class="mb-4">
      <label for="password" class="block text-gray-700 text-sm font-bold mb-2">Password:</label>
      <input v-model="authForm.password" type="password" id="password" class="w-full border rounded py-2 px-3" required>
    </div>
    <div>
      <button type="submit" class="bg-blue-500 text-white py-2 px-4 rounded">
        {{ isLogin ? 'Login' : 'Register' }}
      </button>
    </div>
  </form>
</template>

<script setup>
import { ref, onMounted, defineProps } from 'vue';
import { useRouter } from 'vue-router';

const props = defineProps(['isLogin']);
const authForm = ref({
  username: '',
  password: '',
});
const router = useRouter();

onMounted(() => {
});

const handleSubmitForm = async () => {
  try {
    console.log('Submitting form:', authForm.value);
    console.log(authForm.value)
    const endpoint = props.isLogin ? '/login' : '';
    const response = await fetch(`http://localhost:8082/api/users${endpoint}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(authForm.value),
    });

    if (response.status == 200) {
      console.log("prop", props.isLogin)
      if (!props.isLogin) {
        alert(`${props.isLogin ? 'Login' : 'Register'} successful:`, authForm.value);
        return router.push(`/login`);
    }

      alert(`${props.isLogin ? 'Login' : 'Register'} successful:`, authForm.value);
      router.push(`/`);
    } else {
      console.error(`${props.isLogin ? 'Login' : 'Register'} failed: ${response.statusText}`);
    }
  } catch (error) {
    console.error('Error:', error);
  }
};
</script>