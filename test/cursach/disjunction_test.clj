(ns cursach.disjunction-test
  (:require [clojure.test :refer :all])
  (:require [cursach.constant :refer [create_constant]])
  (:require [cursach.disjunction :refer [create_disjunction]])
  (:require [cursach.conjunction :refer [create_conjunction]])
)

(deftest ->DisjunctionClass-Getters
  (def constant (create_constant "constant"))
  (def disjuntion (create_disjunction  constant constant))


  (is (= :disjunction (.getType disjuntion)))
  (is (= 1 (.getValue disjuntion)))
  (is (= "1v1" (.getDNF disjuntion)))
)

(deftest ->DisjunctionClass-BooleanTable
  (def zero_constant (create_constant "zero_constant"))
  (def constant (create_constant "constant"))


  (is (= 0 (.getValue (create_disjunction  zero_constant zero_constant))))
  (is (= 1 (.getValue (create_disjunction  constant zero_constant))))
  (is (= 1 (.getValue (create_disjunction  zero_constant constant))))
  (is (= 1 (.getValue (create_disjunction  constant constant))))
)

(deftest ->DisjunctionClass-SolveExpr
  (def zero_constant (create_constant "zero_constant"))
  (def constant (create_constant "constant"))

  (def inner_conjuntion (create_conjunction  zero_constant zero_constant))
  (def disjunction (create_disjunction  constant inner_conjuntion))


  (is (= :disjunction (.getType disjunction)))
  (is (= 1 (.getValue disjunction)))
)
