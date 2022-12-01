(ns aoc01.core
  (:gen-class)
  (:require [clojure.string :as str]))

(def 📄 (slurp "input"))

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

(defn -main
  [& args]
  (println (calculate-top-elf-cals)))
