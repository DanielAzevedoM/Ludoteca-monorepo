<template>
  <v-container fluid class="login-page pa-0">
    <v-row no-gutters class="full-height">
      <!-- Left: 70% image -->
      <v-col class="image-col full-height pa-0">
        <v-img
          :src="loginBg"
          alt="Login Background"
          cover
          height="100%"
          width="100%"
        />
      </v-col>

      <!-- Right: 30% login form -->
      <v-col class="form-col full-height d-flex flex-column align-center justify-center">
        <div class="login-block">
          <div class="login-label">Login</div>
          <v-btn class="login-btn white--text mt-4" @click="onGoogleLogin">
            Entrar com Google
          </v-btn>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { onMounted } from 'vue'
import { useAuthStore } from '@/stores/authStore'
import loginBg from '@/assets/ludoteca.png'

const auth = useAuthStore()

function onGoogleLogin() {
  auth.loginWithGoogle()
}
</script>

<style scoped>
.login-page {
  height: 100vh;
  overflow: hidden;
}

.full-height {
  height: 100vh !important;
}

.image-col {
  flex: 0 0 70%;
  max-width: 70%;
}

.form-col {
  flex: 0 0 30%;
  max-width: 30%;
}

.login-block {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.login-label {
  font-size: 1.5rem;
  color: #212121;
  margin-bottom: 1rem;
}

.login-btn {
  background-color: #00b8c9 !important;
}
</style>