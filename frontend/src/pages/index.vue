<template>
  <LoginPage />
</template>

<script setup>
import { useRouter } from 'vue-router'
import { useAuthStore } from '@/stores/authStore'

definePage({
  name: 'Login',
  meta: { title: 'Login – Ludoteca', layout: false },

})

const auth = useAuthStore()
const router = useRouter()

onBeforeMount(() => {
  if(auth.isAuthenticated) router.replace({ path: '/dashboard/inicio', query: {} })
  // Handle OAuth callback token from URL
  const token = new URLSearchParams(window.location.search).get('token')
  if (token) {
    auth.setAuthToken(token)
    // Redirect to dashboard after storing token
    router.replace({ path: '/dashboard/inicio', query: {} })
  }
})
</script>