<template>
  <v-navigation-drawer permanent app class="sidemenu">
    <v-list nav density="compact">
      <v-list-group
        v-for="(item, index) in menu"
        :key="index"
        prepend-icon="mdi-chevron-down"
      >
        <template #activator="{ props }">
          <v-list-item
            v-bind="props"
            :title="item.title"
            :prepend-icon="item.icon"
            :value="item.expanded"
          />
        </template>

        <v-list-item
          v-for="(sub, i) in item.subMenu"
          :key="i"
          :title="sub.title"
          :to="sub.to"
          link
          class="pl-8"
        />
      </v-list-group>
    </v-list>
  </v-navigation-drawer>
</template>

<script setup>
const menu = [
  {
    icon: "mdi-home",
    title: "Dashboard",
    expanded: false,
    subMenu: [
      { title: "Início", to: "/dashboard/home" },
    ]
  },
  {
    icon: "mdi-account",
    title: "Usuários",
    expanded: false,
    subMenu: [
      { title: "Listar", to: "/users/list" },
      { title: "Níveis de acesso", to: "/users/acesslevel" }
    ]
  },
  {
    icon: "mdi-cog",
    title: "Pedidos",
    expanded: false,
    subMenu: [
      { title: "Listar", to: "/games/list" },
      { title: "Gerenciar", to: "/games/category" }
    ]
  },
]
</script>

<style scoped>
.sidemenu {
  max-width: 30vh;
}
</style>
