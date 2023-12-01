(ns cursach.conjunction-test
  (:require [clojure.test :refer :all])
  (:require [cursach.conjunction :refer [create_conjunction]])
  (:require [cursach.constant :refer [create_constant]])
)

(deftest ->ConjunctionClass-Getters
  (def constant (create_constant "constant"))
  (def conjuntion (create_conjunction constant constant))


  (is (= :conjunction (.getType conjuntion)))
  (is (= 1 (.getValue conjuntion)))
  (is (= "1^1" (.getDNF conjuntion)))
)

(deftest ->ConjunctionClass-BooleanTable
  (def zero_constant (create_constant "zero_constant"))
  (def constant (create_constant "constant"))



  (is (= 0 (.getValue (create_conjunction  zero_constant zero_constant))))
  (is (= 0 (.getValue (create_conjunction  constant zero_constant))))
  (is (= 0 (.getValue (create_conjunction  zero_constant constant))))
  (is (= 1 (.getValue (create_conjunction  constant constant))))
  )



(deftest ->ConjunctionClass-SolveExpr
  (def zero_constant (create_constant "zero_constant"))
  (def constant (create_constant "constant"))

  (def inner_conjuntion (create_conjunction  zero_constant zero_constant))
  (def conjuntion (create_conjunction  constant inner_conjuntion))


  (is (= :conjunction (.getType conjuntion)))
  (is (= 0 (.getValue conjuntion)))
)
