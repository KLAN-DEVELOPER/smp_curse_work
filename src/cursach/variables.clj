(ns cursach.variables
  (:require [cursach.project-configs])
  (:import (cursach.project_configs VariableClass)))

;Генератор переменных.
;@params class_type:Keyword - тип переменной.
;@params value: - значение переменной.
;@return объект, поражденный классом VariableClass. Если параметры не валидны, то вернет исключение.
(defn create_variable [value]
    (VariableClass. :variable  value)
)
