(defproject paa_generator "0.1.0-SNAPSHOT"
  :description "Script gerador de arquivo para disciplina de PAA"
  :license {:name "Do What the Fuck You Want to Public License"
            :url "http://www.wtfpl.net/"}
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :main ^:skip-aot paa-generator.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
