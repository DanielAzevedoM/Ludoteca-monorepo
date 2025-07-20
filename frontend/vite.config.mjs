import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import Fonts from 'unplugin-fonts/vite'
import Layouts from 'vite-plugin-vue-layouts-next'
import VueRouter from 'unplugin-vue-router/vite'
import { VueRouterAutoImports } from 'unplugin-vue-router'
import Vuetify from 'vite-plugin-vuetify'
import { fileURLToPath, URL } from 'node:url'

export default defineConfig({
  plugins: [
    vue(),
    AutoImport({
      imports: [
        'vue',
        'vue-router',
        VueRouterAutoImports,
        { 'pinia': ['defineStore'] }
      ],
      dts: 'src/auto-imports.d.ts',
    }),
    Components({
      dirs: ['src/components'],
      extensions: ['vue'],
      dts: 'src/components.d.ts',
    }),
    Fonts({
      google: {
        families: ['Roboto:100,300,400,500,700,900&display=swap']
      }
    }),
    Layouts(),
    VueRouter({
      routesFolder: 'src/pages',
      importMode: 'async'
    }),
    Vuetify({
      autoImport: true,
      styles: { configFile: 'src/styles/settings.scss' }
    })
  ],
  resolve: {
    alias: { '@': fileURLToPath(new URL('./src', import.meta.url)) }
  },
  css: {
    preprocessorOptions: {
      sass: { quietDeps: true },
      scss: { quietDeps: true }
    }
  },
  server: { port: 3000 }
})