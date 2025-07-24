<template>

</template>
<script setup>
import { useAuthStore } from '@/stores/authStore';

const auth = useAuthStore()
auth.checkIsAuthenticaded()

</script>