(ns cursach.no
  (:require [cursach.configs.no-config :refer [getExprValue getDnf]])
  (:import (cursach.expressions ExprClass)))

;Генератор булевого не.
;@params expr:(Constant||Variable||Expr) -  значение булевого не.
;@return объект, поражденный классом ExprClass.
(defn create_no [expr]
  (ExprClass. :no getExprValue getDnf expr "")
  )