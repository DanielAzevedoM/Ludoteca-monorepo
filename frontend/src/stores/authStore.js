import { defineStore } from 'pinia'

/**
 * Pinia store for authentication using sessionStorage for persistence
 */
export const useAuthStore = defineStore('auth', {
  state: () => ({
    loading: false,
    isAuthenticated: !!sessionStorage.getItem('authToken'),
    error: null,
    token: sessionStorage.getItem('authToken') || null,
  }),
  getters: {
    /** Retrieves current token */
    getToken: (state) => state.token,
    /** Indicates if a login request is in progress */
    isLoading: (state) => state.loading,
    /** Indicates if there's an authentication error */
    hasError: (state) => !!state.error,
  },
  actions: {
    /**
     * Redirects to backend OAuth endpoint to start Google login
     */
    loginWithGoogle() {
      window.location.href = 'http://localhost:8080/auth/google'
    },

    /**
     * Reads token from URL query and stores it
     * Should be called on app startup or page mount
     */
    handleCallback() {
      this.loading = true
      this.error = null
      try {
        const params = new URLSearchParams(window.location.search)
        const token = params.get('token')
        if (!token) {
          throw new Error('No token found in URL')
        }
        this.setAuthToken(token)
        // Clean up URL
        window.history.replaceState({}, document.title, window.location.pathname)
        return token
      } catch (err) {
        this.error = err.message
        console.error('Callback handling failed:', err)
        return null
      } finally {
        this.loading = false
      }
    },

    /**
     * Stores the JWT token in state and sessionStorage
     * @param {string} authToken - raw JWT token string
     */
    setAuthToken(authToken) {
      this.token = authToken
      this.isAuthenticated = true
      sessionStorage.setItem('authToken', authToken)
    },

    /**
     * Clears the JWT token from state and sessionStorage
     */
    logout() {
      this.token = null
      this.isAuthenticated = false
      sessionStorage.removeItem('authToken')
    },
  },
})
