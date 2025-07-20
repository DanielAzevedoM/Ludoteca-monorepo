<template>
  <v-navigation-drawer
    app
    permanent
    width="208"
    class="side-menu"
  >
    <v-list dense nav>
      <!-- Dashboard group -->
      <v-list-group
        v-model="openDashboard"
        prepend-icon="mdi-clock-outline"
        no-action
      >
        <template #activator>
          <v-list-item-content>
            <v-list-item-title>Dashboard</v-list-item-title>
          </v-list-item-content>
        </template>

        <!-- Sub-item: Início -->
        <v-list-item link>
          <v-list-item-content>
            <v-list-item-title>Início</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-group>

      <!-- Usuários -->
      <v-list-item link>
        <v-list-item-icon>
          <v-icon>mdi-account-outline</v-icon>
        </v-list-item-icon>
        <v-list-item-title>Usuários</v-list-item-title>
      </v-list-item>

      <!-- Pedidos -->
      <v-list-item link>
        <v-list-item-icon>
          <v-icon>mdi-clipboard-text-outline</v-icon>
        </v-list-item-icon>
        <v-list-item-title>Pedidos</v-list-item-title>
      </v-list-item>

      <!-- Serviços -->
      <v-list-item link>
        <v-list-item-icon>
          <v-icon>mdi-heart-outline</v-icon>
        </v-list-item-icon>
        <v-list-item-title>Serviços</v-list-item-title>
      </v-list-item>

      <!-- Promoções -->
      <v-list-item link>
        <v-list-item-icon>
          <v-icon>mdi-tag-outline</v-icon>
        </v-list-item-icon>
        <v-list-item-title>Promoções</v-list-item-title>
      </v-list-item>

      <!-- Financeiro -->
      <v-list-item link>
        <v-list-item-icon>
          <v-icon>mdi-currency-usd</v-icon>
        </v-list-item-icon>
        <v-list-item-title>Financeiro</v-list-item-title>
      </v-list-item>

      <!-- Localizações -->
      <v-list-item link>
        <v-list-item-icon>
          <v-icon>mdi-earth</v-icon>
        </v-list-item-icon>
        <v-list-item-title>Localizações</v-list-item-title>
      </v-list-item>

      <!-- Regras de negócio -->
      <v-list-item link>
        <v-list-item-icon>
          <v-icon>mdi-check-circle-outline</v-icon>
        </v-list-item-icon>
        <v-list-item-title>Regras de negócio</v-list-item-title>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script setup>
import { ref } from 'vue'

// Control expansion of the Dashboard group
const openDashboard = ref(true)
</script>

<style scoped>
.side-menu {
  background-color: #ffffff;
  border-right: 1px solid #e0e0e0;
}

.v-list-item-title {
  font-size: 0.875rem;
  color: #424242;
}
</style>