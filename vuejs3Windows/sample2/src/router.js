import {createWebHistory,createRouter} from "vue-router";
import List from './components/ListComponent.vue';
import Home from './components/HomeComponent.vue';
import detail from './components/DetailComponent.vue';
import AuthorComponent from './components/AuthorComponent.vue';
import CommentComponent from './components/CommentComponent.vue';
const routes=[
    {
        path:"/list",
        component:List,
        // component: {
        //     List:List,
        //     Comment: Comment,
        // }

    },
    {
        path:"/",
        component: Home,
    },
    {   // /detail/:id => /detail/아무문자
        // path:"/detail/:id(\\d+)",
        path:"/detail/:id",
        component: detail,
        children: [
            {
                path:"author",
                component: AuthorComponent,
            },
            {
                path:"comment",
                component: CommentComponent,
            }
        ]
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