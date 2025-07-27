/**
 * router/index.ts
 *
 * Automatic routes for `./src/pages/*.vue`
 */

// Composables
import { createRouter, createWebHistory } from 'vue-router/auto'
import { useAuthStore } from '@/stores/authStore'
import { setupLayouts } from 'virtual:generated-layouts'
import { routes } from 'vue-router/auto-routes'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: setupLayouts(routes),
})

// Workaround for https://github.com/vitejs/vite/issues/11804
router.onError((err, to) => {
  if (err?.message?.includes?.('Failed to fetch dynamically imported module')) {
    if (localStorage.getItem('vuetify:dynamic-reload')) {
      console.error('Dynamic import error, reloading page did not fix it', err)
    } else {
      console.log('Reloading page to fix dynamic import error')
      localStorage.setItem('vuetify:dynamic-reload', 'true')
      location.assign(to.fullPath)
    }
  } else {
    console.error(err)
  }
})

router.beforeEach((to, from, next) => {
  const auth = useAuthStore()

    //Redirecionamento dos index vazios e dá página inicial se tiver autenticado
    if (to.path === '/' && auth.isAuthenticated) return next('/dashboard/home')
    if (to.path === '/dashboard/') return next('/dashboard/home')
  
    //Redirecionamento para inicio se não estiver autenticado
    if(to.path !== '/' && !auth.isAuthenticated) return next('/')
    next()
})

const appName = 'Poman'
router.afterEach(to => {
  document.title = to.meta?.title || appName
})


router.isReady().then(() => {
  localStorage.removeItem('vuetify:dynamic-reload')
})

export default router
