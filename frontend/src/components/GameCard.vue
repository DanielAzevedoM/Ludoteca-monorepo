<template>
  <v-card class="game-card" flat>
    <!-- Capa com status -->
    <div class="cover-container">
      <v-img
        class="cover-image"
        :src="image"
        alt="Capa do jogo"
        cover
      />
      <v-chip
        v-if="status"
        class="status-chip"
        :color="status === 'visível' ? 'success' : 'error'"
        size="x-small"
        label
      >
        <v-icon
          size="14"
          class="mr-1"
        >
          {{ status === 'visível' ? 'mdi-eye-outline' : 'mdi-eye-off-outline' }}
        </v-icon>
        {{ capitalize(status) }}
      </v-chip>
    </div>

    <!-- Conteúdo -->
    <div class="card-content">
      <div class="game-title">
        {{ title }}
      </div>
      <div class="game-price">
        R${{ price }}
      </div>
      <div class="game-category">
        {{ category }}
      </div>
    </div>
  </v-card>
</template>

<script setup>

defineProps({
  title: String,
  price: [String, Number],
  image: String,
  category: String,
  status: String // 'visível' ou 'oculto'
})

function capitalize(value) {
  return value.charAt(0).toUpperCase() + value.slice(1)
}
</script>

<style scoped>
.game-card {
  margin: 24px;
  width: 224px;
  border-radius: 4px;
  overflow: hidden;
  background-color: #fff;
  border: 1px solid #eee;
  display: flex;
  flex-direction: column;
  padding: 0;
  box-shadow: none;
}

.cover-container {
  position: relative;
  width: 100%;
  height: 177px;
  overflow: hidden;
}

.cover-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.status-chip {
  position: absolute;
  top: 8px;
  right: 8px;
  font-size: 0.7rem;
}

.card-content {
  padding: 16px;
  display: flex;
  flex-direction: column;
  gap: 4px;
}

.game-title {
  font-weight: 600;
  font-size: 0.9rem;
  line-height: 1.2rem;
}

.game-price {
  font-size: 0.85rem;
  color: #4d4d4d;
}

.game-category {
  font-size: 0.75rem;
  color: #888;
}
</style>
