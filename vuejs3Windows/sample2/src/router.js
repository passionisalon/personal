import {createWebHistory,createRouter} from "vue-router";
import List from './components/ListComponent.vue';
import Home from './components/HomeComponent.vue';
import detail from './components/DetailComponent.vue';
const routes=[
    {
        path:"/list",
        component: List,
    },
    {
        path:"/",
        component: Home,
    },
    {   // /detail/:id => /detail/아무문자
        path:"/detail/:id(\\d+)",
        component: detail,
    },
    // {
    //     path:"/:anything(.*)",
    //     component: Home,
    // },    
    {
        // path:
        // component:
    },
];

const router = createRouter({
    history:createWebHistory(),
    routes,
});

export default router;