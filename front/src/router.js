// import Vue from "vue";
import {createRouter, createWebHistory} from "vue-router";
import Home from "./views/Home";
import About from "./views/About";

// Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        component: Home
    },
    {
        path: '/about',
        component: About
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
