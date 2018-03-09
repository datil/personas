# personas [![Build Status](https://travis-ci.org/datil/personas.svg?branch=master)](https://travis-ci.org/datil/personas)

Librería para validación de números de identificación de personas y compañías

## Uso

```clojure
(ns my.app
  (:require [personas.api :as personas]
            [personas.id.ec :as personas-ec]))

(if (personas/valid-id? {:identification "1002304005"
                         :type personas-ec/id-card-code
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

Distribuido bajo licencia [Eclipse Public License](https://github.com/datil/personas/blob/master/LICENSE).
