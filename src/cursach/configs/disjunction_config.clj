(ns cursach.configs.disjunction-config
  (:require [cursach.expressions :refer [->ExprClass dnfScopeWrapper]])
  )



;Функция расчета значение дизъюнкций.
;@params expr1:(Constant||Variable||Expr) - первое значение дизъюнкций.
;@params expr2:(Constant||Variable||Expr) - второе значение дизъюнкций.
;@return 1, если (0v1)||(1v0)||(1v1). 0 - в противном случае.
(defn getExprValue
  [expr1 expr2]
  (if (or (= 1 (.getValue expr1)) (= 1 (.getValue expr2)))
    1
    0
    )
  )

;Функция расчета ДНФ дизъюнкций.
;@params expr1:(Constant||Variable||Expr) - первое значение дизъюнкций.
;@params expr2:(Constant||Variable||Expr) - второе значение дизъюнкций.
;@return String - ДНФ дизъюнкций.
(defn getDnf
  [expr1 expr2]
  (str (dnfScopeWrapper (.getDNF expr1)) "v" (dnfScopeWrapper (.getDNF expr2)))
  )


(def disjunction_config {
   :config_name "disjunction"
   :class ->ExprClass
   :arguments {
               :class_type :disjunction
               :getValue getExprValue
               :getDnf getDnf
               }
   }
)