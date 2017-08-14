(ns dev
  (:require [poll.core :as p]
            [portkey.core :as pk]))

(defn deploy []
  (pk/mount #'p/status "/"
            :content-type "text/html"
            :environment-variables {"db_host" "portkey.c1h3fqcah37y.eu-west-1.rds.amazonaws.com"
                                    "db_user" "portkey"
                                    "db_password" (-> "db_password.txt" slurp (.trim))}
            :keeps #{org.postgresql.geometric.PGcircle
                     org.postgresql.geometric.PGline
                     org.postgresql.geometric.PGpath
                     org.postgresql.geometric.PGpolygon
                     org.postgresql.geometric.PGlseg
                     org.postgresql.util.PGmoney
                     org.postgresql.util.PGInterval}))
