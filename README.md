# Project: <BR> Aplikacja sklepu z trzema profilami.
___
Projekt został napisany w javie 11 z urzyciem narzędzia maven w wersji 4.0. i jest aplikacją konsolową.


W celu uruchomienia programu proszę wykonać poniższą komendę w systemie windows:\
```
> git clone https://github.com/poplar82/shop.git && cd shop && git checkout tags/solution && compile && run [profile]
```
lub dla systemów linux, iOS:
```
$ git clone https://github.com/poplar82/shop.git && cd shop && git checkout tags/solution && ./compile.sh && ./run.sh [profile]
```
___
#### Treść zadania
___
Zaimplementuj sklep internetowy, który oferuje 3 warianty.
- Podstawową funkcjonalnością jaką posiada każdy sklep jest wariant „default” (nie trzeba podawac tego profilu jako argumentu podczas uruchamiania aplikacji).
Umożliwia on na dodawanie produktów do koszyka (produkt przechowuje nazwę i cenę), oraz na ich podstawie wypisywać na oknie konsoli cenę wszystkich produktów.
- Pakiet „plus” dodatkowo umożliwia doliczenie do ceny wynikowej podatku VAT. Stawka podatku VAT ma zostać uwzględniona w pliku konfiguracyjnym.
- Pakiet „pro” oprócz wyliczania podatku ma również możliwość wyliczenia rabatu, którego wartość jest uwzględniona w pliku konfiguracyjnym.

Aplikacja na start dodaje 5 dowolnych produktów z losowaną ceną (w przedziale 50-300 zł) i wyświetla ich sumaryczną cenę.