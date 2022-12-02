(ns aoc01.aoc022
  (:gen-class)
  (:require [clojure.string :as str]))

(def 🪨📄✂️ (slurp "aoc2input"))

(def rps-map 
  {"A" :rock
   "B" :paper
   "C" :scissors})

(def rps-outcome-map
  {"X" :lose
   "Y" :draw
   "Z" :win})

(def rps-points-map
  {:rock 1
   :paper 2
   :scissors 3})

(def outcome-points-map
  {:win 6
   :lose 0
   :draw 3})

(defn- choose-outcome [line]
  (let [[hand outcome] line]
    (cond (= outcome :draw) hand
          (and (= hand :rock) (= outcome :win)) :paper
          (and (= hand :rock) (= outcome :lose)) :scissors
          (and (= hand :scissors) (= outcome :win)) :rock
          (and (= hand :scissors) (= outcome :lose)) :paper
          (and (= hand :paper) (= outcome :win)) :scissors
          (and (= hand :paper) (= outcome :lose)) :rock)))

(defn- map-code [code]
  (let [codes (str/split code #" ")
        hand (rps-map (first codes))
        outcome (rps-outcome-map (second codes))]
    (list hand outcome)))



(defn- score-round [round]
  (let [outcome (second round)
        hand (choose-outcome round)]
    (+ (outcome-points-map outcome)
       (rps-points-map hand))))

(defn score-all []
  (->> 🪨📄✂️
       (str/split-lines)
       (map map-code)
       (map score-round)
       (reduce +)))