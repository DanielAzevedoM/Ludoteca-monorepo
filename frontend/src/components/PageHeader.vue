<template>
  <div v-if="show" class="header-container">
    <!-- Breadcrumb e botão lado a lado -->
    <div class="header-top">
      <v-breadcrumbs class="text-caption breadcrumbs" :items="formattedBreadcrumbs" divider=" / " />

      <slot name="actions">
        <v-btn
          v-if="canCreate"
          color="#8c0eff"
          class="text-white text-none create-btn"
          height="36"
          @click="$emit('create')"
        >
          + Criar novo
        </v-btn>
      </slot>
    </div>

    <!-- Área de título com ícone de voltar -->
    <div class="header-middle">
      <v-btn icon variant="plain" class="back-btn" v-if="canGoBack" @click="goBack">
        <v-icon>mdi-arrow-left</v-icon>
      </v-btn>
      <div>
        <h1 class="title">{{ title }}</h1>
        <p class="subtitle">{{ subtitle }}</p>
      </div>
    </div>

    <!-- Tabs alinhadas corretamente -->
    <v-tabs
      v-if="tabs && tabs.length"
      v-model="activeTab"
      color="#8c0eff"
      class="tabs"
      density="compact"
    >
      <v-tab v-for="(tab, i) in tabs" :key="i" :value="tab.value">
        {{ tab.label }}
      </v-tab>
    </v-tabs>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router'
import { computed, ref } from 'vue'

const props = defineProps({
  title: String,
  subtitle: String,
  breadcrumbs: Array,
  canCreate: Boolean,
  canGoBack: Boolean,
  tabs: Array
})

const emit = defineEmits(['create'])

const route = useRoute()
const router = useRouter()
const show = computed(() => !route.path.includes('/dashboard'))

const activeTab = ref(props.tabs?.[0]?.value || null)

function goBack() {
  router.back()
}

const formattedBreadcrumbs = computed(() =>
  props.breadcrumbs?.map(label => ({ title: label })) || []
)
</script>

<style scoped>
.header-container {
  
  padding: 16px 24px;
  background-color: white;
  border-bottom: 1px solid #e0e0e0;
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.header-top {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.create-btn {
  padding: 0 12px;
}

.header-middle {
  display: flex;
  align-items: center;
}

.back-btn {
  margin-right: 8px;
}

.title {
  font-size: 1.25rem;
  font-weight: 600;
  margin: 0;
}

.subtitle {
  font-size: 0.875rem;
  color: #666;
  margin: 2px 0 0;
}

.tabs {
  margin-left: 40px;
}

.breadcrumbs {
  color: #888;
  font-size: 0.75rem;
}
</style>