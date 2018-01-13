(ns personas.api
  (:require [personas.id.ec :as id.ec]))

(defn valid-id?
  "Returns true if id is a valid id
  id - map containing
      country - country ISO code
      id      - string representing the ID number
      type    - the code representing the type of ID in that country"
  [{:keys [country identification type] :as id}]
  (case country
    "EC" (id.ec/valid-id? id)
    "CO" false
    "PE" false
    "CL" false
    "MX" false
    false))

