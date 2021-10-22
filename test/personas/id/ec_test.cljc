(ns personas.id.ec-test
  (:require [clojure.test :refer [deftest is]]
            [personas.api :as sut]
            [personas.id.ec :as id-ec]))

(deftest valid-identity-card
  (is (= (sut/valid-id? {:identification "0924447956"
                         :country "EC"
                         :type id-ec/id-card-code})
         true)))

(deftest invalid-identity-card
  (is (= (sut/valid-id? {:identification "1234567890"
                         :country "EC"
                         :type id-ec/id-card-code})
         false)))

(deftest identity-card-with-invalid-legth
  (is (= (sut/valid-id? {:identification "092444795"
                         :country "EC"
                         :type id-ec/id-card-code})
         false)))

(deftest unkown-tax-id-type
  (is (= (sut/valid-id? {:identification "xxxxxxxxxxxxxxxxx"
                         :country "EC"
                         :type "999"})
         true)))

(deftest valid-tax-id
  (is (= (sut/valid-id? {:identification "0924447955001"
                         :country "EC"
                         :type id-ec/tax-id-code})
         true)))

(deftest invalid-tax-id
  (is (= (sut/valid-id? {:identification "123456789012"
                         :country "EC"
                         :type id-ec/tax-id-code})
         false)))