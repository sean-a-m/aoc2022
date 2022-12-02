(ns aoc.aoc02.02
  (:gen-class)
  (:require [clojure.string :as str]))

(def 🪨📄✂️ (slurp "resources/aoc02input"))

(def rps-map
  {"A" :rock
   "B" :paper
   "C" :scissors})

(def rps-outcome-map
  {"X" :lose
   "Y" :draw
   "Z" :win})

(def outcome-points-map
  {:win 6
   :lose 0
   :draw 3})

(def hands {:rock {:win :paper :lose :scissors :points 1}
            :paper {:win :scissors :lose :rock :points 2}
            :scissors {:win :rock :lose :paper :points 3}})

(defn- choose-outcome [line]
  (let [[hand outcome] line]
    (cond (= outcome :draw) hand
          :else (get-in hands [hand outcome]))))

(defn- map-code [code]
  (let [[hand outcome] (str/split code #" ")]
    (list (rps-map hand) (rps-outcome-map outcome))))

(defn- score-round [round]
  (let [outcome (second round)
        hand (choose-outcome round)]
    (+ (outcome-points-map outcome)
       (get-in hands [hand :points]))))

(defn score-all []
  (->> 🪨📄✂️
       (str/split-lines)
       (map map-code)
       (map score-round)
       (reduce +)))