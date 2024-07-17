import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../views/HomeView.vue')
    },
    {
      // 매니저 페이지
      path: '/wasabi/970917',
      name: 'manager',
      component: () => import('../views/ManagerView.vue'),
      children: [
        {
          path: '',
          name: 'convention_register',
          component: () => import('@/components/ManagerView/ConventionRegister.vue')
        }
      ]
    }
  ]
})

export default router
