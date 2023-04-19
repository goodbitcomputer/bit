import Vue from 'vue'
import App from "@/App.vue";
import Vuex from 'vuex';
import router from './router';
import store from "core-js/internals/shared-store";

new Vue({
    Vuex,
    store,
    router,
    render: h => h(App)
}).$mount('#app');