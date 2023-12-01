(ns cursach.configs.no-config
  (:require [cursach.expressions :refer [->ExprClass dnfScopeWrapper]])
)

;Функция расчета значение булевого не.
;@params expr:(Constant||Variable||Expr) - переданное выражение для булевого не.
;@return 1, если expr = 0. 0 - если expr = 1.
(defn getExprValue
  [expr1 expr2]
  (if (= 1(.getValue expr1))
    0
    1
    )
  )

;Функция расчета ДНФ булевого не.
;@params expr:(Constant||Variable||Expr) - значение булевого не.
;@return String - ДНФ булевого не.
(defn getDnf
  [expr1 expr2]
  (str "!"(dnfScopeWrapper (.getDNF expr1)))
  )


(def no_config {
   :config_name "no"
   :class ->ExprClass
   :arguments {
               :class_type :no
               :getValue getExprValue
               :getDnf getDnf
               }
   }
)