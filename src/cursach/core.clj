(ns cursach.core
  (:require [cursach.constant :refer [create_constant]])
  (:require [cursach.variables :refer [create_variable]])
  (:require [cursach.conjunction :refer [create_conjunction]])
  (:require [cursach.disjunction :refer [create_disjunction]])
  (:require [cursach.implication :refer [create_implication]])
  (:require [cursach.no :refer [create_no]])
)


(def const0 (create_constant 0))
(def const (create_constant 1))
(def var0 (create_variable 0))
(def var (create_variable 1))


(def inner_implication (create_implication var var0))
(def inner_conjunction (create_conjunction inner_implication var))
(def inner_disjunction (create_disjunction inner_conjunction var0))
(def no (create_no  inner_disjunction))

(println (.getDNF inner_implication))
(println (.getDNF inner_conjunction))
(println (.getDNF inner_disjunction))
(println (.getDNF no))
