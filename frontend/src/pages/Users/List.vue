<template>

</template>

<script>

 definePage({
  meta: {
    title: 'Poman - Usuários',
    header: {
      title: 'Usuários',
      description: 'Aqui você poderá visualizar usuários.',
      breadcrumbs: [
        { label: 'Usuários', href: '#', disabled: true },
        { label: 'Listar', href: '#' }
      ],
      tabs: ['Todos', 'Clientes', 'Colaboradores', 'Administradores'],
      buttonText: '+ Criar novo',
      onButtonClick: () => console.log('Criar novo clicado')
    }
  }
})

</script>

<style scoped>
</style>