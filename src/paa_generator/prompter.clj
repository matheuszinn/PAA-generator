(ns paa-generator.prompter)

(defn read-end
  []
  (println "Entre com o numero de parada [default=10.000.000]: ")
  (let [n (read-line)]
    (if (not= n "")
      (Integer/parseInt n)
      10000000)))
