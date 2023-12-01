(ns cursach.implication-test
  (:require [clojure.test :refer :all])
  (:require [cursach.implication :refer [create_implication]])
  (:require [cursach.constant :refer [create_constant]])
  (:require [cursach.disjunction :refer [create_disjunction]])
)

(deftest ->ImplicationClass-Getters
  (def constant (create_constant "constant"))
  (def implication (create_implication  constant constant))


  (is (= :implication (.getType implication)))
  (is (= 1 (.getValue implication)))
  (is (= "1-->1" (.getDNF implication)))
)

(deftest ->ImplicationClass-BooleanTable
  (def zero_constant (create_constant "zero_constant"))
  (def constant (create_constant "constant"))

  (is (= 1 (.getValue (create_implication  zero_constant zero_constant))))
  (is (= 0 (.getValue (create_implication  constant zero_constant))))
  (is (= 1 (.getValue (create_implication  zero_constant constant))))
  (is (= 1 (.getValue (create_implication  constant constant))))
)

(deftest ->ImplicationClass-SolveExpr
  (def zero_constant (create_constant "zero_constant"))
  (def constant (create_constant "constant"))

  (def inner_disjunction (create_disjunction  zero_constant zero_constant))
  (def implication (create_implication  inner_disjunction inner_disjunction))


  (is (= :implication (.getType implication)))
  (is (= 1 (.getValue implication)))
)