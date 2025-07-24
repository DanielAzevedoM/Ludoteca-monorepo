import { useAuthStore } from "@/stores/authStore"

export async function getCategoriesData() {
  try {
    const auth = useAuthStore()
    const response = await fetch('http://localhost:8080/categories', {
      headers: {
        Authorization: `Bearer ${auth.getToken}`,
      },
    })
 
    if (!response.ok) throw new Error('Erro ao buscar dados do usuário')

    return await response.json()
  } catch (error) {
    console.error(error)
    return null
  }
}
