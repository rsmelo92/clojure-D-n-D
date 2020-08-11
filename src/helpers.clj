(ns helpers
  (:require [clj-http.client :as http])
  (:require [clojure.data.json :as json])
)

(defn pauseGame 
  "Pause game and wait for enter"
  []
  (println)
  (println "> Press enter to continue <")
  (read-line)
)

(defn convertJson 
  "Convert string to json"
  [json] 
  (json/read-str json :key-fn keyword)
)

(defn convertBody
  "Convert a response body to valid data"
  [response]
  (def bodyResponse (get response :body))
  (convertJson bodyResponse)
)

(defn getRequest
  "Make a get to the D&D API"
  [apiType]
  (def url (str "https://www.dnd5eapi.co" apiType))
  (convertBody (http/get url))
)
