(defproject co.datil/personas "1.0.0"
  :description "Librería para validación de números de identificación de personas y compañías"
  :url "https://developers.datil.co"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946" :scope "provided"]
                 [proto-repl "0.3.1"]]
  :plugins [[lein-cljsbuild "1.1.7"]]
  :clean-targets ^{:protect false}
  [:target-path
   [:cljsbuild :builds :app :compiler :output-dir]
   [:cljsbuild :builds :app :compiler :output-to]]
  :cljsbuild {:builds {
                       ; :dev
                       ; {:source-paths ["src" "test"]
                       ;  :target :nodejs
                       ;  :compiler
                       ;  {:main "personas.api"
                       ;   :output-to "target/js/lib.js"
                       ;   :output-dir "target/js/out"
                       ;   :asset-path "target/js/out"
                       ;   :source-map true
                       ;   :optimizations :none
                       ;   :pretty-print  true}}

                       :release
                       {:source-paths ["src" "test"]
                        ; :target :nodejs
                        ; :main "personas.js"
                        :compiler
                        {:output-to "dist/js/personas.js"
                         :output-dir "dist/js/out"
                         :asset-path "/js"
                         :optimizations :advanced
                         :pretty-print false}}}})
