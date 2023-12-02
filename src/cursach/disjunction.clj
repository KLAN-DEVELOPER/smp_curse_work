(ns cursach.disjunction
  (:require [cursach.configs.disjunction-config :refer [getExprValue getDnf]])
  (:import (cursach.expressions ExprClass)))

;Генератор дизъюнкций.
;@params expr1:(Constant||Variable||Expr) - первое значение дизъюнкций.
;@params expr2:(Constant||Variable||Expr) - второе значение дизъюнкций.
;@return объект, поражденный классом ExprClass. Если параметры не валидны, то вернет исключение.
(defn create_disjunction [expr1 expr2]
  (ExprClass.  :disjunction getExprValue getDnf expr1 expr2)
)