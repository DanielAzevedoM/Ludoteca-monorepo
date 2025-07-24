<template>
  <div class="category-tab-container">
    <div class="label">Categorias :</div>
    <v-slide-group
      v-model="activeCategory"
      class="category-tabs"
      show-arrows
      mandatory
    >
      <v-slide-group-item
        v-for="(category, index) in categories.list"
        :key="index"
        :value="category.value"
        >
        <v-btn
          class="category-tab"
          :class="{ 'selected-tab': activeCategory === category.value }"
          variant="text"
          @click="selectCategory(category.value)"
        >
          {{ category.label }}
        </v-btn>
      </v-slide-group-item>
    </v-slide-group>
  </div>
</template>

<script setup>
    import { ref, reactive, onMounted } from 'vue'
    import { getCategoriesData } from '@/services/categoryService'

    const activeCategory = ref('todas')

    const categories = reactive({
    list: [{ label: 'Todas', value: 'todas' }]
    })

    function selectCategory(value) {
    activeCategory.value = value
    // lógica de filtro futura
    }

    onMounted(async () => {
    try {
        const data = await getCategoriesData()
        data.forEach(category => {
        categories.list.push({
            label: category.name,
            value: category.name.toLowerCase()
        })
        })
    } catch (error) {
        console.error('Erro ao buscar categorias:', error)
    }
    })

</script>

<style scoped>
.category-tab-container {
    width: 1590px;
    display: flex;
    align-items: center;
    background-color: #ffffff;
    padding: 16px 24px;
    margin: 24px;
    gap: 8px;
    overflow: hidden;
    border-radius: 4px;
    border: 1px solid #e0e0e0;
}

.label {
  font-weight: 500;
  font-size: 0.9rem;
  white-space: nowrap;
}

.category-tabs {
  flex-grow: 1;
  overflow-x: auto;
}

.category-tab {
  font-size: 0.85rem;
  text-transform: none;
  white-space: nowrap;
  min-width: auto;
}

.selected-tab {
  color: #8c0eff !important;
  font-weight: bold;
}
</style>
