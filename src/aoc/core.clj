(ns aoc.core
  (:gen-class)
  (:require [clojure.string :as str]
            [aoc.aoc01.02 :as aoc0102]
            [aoc.aoc02.01 :as aoc0201]
            [aoc.aoc02.02 :as aoc0202]))

(defn -main
  [& args]
  (println (aoc0202/score-all)))
