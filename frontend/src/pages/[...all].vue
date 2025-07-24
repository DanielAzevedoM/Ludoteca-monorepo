<template>
  <v-container class="fill-height d-flex align-center justify-center text-center">
    <div>
      <h1 class="text-h2 font-weight-bold mb-4">404</h1>
      <p class="text-subtitle-1 mb-6">Página não encontrada</p>
      <v-btn color="primary" to="/">Voltar para o início</v-btn>
    </div>
  </v-container>
</template>

<script setup>
import { useAuthStore } from '@/stores/authStore';

const auth = useAuthStore()
auth.checkIsAuthenticaded()

definePage({
  meta: {
    title:'404 - Página não encontrada',
    layout: 'default' 
  }
})

</script>

<style scoped>
h1 {
  color: #8c0eff;
}
</style>
