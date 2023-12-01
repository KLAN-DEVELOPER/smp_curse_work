(ns cursach.variables
  (:require [cursach.di-container :refer [di_container]])
)

;Генератор переменных.
;@params class_type:Keyword - тип переменной.
;@params value: - значение переменной.
;@return объект, поражденный классом VariableClass. Если параметры не валидны, то вернет исключение.
(defn create_variable [config_name]
    (.createObject di_container config_name nil)
)
