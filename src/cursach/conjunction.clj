(ns cursach.conjunction
  (:require [cursach.di-container :refer [di_container]])
)

;Генератор конъюнкций.
;@params expr1:(Constant||Variable||Expr) - первое значение конъюнкций.
;@params expr2:(Constant||Variable||Expr) - второе значение конъюнкций.
;@return объект, поражденный классом ExprClass.
(defn create_conjunction [expr1 expr2]
  (.createObject di_container "conjunction" (list expr1 expr2))
)