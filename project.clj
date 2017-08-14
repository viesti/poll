(defproject poll "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha15"]
                 [net.cgrand/portkey "0.1.0-SNAPSHOT"]
                 [hiccup "2.0.0-alpha1"]
                 [com.zaxxer/HikariCP "2.6.2"]
                 [org.clojure/java.jdbc "0.7.0"]
                 [org.postgresql/postgresql "42.1.3.jre7"]]
  :profiles {:dev {:source-paths ["dev"]
                   :repl-options {:init-ns dev}}})
