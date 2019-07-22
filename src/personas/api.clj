(ns personas.api
  (:require [personas.id.ec :as id.ec]))

(defmulti valid-id?
  "Returns true if id is a valid id
  id - map containing
      country        - country ISO code
      identification - string representing the ID number
      type           - the code representing the type of ID in that country"
  {}
  (fn [id]
    (keyword (clojure.string/lower-case (:country id "")))))

(defmethod valid-id? :ec
  [id]
  (id.ec/valid? id))

(defmethod valid-id? :default
  [id]
  false)
