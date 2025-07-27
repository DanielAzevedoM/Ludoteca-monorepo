import { defineStore } from 'pinia'
import { useRouter } from 'vue-router'

export const useAuthStore = defineStore("auth", {
    state: () => ({
        isAuthenticated: !!sessionStorage.getItem('authToken'),
        error: null,
        token: sessionStorage.getItem('authToken') || null,
    }),
    getters: {
        getIsAuthenticated: (state) => state.isAuthenticated
    },
    actions: {
        loginWithGoogle() {
            window.location.href = 'http://localhost:8080/auth/google'
        },

        handleCallback() {
            this.error = null
            try {
                const router = useRouter()
                const params = new URLSearchParams(window.location.search)
                const authToken = params.get('token')
                if (!authToken) throw new Error('No token found in URL')
                this.token = authToken
                this.isAuthenticated = true
                sessionStorage.setItem('authToken', authToken)

                return router.replace({ path: '/dashboard/home', query: {} })
            } catch (err) {
                this.error = err.message
                console.error('Callback handling failed:', err)
                return null
            } finally {
                this.loading = false
            }

        },

    },
}
)