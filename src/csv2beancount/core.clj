(ns csv2beancount.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [csv2beancount.parser :refer [convert-csv]]
            [csv2beancount.validator :refer [validate-params]])
  (:gen-class))

(def ^:private cli-options
  [["-c" "--csv CSV" "Csv Path"]
   ["-y" "--yaml Yaml" "Yaml Path"]
   ["-h" "--help"]])

(defn- print-transactions [transactions]
 (doseq [x transactions] (println x)))

(defn run-program [params]
  (some-> params
          validate-params
          convert-csv
          print-transactions))

(defn -main [& args]
  (run-program (parse-opts args cli-options)))
