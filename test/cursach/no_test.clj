(ns cursach.no-test
  (:require [clojure.test :refer :all])
  (:require [cursach.constant :refer [create_constant]])
  (:require [cursach.disjunction :refer [create_disjunction]])
  (:require [cursach.conjunction :refer [create_conjunction]])
  (:require [cursach.no :refer [create_no]])
)

(deftest ->NoExprClass-Getters
  (def constant (create_constant "constant"))
  (def no (create_no constant))


  (is (= :no (.getType no)))
  (is (= 0 (.getValue no)))
)

(deftest ->NoExprClass-BooleanTable
  (def constant (create_constant "constant"))
  (def zero_constant (create_constant "zero_constant"))

  (is (= 0 (.getValue (create_no  constant))))
  (is (= 1 (.getValue (create_no  zero_constant))))
)

(deftest ->NoExprClass-SolveExpr
  (def constant (create_constant "constant"))
  (def zero_constant (create_constant "zero_constant"))
  (def conjunction (create_conjunction  constant constant))
  (def disjunction (create_disjunction  conjunction zero_constant))
  (def no (create_no  disjunction))

  (is (= 0 (.getValue no)))
  (is (= :no (.getType no)))
)
