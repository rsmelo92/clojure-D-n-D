(ns main
  (:require [helpers :as helpers])
)

(defn -main 
  "Main method"
  []
  (println "Welcome to Globlin Slayer")

  (def races (get (helpers/getRequest "/api/races") :results))
  (def playerRace (rand-nth races))
  (def playerRaceName (get playerRace :name))

  (println (str "You are a " playerRaceName))

  (def playerRaceDetails (helpers/getRequest (get playerRace :url)))

  (println (str "-" (get playerRaceDetails :alignment)))
  (println (str "-" (get playerRaceDetails :age)))
  (println (str "-" (get playerRaceDetails :size_description)))
  (helpers/pauseGame)

  (def classes (get (helpers/getRequest "/api/classes") :results))
  (def playerClass (rand-nth classes))
  (def playerClassName (get playerClass :name))

  (println (str "Your class is " playerClassName))
  (println (str "You are a " playerRaceName " " playerClassName))
  (helpers/pauseGame)
  
  (println "All you have is a Longsword ")
  (helpers/pauseGame)

  (println "A wild goblin appears!!")
  (helpers/pauseGame)

  (println "Do you wanna slay it? y/n ")

  (def answer (read-line))
  (case answer 
      "y" (println "Goblin Slayed - Mission acomplished")
      "n" (println "The goblin runs away - Mission failed...")
      (println "You got confused and slayed yourself - You are dead"))
  (println "=== GAME OVER ===")
)
