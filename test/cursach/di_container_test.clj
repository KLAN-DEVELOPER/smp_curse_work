(ns cursach.di-container-test
  (:require [clojure.test :refer :all])
  (:require [cursach.di-container :refer [di_container]])
  (:require [cursach.project-configs :refer [zero_constant_config]])
)

(deftest ->diContainer-GetSavedConfig
  (is (= (.FindConfigByName di_container "zero_constant") zero_constant_config))
)

(deftest ->diContainer-GetObjectParametersFromConfig
  (is (= (.getConfigData di_container "zero_constant" :arguments) {:type :constant, :value 0}))
)

(deftest ->diContainer-GetParameter
  (is (= (.getParameterValue di_container "zero_constant" :type) :constant))
  (is (= (.getParameterValue di_container "zero_constant" :value) 0))
)

(deftest ->diContainer-CreateConstant
  (def constant (.createObject di_container "zero_constant" nil))

  (is (= (.getValue constant) 0))
  (is (= (.getType constant) :constant))
)


(deftest ->diContainer-CreateConjunction
  (def const0 (.createObject di_container "zero_constant" nil))
  (def const (.createObject di_container "constant" nil))

  (def conjunction (.createObject di_container "conjunction" (list const0 const)))
  (is (= (.getValue conjunction) 0))
  (is (= (.getType conjunction) :conjunction))
  (is (= (.getDNF conjunction) "0^1"))
)

(deftest ->diContainer-CreateDisjunction
  (def const0 (.createObject di_container "zero_constant" nil))
  (def const (.createObject di_container "constant" nil))

  (def disjunction (.createObject di_container "disjunction" (list const0 const)))
  (is (= (.getValue disjunction) 1))
  (is (= (.getType disjunction) :disjunction))
  (is (= (.getDNF disjunction) "0v1"))
)

(deftest ->diContainer-CreateImplication
  (def const0 (.createObject di_container "zero_constant" nil))
  (def const (.createObject di_container "constant" nil))

  (def implication (.createObject di_container "implication" (list const0 const)))
  (is (= (.getValue implication) 1))
  (is (= (.getType implication) :implication))
  (is (= (.getDNF implication) "0-->1"))
)

(deftest ->diContainer-CreateNo
  (def const0 (.createObject di_container "zero_constant" nil))

  (def no (.createObject di_container "no" (list const0 "")))
  (is (= (.getValue no) 1))
  (is (= (.getType no) :no))
  (is (= (.getDNF no) "!0"))
)