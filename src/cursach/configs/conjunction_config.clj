(ns cursach.configs.conjunction-config
  (:require [cursach.expressions :refer [->ExprClass dnfScopeWrapper]])
)



;Функция расчета значение конъюнкций.
;@params expr1:(Constant||Variable||Expr) - первое значение конъюнкций.
;@params expr2:(Constant||Variable||Expr) - второе значение конъюнкций.
;@return 1 - если оба выражения вернули 1. 0 - в противном случае.
(defn getExprValue
  [expr1 expr2]
  (if (and (= 1 (.getValue expr1)) (= 1 (.getValue expr2)))
    1
    0
    )
  )


;Функция расчета ДНФ конъюнкций.
;@params expr1:(Constant||Variable||Expr) - первое значение конъюнкций.
;@params expr2:(Constant||Variable||Expr) - второе значение конъюнкций.
;@return String - ДНФ конъюнкций.
(defn getDnf
  [expr1 expr2]
  (str (dnfScopeWrapper (.getDNF expr1)) "^" (dnfScopeWrapper (.getDNF expr2)))
  )


(def conjunction_config {
                         :config_name "conjunction"
                         :class ->ExprClass
                         :arguments {
                                     :class_type :conjunction
                                     :getValue getExprValue
                                     :getDnf getDnf
                                     }
                         }
  )