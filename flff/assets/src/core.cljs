(ns <<ns-name>>.app.core
  (:require [dev.flff.system.base :as flff.system]
            [<<ns-name>>.app.state]
            [<<ns-name>>.app.routes :as routes]
            [<<ns-name>>.app.ui.main :as ui.main]))

(def flff-config
  {:on-ready [:bootstrap/init]
   :routes routes/base
   :component ui.main/component-fn
   :dom-node (js/document.getElementById "app")})

(def system-config
  {})

(defonce !system+conf (atom nil))

(defn init! []
  (flff.system/boot! !system+conf flff-config system-config))

(defn after-compile! []
  (flff.system/resume! !system+conf))
