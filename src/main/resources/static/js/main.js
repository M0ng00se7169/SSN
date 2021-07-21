import Vue from 'vue'
import Vuetify from "vuetify";
import '@babel/polyfill'
import 'api/resource'
import router from 'router/router'
import App from 'pages/App.vue'
import store from 'store/store'
import { connect } from "./util/ws";
import 'vuetify/dist/vuetify.min.css'
import * as Sentry from "@sentry/vue";
import * as SentryBrowser from "@sentry/browser"
import { Integrations } from "@sentry/tracing";

Sentry.init({
    Vue,
    dsn: "https://89ffc50752a945398687e60c83080e25@o925304.ingest.sentry.io/5874095",
    integrations: [new Integrations.BrowserTracing()],

    // Set tracesSampleRate to 1.0 to capture 100%
    // of transactions for performance monitoring.
    // We recommend adjusting this value in production
    tracesSampleRate: 1.0,
});

SentryBrowser.configureScope(scope => {
    scope.setUser({
        id: profile && profile.id,
        username: profile && profile.name,
    })
})

if (profile) {
    connect()
}

Vue.use(Vuetify)

new Vue({
    el: '#app',
    store,
    router,
    render: a => a(App)
})

