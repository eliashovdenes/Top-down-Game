# INF112 - Top Down Squad

## Medlemmer
Team: Top Down Squad (Gruppe 8)
* Casper Karlsen
* Bjørn Hagen
* Magnus Sponnich Brørby
* Elias Hovdenes
* Hans-Christian Lønne

## Om spillet
Vi vil lage et Rouge Like 2D spill hvor du ser brettet ovenfra. I spillet må du beseire fiender før du kan bevege deg videre til neste rom. Fiendene vil bli gradvis sterkere når du avanserer i spillet. Målet med spillet er å overleve lengst mulig/fullføre så mange rom som mulig (et rom er fullført når alle fiendene i rommet er beseiret). Når fiendene dør har de en mulighet til å legge fra seg gjenstander som hjelper spilleren. 

## Konsept

* Spillfigur som kan beveges i åtte retninger (nord, sør, øst, vest, samt diogonalt i alle retninger)
* Todimensjonal verden:
    * Topdown - vi ser karakteren ovenfra
    * Avgrenset spillområde med vegger som spilleren ikke kan passere
    * Bygget opp av blokker med en fast størrelse i et rutenett. Spilleren og fiendene beveger seg oppå rutenettet
    * Noen blokker kan spilleren gå over, andre blokker kan spilleren ikke passere
    
* Fiender som beveger seg og skader spilleren ved berøring
* Spilleren skader fiender ved å bruke våpen han har (sverd/bil og bue osv)
* Når spilleren har overvunnet fiendene i et rom kan han bevege seg til neste rom med nye fiender
* Fiendene blir sterkere (flere hit points, gjør mer skade) hver gang spilleren kommer til et nytt rom
* Spillet har ingen slutt, i stedet er målet å fullføre flest mulig rom. Et rom er fullført når alle fiendene i rommet er beseiret
* Spilleren kan plukke opp gjenstander som fiendene mister når de dør. Gjenstandene kan for eksempel gi tilbake hit points til spilleren


## Ideer
Foreløpige ideer til hvordan spillkarakteren og fiendene kan utvikles i løpet av spillet.

Karakterutvikling:
* Karakteren får experience points og går opp i level
* Karakteren får bedre våpen
* Våpen med ulike egenskaper som har fordeler/ulemper mot de ulike fiendene
* Karakteren får nye aktive og/eller passive ferdigheter
* En inventory som viser hvilke gjenstander spilleren har tilgjengelig


Utvikling av fiender:
* Nye fiender
* Flere hit points utover i spillet
* Beveger seg raskere
* Angriper oftere
* Hvert tiende level kan være en boss-fight
* Sjanse for å legge fra seg gjenstander spilleren kan plukke opp når de dør
