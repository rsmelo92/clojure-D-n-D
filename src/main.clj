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
  
  (def playerClassDetails (helpers/getRequest (get playerClass :url)))
  
  (def equipmentUrl (get-in playerClassDetails [:starting_equipment :url]))
  (def equipmentOptions (get (helpers/getRequest equipmentUrl) :starting_equipment_options))
  (println equipmentOptions)
)
