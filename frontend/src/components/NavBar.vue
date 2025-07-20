// MODIFICATION BASED ON: src/components/GlobalHeaderPoman.vue
<template>
  <v-app-bar
    app
    flat
    height="48"
    class="d-flex align-center pl-4 pr-8"
    style="background-color: #8c0eff;"
  >
   

    <!-- Brand name -->
    <v-toolbar-title class="brand-title ml-2">
      ludoteca
    </v-toolbar-title>

    <v-spacer />

    <!-- Notifications -->
   
    <v-btn icon class="white--text">
        <v-icon size="20" color="white">mdi-bell</v-icon>
    </v-btn>
   

    <!-- User avatar and name -->
    <v-avatar size="32" class="mr-4">
      <v-img
        src="https://avatars.githubusercontent.com/u/48658061?s=400&u=bcdb4697c6b445a2909e00ca5c5c5119c9b47a0d&v=4"
        alt="User Avatar"
      />
    </v-avatar>
    <span class="user-name">Daniel Azevêdo</span>
  </v-app-bar>
</template>

<script setup>
import { ref } from 'vue'
// Hardcoded notification badge count
const notificationCount = ref(11)
</script>

<style scoped>
.brand-title {
  color: #ffffff;
  font-weight: 700;
  font-size: 1rem;
}

.user-name {
  color: #ffffff;
  font-weight: 500;
  font-size: 0.875rem;
}

.v-application--wrap > header {
  z-index: 10;
}
</style>
