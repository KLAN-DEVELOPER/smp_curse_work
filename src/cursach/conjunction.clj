(ns cursach.conjunction
  (:require [cursach.configs.conjunction-config :refer [getExprValue getDnf]])
  (:require [cursach.expressions])
  (:import (cursach.expressions ExprClass)))

;Генератор конъюнкций.
;@params expr1:(Constant||Variable||Expr) - первое значение конъюнкций.
;@params expr2:(Constant||Variable||Expr) - второе значение конъюнкций.
;@return объект, поражденный классом ExprClass.

(defn create_conjunction [expr1 expr2]
  (ExprClass. :conjunction getExprValue getDnf expr1 expr2)
)