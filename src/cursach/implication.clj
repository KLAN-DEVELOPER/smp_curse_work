(ns cursach.implication
  (:require [cursach.di-container :refer [di_container]])
)


;Генератор импликаций.
;@params expr1:(Constant||Variable||Expr) - первое значение импликаций.
;@params expr2:(Constant||Variable||Expr) - второе значение импликаций.
;@return объект, поражденный классом ExprClass.
(defn create_implication [expr1 expr2]
  (.createObject di_container "implication" (list expr1 expr2))
)