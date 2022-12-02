(ns aoc.aoc01.02
  (:gen-class)
  (:require [clojure.string :as str]))

(def 📄 (slurp "resources/aoc01input"))

(def 🧝🧝🧝 (str/split 📄 #"\n\n"))

(defn- sumList [🧝]
  (let [calories (str/split-lines 🧝)]
    (reduce +
            (map #(Integer/parseInt %) calories))))

(defn- calculate-top-elf-cals []
  (let [sums (map sumList 🧝🧝🧝)]
    (->> sums
         (sort)
         (reverse)
         (take 3)
         (reduce +))))

(defn aoc01
  [& args]
  (println (calculate-top-elf-cals)))
