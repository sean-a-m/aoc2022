(ns aoc01.aoc02
  (:gen-class)
  (:require [clojure.string :as str]))

(def 🪨📄✂️ (slurp "aoc2input"))

(def rps-map 
  {"A" :rock
   "B" :paper
   "C" :scissors
   "X" :rock
   "Y" :paper
   "Z" :scissors})

(def rps-points-map
  {:rock 1
   :paper 2
   :scissors 3})

(def outcome-points-map
  {:win 6
   :lose 0
   :draw 3})

(defn- match-outcome [line]
  (let [[p1 p2] line]
    (cond(= p1 p2) :draw
         (and (= p1 :rock) (= p2 :scissors)) :win
         (and (= p1 :rock) (= p2 :paper)) :lose
         (and (= p1 :scissors) (= p2 :rock)) :lose
         (and (= p1 :scissors) (= p2 :paper)) :win
         (and (= p1 :paper) (= p2 :rock)) :win
         (and (= p1 :paper) (= p2 :scissors)) :lose)))

(defn- map-code [code]
(reverse
  (map #(rps-map %)
       (str/split code #" "))))

(defn- score-round [round]
  (let [outcome (match-outcome round)]
    (+ (outcome-points-map outcome)
       (rps-points-map (first round)))))

(defn score-all []
  (->> 🪨📄✂️
       (str/split-lines)
       (map map-code)
       (map score-round)
       (reduce +)))