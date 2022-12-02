(ns aoc.aoc02.02
  (:gen-class)
  (:require [clojure.string :as str]))

(def 🪨📄✂️ (slurp "resources/aoc02input"))

(def tokens
  {"A" :rock
   "B" :paper
   "C" :scissors
   "X" :lose
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

(defn- tokenize[code]
  (map tokens (str/split code #" ")))

(defn- score-round [round]
  (let [outcome (second round)
        hand (choose-outcome round)]
    (+ (outcome-points-map outcome)
       (get-in hands [hand :points]))))

(defn score-all []
  (->> 🪨📄✂️
       (str/split-lines)
       (map tokenize)
       (map score-round)
       (reduce +)))