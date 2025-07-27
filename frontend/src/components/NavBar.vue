<template>
    <v-app-bar  app height="48" class="navbar" flat>
      <v-container class="pl-4 ma-0">
        <v-img
          src="@/assets/poman-logo.png"
          :width="94.54"
          :height="48"
          alt="Logo-Poman"
        />
      </v-container>

      <v-spacer />

  <v-container class="d-flex align-center justify-center" max-width="300" fluid>

    <v-btn icon color="white" class="notification-btn mr-3">
      <v-icon size="20">mdi-bell-outline</v-icon>
    </v-btn>

    <v-avatar :size="32" class="mr-2">
      <v-img
        src="https://avatars.githubusercontent.com/u/48658061?v=4"
        alt="avatar-icon"
      />
    </v-avatar>
    <h2 class="text-white font-weight-regular user-name pr-2">Daniel Azevêdo</h2>
  </v-container>

  </v-app-bar>
</template>

<style scoped>
  .navbar {
    background-color: #8637CC !important;
  }
  .user-name {
    font-size: 14px;
  }
  .avatar-icon {
    border-radius: 50%;
  }
</style>
