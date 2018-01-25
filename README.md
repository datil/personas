# personas [![Build Status](https://travis-ci.org/datil/personas.svg?branch=master)](https://travis-ci.org/datil/personas)

Librería para validación de números de identificación de personas y compañías

## Uso

```clojure
(require '[personas.api :as personas])

(if (personas/valid-id? {:identification "1002304005"
                         :type "99"
                         :country "EC"})
  (print "¡Listo!")
  (print "Por favor escribe un número de cédula válida"))

```

## Desarrollo

Clona el repositorio y listo

```shell
$ git clone https://github.com/datil/personas.git
```

### Pruebas

```shell
$ lein test
```

## Licencia

Copyright © 2018 Datilmedia S.A.

Distribuido bajo licencia Eclipse Public License versión 1.0 o superior.
