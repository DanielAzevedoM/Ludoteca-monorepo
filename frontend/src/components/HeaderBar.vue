<template>
  <v-sheet width="100%" class="page-header py-4 px-6" color="#fff">
    <!-- Breadcrumbs -->
    <v-breadcrumbs class="text-caption mb-1" >
      <v-breadcrumbs-item href="#" class="breadcrumbs-size" disabled>Home</v-breadcrumbs-item>
      <v-breadcrumbs-item v-if="items.breadcrumbs?.length > 0" v-for="(crumb, i) in items.breadcrumbs" :key="i" :href="crumb.href" :disabled="crumb.disabled" class="breadcrumbs-size">
        / {{ crumb.label }}
      </v-breadcrumbs-item>
    </v-breadcrumbs>


    <v-row align="center" justify="space-between" class="ml-6">
  <v-col cols="auto">
    <v-row align="center" no-gutters>
      <!-- Título -->
      <h2 class="text-h6 font-weight-bold mr-4 mb-0">{{ items.title }}</h2>

      <!-- Descrição ao lado -->
      <p class="text-body-2 mb-0 description" v-if="items.description">{{ items.description }}</p>
    </v-row>
  </v-col>

  <!-- Botão -->
  <v-btn
    v-if="items.buttonText"
    color="#8637CC"
    class="mr-9"
    @click="items.onButtonClick"
  >
    {{ items.buttonText }}
  </v-btn>
</v-row>

    <!-- Tabs -->
    <v-tabs
      v-if="items.tabs?.length"
      class="mt-3"
      v-model="activeTab"
      color="#8637CC"
      background-color="transparent"
      slider-color="#8637CC"
    >
      <v-tab v-for="(tab, i) in items.tabs" :key="i">{{ tab }}</v-tab>
    </v-tabs>
  </v-sheet>
</template>

<script setup>
import { ref } from 'vue'

defineProps({
  items: {
    type: Object,
    required: true
  }
})

const activeTab = ref(0)

</script>

<style scoped>
.page-header {
  border-bottom: 1px solid #eee;
}

.breadcrumbs-size {
  font-size: 14px;
}

.description{
  color: gray;
}
</style>
