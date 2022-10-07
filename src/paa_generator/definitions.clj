(ns paa-generator.definitions
  (:require [paa-generator.prompter :refer [read-end]]))

(def end-value (read-end))

(def output_path (str (System/getProperty "user.dir") "/output/"))

(def increase-amount
  (atom 1000))