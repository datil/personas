# personas [![Build Status](https://travis-ci.org/datil/personas.svg?branch=master)](https://travis-ci.org/datil/personas)

Librería para validación de números de identificación de personas y compañías

## Uso

```js
var personas = require('@datil/personas');

var id = {
  identification: "9999999999999",
  type: personas.TAX_ID, // RUC
  country: "EC"
}

if (personas.isIdValid(id)) {
  console.log("Válida!!");
}
else {
  console.log(";( el RUC no es válido");
}
```

## Licencia

Copyright © 2018 Datilmedia S.A.

Distribuido bajo licencia [Eclipse Public License](https://github.com/datil/personas/blob/master/LICENSE).
