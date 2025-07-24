<template>
    <PageHeader
        title="Games"
        subtitle="Aqui você pode listar e cadastrar games."
        :breadcrumbs="[ 'Games', 'Listar']"
        :canCreate="true"
        :canGoBack="true"
        
        @create="handleCreate"
    />

    <CategoryFilterTab />

    <GameCard
        title="Elden Ring"
        price="345,99"
        category="Rpg"
        status="visível"
        image="https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1245620/capsule_616x353.jpg?t=1748630546"
    />


</template>
<script setup>
    import { useAuthStore } from '@/stores/authStore';

    const auth = useAuthStore()
    auth.checkIsAuthenticaded()

    definePage({
    name: 'Games',
    meta: { title: 'Listar Games – Ludoteca', layout: false },
    })
</script>