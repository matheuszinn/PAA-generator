(ns paa-generator.core
  (:gen-class)
  (:require [clojure.java.io :as io]
            [paa-generator.definitions :as defs]))

(defn dump
  [s]
  (let [name (get s :name)
        seq (get s :seq)
        filename (str name "_" (count seq))
        filepath (str defs/output_path filename)]
    (io/make-parents filepath)
    (println "Gerando o arquivo: " filename)
    (spit filepath seq)))

(defn generate-files
  [number]
  (let [ord {:name "ord" :seq (-> number range vec)}
        rev {:name "rev" :seq (-> number range reverse vec)}
        rand {:name "rand" :seq (-> number range shuffle vec)}]
    (dump ord)
    (dump rev)
    (dump rand)))

(defn start-process
  []
  (loop [i 0]
    (when (<= i defs/end-value)
      (if (= i (* 10 @defs/increase-amount))
        (do
          (generate-files i)
          (reset! defs/increase-amount (* 10 @defs/increase-amount)))
        (if (not= i 0)
          (generate-files i)
          ()))
      (recur (+ i @defs/increase-amount)))))


(defn -main
  []
  (println "Caminho de saída: " defs/output_path)
  (time (start-process))
  (println "Terminado, os arquivos foram criados!!"))