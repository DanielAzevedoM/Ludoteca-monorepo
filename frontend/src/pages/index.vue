<template>
  <div class="background-img"> 
    <v-img
      class="poman-logo"
      :width="272.55"
      :height="88.1"
      src="@/assets/poman-logo.png"
    ></v-img>
    <v-container class="login-group pa-0 pt-5" max-width="360">
      <div class="login-title">Login</div>
      <v-btn block class="mt-5 v-btn-color" @Click="googleBtn">Entrar com Google</v-btn>
      <v-btn block class="mt-5 v-btn-color">Entrar com Apple</v-btn>
    </v-container>
  </div>
</template>

<script setup>
import { useAuthStore } from '@/stores/authStore'

const auth = useAuthStore()

definePage({
  meta: {
    title:"Poman - Início",
    layout: false
  }})
  
  onBeforeMount(() => {
    const token = new URLSearchParams(window.location.search).get('token')
    if (token) auth.handleCallback()
  })

  const googleBtn = () => auth.loginWithGoogle()

</script>

<style scoped>
  .background-img {
    background-image: url('@/assets/index-background.png');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    min-height: 100vh;
  }

  .login-title {
    font-size: 18px;
    color: white;
    font-weight: normal;
    border-bottom: 2px solid white;
    padding-bottom: 4px;
    width: fit-content;
  }

  .login-group {
    margin-left: 17.41vh;
  }

  .poman-logo{
    margin-top: 29.39vh;
    margin-left: 21.43vh;

  }

  .v-btn-color {
    background-color: #EB2F96;
    color: white;
  }

</style>

