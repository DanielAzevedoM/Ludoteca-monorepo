<template>
  <v-navigation-drawer width="270" permanent>
    <v-list density="compact">
      <v-list-group
        v-for="(item, index) in menuState.menuItems"
        :key="index"
        v-model="item.expanded"
      >
        <template #activator="{ props }">
          <v-list-item
            v-bind="props"
            :prepend-icon="item.icon"
            class="custom-button"
          >
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </template>

        <v-list-item
          v-for="(sub, idx) in item.subitems"
          :key="idx"
          :to="sub.link"
          class="custom-sub-button"
          :class="{ 'active-subitem': isSubitemActive(sub.link) }"
        >
          <v-list-item-title>{{ sub.label }}</v-list-item-title>
        </v-list-item>
      </v-list-group>
    </v-list>
  </v-navigation-drawer>
</template>

<script setup>
import { reactive, onMounted } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()

function isSubitemActive(link) {
  return route.path === link
}

function isGroupActive(item) {
  return item.subitems.some(sub => isSubitemActive(sub.link))
}

const menuState = reactive({
  menuItems: [
    {
      title: 'Dashboard',
      icon: 'mdi-view-dashboard-outline',
      expanded: false,
      subitems: [
        { label: 'Início', link: '/dashboard/inicio' }
      ]
    },
    {
      title: 'Usuários',
      icon: 'mdi-account-outline',
      expanded: false,
      subitems: [
        { label: 'Listar', link: '/usuarios/gerenciar-usuarios' },
        { label: 'Níveis de acesso', link: '/usuarios/permissoes' }
      ]
    },
    {
      title: 'Pedidos',
      icon: 'mdi-clipboard-list-outline',
      expanded: false,
      subitems: [
        { label: 'Novo pedido', link: '/pedidos/novo' },
        { label: 'Pedidos pendentes', link: '/pedidos/pendentes' },
        { label: 'Histórico', link: '/pedidos/historico' }
      ]
    },
    {
      title: 'Games',
      icon: 'mdi-heart-outline',
      expanded: false,
      subitems: [
        { label: 'Listar', link: '/games/list' },
        { label: 'Editar games', link: '/games/editar' }
      ]
    },
    {
      title: 'Promoções',
      icon: 'mdi-tag-outline',
      expanded: false,
      subitems: [
        { label: 'Nova promoção', link: '/promocoes/nova' },
        { label: 'Promoções ativas', link: '/promocoes/ativas' }
      ]
    },
    {
      title: 'Financeiro',
      icon: 'mdi-cash-multiple',
      expanded: false,
      subitems: [
        { label: 'Receitas', link: '/financeiro/receitas' },
        { label: 'Despesas', link: '/financeiro/despesas' },
        { label: 'Relatórios financeiros', link: '/financeiro/relatorios' }
      ]
    },
    {
      title: 'Localizações',
      icon: 'mdi-earth',
      expanded: false,
      subitems: [
        { label: 'Gerenciar locais', link: '/localizacoes/gerenciar' },
        { label: 'Novo local', link: '/localizacoes/novo' }
      ]
    },
    {
      title: 'Regras de negócio',
      icon: 'mdi-wrench-outline',
      expanded: false,
      subitems: [
        { label: 'Nova regra', link: '/regras/nova' },
        { label: 'Editar regras', link: '/regras/editar' }
      ]
    },
  ]
})

onMounted(() => {
  menuState.menuItems.forEach(item => {
    item.expanded = isGroupActive(item)
  })
})
</script>

<style scoped>
.custom-button {
  height: 40px !important;
  padding: 0 10px !important;
}

.custom-sub-button {
  height: 36px !important;
  padding-left: 65px !important;
  padding-right: 16px !important;
}

.active-subitem {
  background-color: #f5f5f5 !important;
  border-left: 4px solid #8c0eff;
}
</style>
