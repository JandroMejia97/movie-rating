# Movie Rating
Se cuenta con un conjunto de datos referente a películas provisto por GroupLens, es un conjunto relativamente pequeño para realizar pruebas, contiene alrededor de 100,000 votos (ratings) aplicados a 9,000 películas y de 600 usuarios (actualizado al 09/2018). El objetivo es generar una interfaz gráfica que permita ver de manera amigable toda esta información.

<img style="text-align:center;" src="https://bn02pap001files.storage.live.com/y4mHpmR-dGH7Lw_71EWC8BBL17xPEgb6gEu2idM-aW-PbUVb2Z4jFkrR5tvHD9g4ePtEMut89Pg4o21Hz23Pb2CrNQeVkYh7tQoPlXS_4U7PSai9qHhh2DTLTXJHhX7RAViXH1ttYk65cBn_EogBSbWn9uyU5-qTXuhstC4rwNo3x4FiEH2p8AfzzX7PZcQHHdV?width=610&height=486&cropmode=none" width="610" height="486" />

A continuación se detalla cada uno de los ítems indicados en el gráfico.

1. **Botón “Procesar Datos”:** Este botón toma datos de archivos (detallados en el punto “Implementación”) y los procesa para tenerlos en memoria, usando las estructuras de datos que mejor se ajustan para resolver este problema. 
Cuando se ingresa a la aplicación, la misma no carga automáticamente los datos debido al tiempo de demora, dado que podría hacer pensar al usuario que la aplicación “se colgó” o no funciona. Se espera que la aplicación muestre la ventana SIN DATOS. El botón Procesar Datos obliga al usuario a indicar que se va a realizar la carga. La barra de progreso que aparece al lado es deseable, pero no obligatoria; sin embargo, sería de utilidad darle un feedback al usuario respecto del avance en el procesamiento de la información.
2. **Datos generales:** una vez procesados los datos mostrará la cantidad de usuarios procesados, la cantidad de películas y votos procesados, el total.
3. **Selector cantidad de datos:** La cantidad de datos a mostrar impactará en los datos mostrados en el ítem 4. Se espera un SELECTOR con los valores: 5,10, 20, 100, 1000, TODOS.
4. **Tabla de resultados:** Representa una tabla con el ranking de películas más votadas. Se espera que use una TABLA ordenada de manera descendente por cantidad de votos. Respecto de su implementación, debería usar la estructura en Java que se ajusta mejor para resolverlo. La posibilidad de ordenamiento por otras columnas en la tabla es opcional.
**_NOTA:_** la cantidad de votos coincidirá con la cantidad de usuarios, si quiere mostrar un promedio de las votaciones de la película, también es correcto. Esto no cambia el objetivo de la consigna.
5. **Histograma:** Muestra un gráfico con la distribución de puntuaciones que se otorgaron a todas las películas. En el caso de las votaciones que incluyen puntaje con decimales (como 3.5 o 4.5), redondee el valor del puntaje.
**_NOTA:_** una versión superadora de este punto, sería que al seleccionar una fila/película de la Tabla de resultados, el histograma muestre datos correspondientes a esa fila/película. Esto es opcional.

## IMPLEMENTACIÓN

Para realizar la implementación ud. posee 2 archivos csv: movies.csv y rating.csv, son archivos de texto donde los datos se encuentran separados por comas, y cada línea en el archivo es información, por ej. una película o un voto. El archivo movies.csv contiene el listado de películas, mientras que rating.csv contiene las votaciones de los usuarios.

Se espera:
* Que procese toda la información almacenada en los archivos usando las estructuras de colecciones vistas en clase de modo de tenerla disponible en memoria.
* Que la carga de información no bloquee la interfaz gráfica, es decir, el proceso de los datos debe ejecutarse en segundo plano. Se sugiere dejar este punto de la implementación de concurrencia entre la gráfica y la carga de datos para el final.
* Que se usen correctamente las estructuras de datos vistas en clase.
* Que las componentes gráficas usadas sean las que mejor se ajustan en base a lo visto en la teoría.

Se sugiere que analice el problema y organice la información que almacenará en memoria. cuando es procesada. Además puede comenzar a trabajar con un subconjunto de los datos disponibles.

## Diagrama UML

A continuación se presenta el diagrama UML de la solución [planteada](https://1drv.ms/u/s!ArdZQlTovHwonb0t3VZBhio8xUVxUA).

<img src="https://bn02pap001files.storage.live.com/y4m6grNdYlB94BooDgYrIu74uqea3wOInLvnX_Y7rASXgX9cAzoeYSQL3zOb9nXmw1XliNcwkldMK2EUpf_TLBUgmFfNHVL0RKm1sIn4-JgJd1Yqaeq65BO3eOs1k1kASGXdkft-1s-8uRmL6Z2ZkRwb6q4C4xVDqiNx7VJSx3fnlvy2hgKAqsNReFBF5xM4KS1?width=1024&height=503&cropmode=none" width="1024" height="503" />
