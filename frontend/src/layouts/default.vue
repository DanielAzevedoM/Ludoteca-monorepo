<template>
  <NavBar />
  <SideMenu />
  <v-main>
    <router-view />
  </v-main>
</template>

<script setup>
  import NavBar from '@/components/NavBar.vue';
  import SideMenu from '@/components/SideMenu.vue';

</script>
