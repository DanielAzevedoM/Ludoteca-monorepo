import { createRouter, createWebHistory } from 'vue-router/auto'
import { setupLayouts } from 'virtual:generated-layouts'
import { routes } from 'vue-router/auto-routes'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: setupLayouts(routes),
})

router.onError((err, to) => {
  if (err?.message?.includes?.('Failed to fetch dynamically imported module')) {
    if (localStorage.getItem('vuetify:dynamic-reload')) {
      console.error('Dynamic import error, reloading page did not fix it', err)
    } else {
      localStorage.setItem('vuetify:dynamic-reload', 'true')
      window.location.reload()
    }
  } else {
    console.error(err)
  }
})

router.isReady().then(() => {
  localStorage.removeItem('vuetify:dynamic-reload')
})

// START MODIFICATION BASED ON: Ludoteca-monorepo/frontend/src/router/index.js
const appName = 'Ludoteca'
router.afterEach(to => {
  document.title = to.meta?.title || appName
})
// END MODIFICATION

export default router