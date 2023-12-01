(ns cursach.constant-test
  (:require [clojure.test :refer :all])
  (:require [cursach.constant :refer [create_constant]])
)

(deftest ->ConstantClass-Getters
  (def constant (create_constant "zero_constant"))

  (is (= 0 (.getValue constant)))
  (is (= :constant (.getType constant)))
  (is (= "0" (.getDNF constant)))
)

