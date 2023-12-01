(ns cursach.disjunction
  (:require [cursach.di-container :refer [di_container]])
)

;Генератор дизъюнкций.
;@params expr1:(Constant||Variable||Expr) - первое значение дизъюнкций.
;@params expr2:(Constant||Variable||Expr) - второе значение дизъюнкций.
;@return объект, поражденный классом ExprClass. Если параметры не валидны, то вернет исключение.
(defn create_disjunction [expr1 expr2]
  (.createObject di_container "disjunction" (list expr1 expr2))
)