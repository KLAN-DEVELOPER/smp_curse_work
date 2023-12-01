(ns cursach.di-container
  (:require [cursach.project-configs :refer
             [variable_config zero_variable_config
              constant_config zero_constant_config
              ]])
  (:require [cursach.configs.disjunction-config :refer [disjunction_config]])
  (:require [cursach.configs.implication-config :refer [implication_config]])
  (:require [cursach.configs.no-config :refer [no_config]])
  (:require [cursach.configs.conjunction-config :refer [conjunction_config]])
)

(defprotocol getters
  (getConfigData [this name data_type])
  (getParameterValue [this name parameter_name])
)

(defprotocol search_methods
  (FindConfigByName [this name])
)

(defprotocol create_object_method
  (wrappArguments [this arg1_list arg2_list])
  (createObject [this config_name user_arguments])
)

(deftype diContainer [configs]
  getters
  ;метод, который предоставляет доступ к данным конфигов.
  ;@params this указатель на объект, откуда вызывается метод.
  ;@params config_name имя конфига, откуда нужно получить данные.
  ;@params data_type тип данных, к которым нужно получить доступ.
  (getConfigData [this config_name data_type]
    (get (.FindConfigByName this config_name) data_type)
  )
  ;Метод, который возвращает значение аргументов объекта из конфига.
  ;@params this указатель на объект, откуда вызывается метод.
  ;@params config_name имя конфига, откуда нужно получить аргументы объекта.
  ;@params parameter_name название аргумента, к значению которого нужно получить доступ
  (getParameterValue [this config_name parameter_name]
     (get (.getConfigData this config_name :arguments) parameter_name)
  )
  search_methods
  (FindConfigByName [this config_name]
    (first (filter #(= (get % :config_name) config_name) configs))
  )
  create_object_method

  (wrappArguments [this arg1_list arg2_list]
    (apply conj arg1_list (reverse (map second arg2_list)))
  )

  (createObject [this config_name user_arguments]
    (if (list? user_arguments)
      (apply (.getConfigData this config_name :class) (.wrappArguments this user_arguments (.getConfigData this config_name :arguments)) )
      (apply (.getConfigData this config_name :class) (map second (.getConfigData this config_name :arguments)))
    )
  )
)

(defn startDiContainerLifeCycle [configs]
  (diContainer. configs)
)

(def di_container (startDiContainerLifeCycle (list
       zero_variable_config
       variable_config
       zero_constant_config
       constant_config
       conjunction_config
       disjunction_config
       implication_config
       no_config
)))