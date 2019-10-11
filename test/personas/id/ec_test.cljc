(ns personas.id.ec-test
  (:require [clojure.test :refer :all]
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

(deftest valid-private-company-tax-id
  (is (= (sut/valid-id? {:identification "1790016919001"
                         :country "EC"
                         :type id-ec/tax-id-code})
         true)))

(deftest private-company-tax-id-with-invalid-ending
  (is (= (sut/valid-id? {:identification "1790016919000"
                         :country "EC"
                         :type id-ec/tax-id-code})
         false)))

(deftest private-company-tax-id-with-invalid-check-digit
  (is (= (sut/valid-id? {:identification "1790016918001"
                         :country "EC"
                         :type id-ec/tax-id-code})
         false)))

(deftest valid-public-company-tax-id
  (is (= (sut/valid-id? {:identification "0968522230001"
                         :country "EC"
                         :type id-ec/tax-id-code})
         true)))

(deftest public-company-tax-id-with-invalid-check-digit
  (is (= (sut/valid-id? {:identification "0160000280001"
                         :country "EC"
                         :type id-ec/tax-id-code})
         false)))

(deftest public-company-tax-id-with-invalid-ending
  (is (= (sut/valid-id? {:identification "0160000270000"
                         :country "EC"
                         :type id-ec/tax-id-code})
         false)))

(deftest public-company-tax-id-with-invalid-length
  (is (= (sut/valid-id? {:identification "016000027000"
                         :country "EC"
                         :type id-ec/tax-id-code})
         false)))

(deftest unkown-tax-id-type
  (is (= (sut/valid-id? {:identification "xxxxxxxxxxxxxxxxx"
                         :country "EC"
                         :type "999"})
         true)))

(deftest valid-personal-company-tax-id
  (is (= (sut/valid-id? {:identification "0924447956001"
                         :country "EC"
                         :type id-ec/tax-id-code})
         true)))

(deftest invalid-personal-company-tax-id
  (is (= (sut/valid-id? {:identification "1234567890"
                         :country "EC"
                         :type id-ec/tax-id-code})
         false)))

(deftest personal-company-tax-id-with-invalid-legth
  (is (= (sut/valid-id? {:identification "092444795"
                         :country "EC"
                         :type id-ec/tax-id-code})
         false)))

(deftest personal-company-tax-id-that-looks-like-a-public-company-tax-id
  (is (= (sut/valid-id? {:identification "0962378600001"
                         :country "EC"
                         :type id-ec/tax-id-code})
         true)))

(deftest invalid-not-numeric-id
  (is (= (sut/valid-id? {:identification "09623786OO001"
                         :country "EC"
                         :type id-ec/tax-id-code})
         false)))
