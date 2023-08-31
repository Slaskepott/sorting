#            ***README***
## Litt om programmet
Formålet med programmet er
- Å demonstrere en datastruktur (teque), som er en en kø med tre innsettingsmetoder, push_front, push_back og push_middle
- Implementasjon av to sorteringsalgoritmer, insertion sort og merge sort.
- Visualisere og analysere tids- og kjøretidskompleksitet relativt til arrayets størrelse.

Programmet er skrevet i java, og leverer output i .out-filformat. Dataene kan lagres som csv og bearbeides i andre verktøy, f.eks. Excel.

Programmet kan kjøre i to moduser:
- Modus 1 tar filer fra mappen input, og genererer sorterte .out-filer
- Modus 2 sammenligner to sorteringsalgoritmer og genererer en relasjonell database som hvordan antall sammenligninger, bytter og tid vokser relativt til arrayets størrelse

## Bruksanvisning
Programmet tar tre argumenter i CLI. Programmet gjør **ingen input-validering** og brukeren må derfor være nøye med å formatere input eksakt.

ENTEN:
[0] Eksakt streng, enten "random" eller "nearly_sorted"
[1] Eksakt streng, enten "10","100","1000","10000","100000" eller "1000000"
[2] Eksakt streng, enten "insertion" eller "merge"

ELLER:
[0] Eksakt streng, "compare"
[1] Eksakt streng, enten "random" eller "nearly_sorted"
[2] Eksakt streng, enten "10","100","1000","10000","100000" eller "1000000"

For eksempel
### java Sort nearly_sorted 1000 merge
Genererer en .out-fil bestående av en sortert liste av datasettet nearly_sorted_1000
### java Sort compare random 100
Genererer en .out-fil bestående av 100 linjer med data.
