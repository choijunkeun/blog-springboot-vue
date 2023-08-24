// import Vue from "vue";
import {createRouter, createWebHistory} from "vue-router";
import Home from "@/views/Home";
import About from "@/views/About";
import PostList from '@/views/post/PostList'
import PostDetail from "@/views/post/PostDetail";

// Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        name: 'home',
        component: Home
    },
    {
        path: '/about',
        name: 'about',
        component: About
    },
    {
        path: '/post/list',
        name: 'postList',
        component: PostList
    },
    {
        path: '/post/detail',
        name: 'postDetail',
        component: PostDetail
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
