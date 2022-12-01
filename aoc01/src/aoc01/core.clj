(ns aoc01.core
  (:gen-class)
  (:require [clojure.string :as str]))

(def 📄 (slurp "input"))

(def 🧝🧝🧝 (str/split 📄 #"\n\n"))

(defn- sumList [list]
  (let [nums (str/split-lines list)]
    (reduce +
            (map #(Integer/parseInt %) nums))))

(defn- calculate-elf-cals []
  (let [sums (map sumList 🧝🧝🧝)]
    (->> sums
         (sort)
         (reverse)
         (take 3)
         (reduce +))))

(defn -main
  [& args]
  (println (calculate-elf-cals)))

(comment (let [sums (map sumList 🧝🧝🧝)]
           (->> sums
                (sort)
                (reverse)
                (take 3)
                (reduce +))))

