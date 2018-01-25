(ns personas.id.ec-test
  (:require [clojure.test :refer :all]
            [personas.id.ec :as id.ec]))

(deftest valid-identity-card
  (is (= (id.ec/valid-id? {:identification "0924447956"
                           :country "EC"
                           :type "05"})
         true)))

(deftest invalid-identity-card
  (is (= (id.ec/valid-id? {:identification "1234567890"
                           :country "EC"
                           :type "05"})
         false)))

(deftest identity-card-with-invalid-legth
  (is (= (id.ec/valid-id? {:identification "092444795"
                           :country "EC"
                           :type "05"})
         false)))

(deftest valid-private-company-tax-id
  (is (= (id.ec/valid-id? {:identification "1790016919001"
                           :country "EC"
                           :type "04"})
         true)))

(deftest private-company-tax-id-with-invalid-ending
  (is (= (id.ec/valid-id? {:identification "1790016919000"
                           :country "EC"
                           :type "04"})
         false)))

(deftest private-company-tax-id-with-invalid-check-digit
  (is (= (id.ec/valid-id? {:identification "1790016918001"
                           :country "EC"
                           :type "04"})
         false)))

(deftest valid-public-company-tax-id
  (is (= (id.ec/valid-id? {:identification "0968522230001"
                           :country "EC"
                           :type "04"})
         true)))

(deftest public-company-tax-id-with-invalid-check-digit
  (is (= (id.ec/valid-id? {:identification "0160000280001"
                           :country "EC"
                           :type "04"})
         false)))

(deftest public-company-tax-id-with-invalid-ending
  (is (= (id.ec/valid-id? {:identification "0160000270000"
                           :country "EC"
                           :type "04"})
         false)))

(deftest public-company-tax-id-with-invalid-length
  (is (= (id.ec/valid-id? {:identification "016000027000"
                           :country "EC"
                           :type "04"})
         false)))

(deftest unkown-tax-id-type
  (is (= (id.ec/valid-id? {:identification "xxxxxxxxxxxxxxxxx"
                           :country "EC"
                           :type "999"})
         true)))
