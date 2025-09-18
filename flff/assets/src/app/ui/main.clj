(ns <<ns-name>>.app.ui.main
  (:require [dev.flff.ui.base :refer [defui $]]))

(defui app []
  ($ :h1 "hello world"))

(def component-fn #($ app))

