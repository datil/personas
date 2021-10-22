(ns personas.id.ec)

(def id-card-coeffs [2 1 2 1 2 1 2 1 2])

(def tax-id-code "04")
(def id-card-code "05")

(defn numeric? [s]
  #?(:clj (when-let [s (seq s)]
            (let [s (if (= (first s) \-) (next s) s)
                  s (drop-while #(Character/isDigit %) s)
                  s (if (= (first s) \.) (next s) s)
                  s (drop-while #(Character/isDigit %) s)]
              (empty? s)))
     :cljs (and (not-empty s) (not (js/isNaN s)))))

(defn str->int [s]
  #?(:clj  (try (java.lang.Integer/parseInt s) (catch Exception _))
     :cljs (js/parseInt s)))

(defn char->int [c]
  #?(:clj  (Character/getNumericValue c)
     :cljs (js/parseInt c)))

(defn- sum-non-check-digits
  [id coeffs cap]
  (->> (keep-indexed
        (fn [i digit]
          (let [digit (char->int digit)
                cdigit (* digit (nth coeffs i))]
            (if cap
              (if (> cdigit cap)
                (- cdigit cap)
                cdigit)
              cdigit)))
        id)
       (apply +)))

(defn- calc-check-digit
  [idnum coeffs modulus & [cap]]
  (-> (sum-non-check-digits idnum coeffs cap)
      (* (dec modulus))
      (mod modulus)))

(defn tax-id-type
  [id]
  (let [third-digit (str->int (subs id 2 3))]
    (if (= 9 third-digit)
      :private
      (if (and (= 6 third-digit)
               (= "000" (subs id 9 12)))
        :public
        :personal))))

(defn valid-identity-card?
  [id]
  (if (and (numeric? id) (= (count id) 10))
    (let [check-digit (calc-check-digit (subs id 0 9) id-card-coeffs 10 9)
          id-check-digit (str->int (subs id 9 10))]
      (= check-digit id-check-digit))
    false))

(defn valid-tax-id?
  [{:keys [identification]}]
  (and (numeric? identification) (= (count identification) 13)))

(defn valid?
  "Returns true if id is a valid id
  id - map containing
      country        - country ISO code
      identification - string representing the ID number
      type           - the code representing the type of ID in that country"
  [{:keys [identification type] :as id}]
  (case type
    "04" (valid-tax-id? id)
    "05" (valid-identity-card? identification)
    true))

;; JS support

(def ^:export TAX-ID tax-id-code)
(def ^:export ID-CARD id-card-code)

;; used for building node module

(def constants
  {:TAX-ID TAX-ID
   :ID-CARD ID-CARD})
