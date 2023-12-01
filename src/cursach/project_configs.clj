(ns cursach.project-configs
  (:require [cursach.expressions :refer [->ExprClass dnfScopeWrapper]])
  (:import (cursach.expressions  ExprGetters ExprSetters))
)




;Класс, содержащий интерфейс переменных.
;@params class_type:Keyword - тип класса.
;@params value: - значение переменной.
(deftype VariableClass [class_type  ^{:volatile-mutable true} value]
  ExprGetters
  (getValue [this] value)
  (getType [this] class_type)
  (getDNF [this] (str value))
  ExprSetters
  (setValue [this new_value] (set! value new_value))
  )


;Класс, содержащий интерфейс констант. Константы не могут менять свой значения.
;@params class_type:Keyword - тип класса.
;@params value: - значение константы.
(deftype ConstantClass [class_type value]
  ExprGetters
  (getValue [this] value)
  (getType [this] class_type)
  (getDNF [this] (str value))
  )



(def zero_constant_config {
                           :config_name "zero_constant"
                           :class ->ConstantClass
                           :arguments {
                                       :type  :constant
                                       :value 0
                                       }
                           }
  )

(def constant_config {
                      :config_name "constant"
                      :class ->ConstantClass
                      :arguments {
                                  :type  :constant
                                  :value 1
                                  }
                      }
  )


(def zero_variable_config {
       :config_name "zero_variable"
       :class ->VariableClass
       :arguments {
                   :type  :variable
                   :value 0
                   }
       }
)

(def variable_config {
       :config_name "variable"
       :class ->VariableClass
       :arguments {
                   :type  :variable
                   :value 1
                   }
       }
)



