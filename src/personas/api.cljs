(ns personas.api
  (:require [personas.id.ec :as id.ec]))

(defn valid-id?
  "Returns true if id is a valid id
  id - map containing
      country        - country ISO code
      identification - string representing the ID number
      type           - the code representing the type of ID in that country"
  [id]
  (case (:country id)
    "EC" (id.ec/valid? id)
    "CO" false
    "PE" false
    "CL" false
    "MX" false
    false))


;; Aliases for using personas in JS projects

(defn ^:export isIdValid
  [id]
  (valid-id? (js->clj id :keywordize-keys true)))
