(ns poll.core
  (:require [hiccup2.core :as h]
            [clojure.java.jdbc :as jdbc])
  (:import [com.zaxxer.hikari HikariDataSource]))

(def datasource
  (delay ;; so that we get to read environment variables at lambda runtime, not compile time
   (Class/forName "org.postgresql.Driver") ;; to catch driver class in analysis
   (doto (HikariDataSource.)
     (.setJdbcUrl (str "jdbc:postgresql://" (System/getenv "db_host") ":5432/portkey"))
     (.setUsername (System/getenv "db_user"))
     (.setPassword (System/getenv "db_password")))))

(defn status []
  (h/html
    [:html
     [:body
      [:h1 "Current polls"]
      [:table
       (for [{:keys [poll vote count]} (jdbc/query #_(str "jdbc:postgresql://" (System/getenv "db_host") ":5432/portkey?user=portkey&password=" (System/getenv "db_password"))
                                                   {:datasource @datasource}
                                                   ["select poll,vote,count(vote) from votes group by poll,vote order by poll"])]
         [:tr
          [:td poll]
          [:td vote]
          [:td count]])]]]))
