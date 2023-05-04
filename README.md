# INF112 - Prosjekt Top Down Squad

## brukermanual:

* Spillet kjøres fra main.java klassen.

### For å sjekke at spillet funker som det skal:

* trykk på "new game" i main menu for å starte spillet. (på noen pcer er main menu litt irresponsiv, så hvis den ikke reagerer med det første er det bare å prøve igjen.) - spillet skal ihvertall starte til slutt.

* beveg deg mot et tre (eller andre gjenstander som er naturlig at du ikke kan gå forbi) og se at spilleren stopper, og fremdeles kan bevege seg i alle andre retninger der det ikke ligger et objekt.

* trykk på alle tastene som gitt i brukermanualen og sjekk at alle knapper gjør som de skal.

* forsøk å kollidere med den blå figuren som løper frem og tilbake, den såkalte fienden, dersom du ikke holder inne x-tasten skal en gameOver skjerm komme frem.

* forsøk også å angripe fienden mens du holder inne x-tasten. når du da kolliderer med fienden skal fienden forsvinne, spawne et nytt tilfeldig sted på mappet og scoren skal settes opp med 1. 

* forsøk å gå inn døren til huset og se at mappet bytter til et mindre map, går du inn i den svarte boksen overst i rommet skal du kunne gå ut igjen.

## Medlemmer
Team: Sørkanten (Gruppe 8/Team 1)
* Casper Karlsen
* Bjørn Hagen
* Magnus Sponnich Brørby
* Elias Hovdenes
* Hans-Christian Lønne

## Om spillet
Vi vil lage et Rouge-Like 2D spill hvor du ser brettet ovenfra. I spillet må du bekjempe fiender før du kan bevege deg videre til neste rom. Når fiender dør, får spilleren erfaring som man kan bruke i butikken for å oppgradere angrep eller attributter. Fiendene vil bli gradvis sterkere når du avanserer i spillet. Plutselig møter du kanskje på en heftig sjefs-fiende? Målet med spillet er å overleve lengst mulig/fullføre så mange rom som mulig (et rom er fullført når alle fiendene i rommet er beseiret). Når fiendene dør har de en mulighet til å legge fra seg gjenstander som hjelper spilleren. 

## Kjøring
Foreløpig må spille kjøres i en IDE.
Start spillet ved å gjøre main.java

## Keybinds
### Bevegelse: 
- Høyre: "D"
- Venstre: "A"
- Opp: "W"
- Ned: "S"
- Løping: "L.Shift"
### Angrep: 
- Lynangrep: "enter" 
- Pilangrep: "space"
### Øvrige keybinds
* Pause spillet: "Escape"
* Butikk: "TAB" (virker kun i huset! Det er en nettbutikk med lynrask levering)

## Kjente feil
- Fiender kan spawne i hindringer og sette seg fast.

## Credits
- Potions:  Bonsaiheldin https://opengameart.org/content/rpg-potions-16x16
