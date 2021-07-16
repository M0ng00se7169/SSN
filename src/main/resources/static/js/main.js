import Vue from 'vue'
import VueResource from 'vue-resource'
import Vuetify from "vuetify";
import 'vuetify/dist/vuetify.min.css'

import App from 'pages/App.vue'
import { connect } from "./util/ws";

if (frontendData.profile) {
    connect()
}

Vue.use(Vuetify)
Vue.use(VueResource)

new Vue({
    el: '#app',
    render: a => a(App)
})

