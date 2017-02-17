(ns csv2beancount.parser-test
  (:require [clojure.test :refer :all]
            [csv2beancount.parser :refer :all]
            [clojure.java.io :as io])
  (:use midje.sweet))

(defn res-path[file-name]
  (-> file-name io/resource io/file .getAbsolutePath))

(deftest parser-with-no-transactions-should-print-empty
  (let [csv-path (res-path "empty_transactions.csv")
        yml-path (res-path "simple_transaction_rules.yaml")
        output (with-out-str (convert-csv {:csv-path csv-path :yaml-path yml-path}))]
   (is (= "" output))))
