(ns cursach.configs.implication-config
  (:require [cursach.expressions :refer [->ExprClass dnfScopeWrapper]])
)


;Функция расчета значение импликаций.
;@params expr1:(Constant||Variable||Expr) - первое значение импликаций.
;@params expr2:(Constant||Variable||Expr) - второе значение импликаций.
;@return 0, если expr1 = 1 и expr2 = 0. 1 - в противном случае.
(defn getExprValue
  [expr1 expr2]
  (if (and (= 1 (.getValue expr1)) (= 0 (.getValue expr2)))
    0
    1
    )
  )

;Функция расчета ДНФ импликаций.
;@params expr1:(Constant||Variable||Expr) - первое значение импликаций.
;@params expr2:(Constant||Variable||Expr) - второе значение импликаций.
;@return String - ДНФ импликаций.
(defn getDnf
  [expr1 expr2]
  (str (dnfScopeWrapper (.getDNF expr1)) "-->" (dnfScopeWrapper (.getDNF expr2)))
  )


(def implication_config {
   :config_name "implication"
   :class ->ExprClass
   :arguments {
               :class_type :implication
               :getValue getExprValue
               :getDnf getDnf
               }
   }
)