<template>
  <NavBar />  
  <SideMenu/>
  <v-main>
   <HeaderBar
      v-if="route.path !== '/dashboard/home' && route.meta.header"
      :items="route.meta.header"
      />
    <router-view />
  </v-main>
 
</template>

<script setup>
import { useRoute } from 'vue-router'

const route = useRoute()


</script>

<style>
.v-main {
  background-color: #D7E4F3;
  min-height: 100vh;
}
</style>
