(ns cursach.variables-test
  (:require [clojure.test :refer :all])
  (:require [cursach.variables :refer [create_variable]])
)


(deftest ->VariableClass-Getters
  (def variable (create_variable "variable"))

  (is (= 1 (.getValue variable)))
  (is (= :variable (.getType variable)))
  (is (= "1" (.getDNF variable)))
)


(deftest ->VariableClass-Setters
  (def variable (create_variable "variable"))

  (.setValue variable 2)
  (is (= 2 (.getValue variable)))
)