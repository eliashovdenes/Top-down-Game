## (A1)
Readme.md er oppdatert

Kartlegging av kompetanse: 
* Magnus:       Komfortabel med git, java, python, haskell. Ung, ambisiøs og fremadstormende.
* Hans-Christian: Komfortabel med Python, Java. Mange års arbeidserfaring! 
* Elias:          Fra Os. Sannsynligvis komfortabel med java, python, haskell. 
* Casper:         Komfortabel med java, python, haskell, 
* Bjørn:          Komfortabel med Python, Java, R. Erfaring med personal-ledelse, retail.

Fordeling av roller: 
* Magnus:     Teamlead (og GitMaster)  
* Casper:     HR og kommunikasjonsansvarlig (Discordmaster)  
* Bjørn:      Dokumentasjonsansvarlig  
* Hans-Chr:   Test-ansvarlig  
* Elias:      Produktutvikler  

Vi har fordelt roller basert på ønsker og hva den enkelte føler seg komfortabel med. Magnus har satt seg inn i git og har fått ansvar for den delen. Casper har ansvar for å passe på at alle er oppdatert på når vi skal møtes og hvilke oppgaver den enkelte har. Bjørn tok møtenotater på eget initativ og ble automatisk referent. Hans-Chr. har fått ansvar for å passe på at koden er godt nok testet. Vi regner med at vi må redefinere rollene i løpet av prosjektet når vi har blitt bedre kjent både med hverandre og prosjektet.

## Konsept (A2)

Vi vil lage et Rouge Like 2D spill hvor du ser brettet ovenfra og har hentet inspirasjon fra [The Legend of Zelda (1986)](https://en.wikipedia.org/wiki/The_Legend_of_Zelda). I spillet må du beseire fiender før du kan bevege deg videre til neste rom. Fiendene vil bli gradvis sterkere når du avanserer i spillet. Målet med spillet er å overleve lengst mulig/fullføre så mange rom som mulig (et rom er fullført når alle fiendene i rommet er beseiret). Når fiendene dør har de en sjanse til å legge fra seg gjenstander som hjelper spilleren.

### Foreløpig beskrivelse av innholdet i spillet
* Spillfigur som kan beveges i åtte retninger (nord, sør, øst, vest, samt diogonalt i alle retninger)
* Todimensjonal verden:
    * Topdown - vi ser karakteren ovenfra
    * Avgrenset spillområde med vegger som spilleren ikke kan passere
    * Bygget opp av blokker med en fast størrelse i et rutenett. Spilleren og fiendene beveger seg oppå rutenettet
    * Noen blokker kan spilleren bevege seg over, mens andre hindrer spilleren (som for eksempel vegger og vann)
    
* Fiender som beveger seg og skader spilleren ved berøring
* Spilleren skader fiender ved å bruke våpen han har (sverd/bil og bue osv)
* Når spilleren har overvunnet fiendene i et rom kan han bevege seg til neste rom med nye fiender
* Fiendene blir sterkere når spilleren avanserer til nye rom
* Spillet har ingen slutt, i stedet er målet å fullføre flest mulig rom. Et rom er fullført når alle fiendene i rommet er beseiret
* Spilleren kan plukke opp gjenstander som fiendene mister når de dør. Gjenstandene kan for eksempel gi tilbake hit points til spilleren


### Ideer
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

## Velg og tilpass en prosess for teamet (A3.1)

Vi har valgt å ha to fysiske møter per uke og discordmøter etter behov. I tillegg bruker vi discord-chatten til å holde hverandre oppdatert og hjelpe hverandre.  
Møtetidspunkter:
* Onsdager  kl 14:00 VilVite
* Torsdager kl 10:15 VilVite (den oppsatte gruppetimen) 

Vi vil bruke GitLab issue board til å organisere arbeidet. Da kan vi ta utgangspunkt i brukerhistoriene og sette opp oppgaver som vi kan fordele. Det gjør det oversiktlig å se hvem som jobber på hva og hva som fremdeles må gjøres. Casper har som kommunikasjonsansvarlig hovedansvar for å følge opp arbeidet. Alle på gruppen har også ansvar for å oppdatere de andre i gruppen om hvordan de ligger an. Hvis noen ligger bakpå eller sliter med å få til en oppgave, er det viktig at de sier ifra til resten av gruppen slik at vi kan løse problemet sammen.

Koden og alle dokumentene er samlet på gitlab. Vi har laget en egen folder (meetingminutes) hvor vi samler møtereferatene. Klassediagrammer og annen dokumentasjon vil også bli samlet på gitlab.

I neste del av prosjektet vil vi arbeide med å lagge et minimum viable product (MVP). Her tenker vi det er lurt å først tegne opp et klassediagram. Vi vil følge model-view-controler modellen og et klassediagram gjør arbeidet mye mer oversiktlig. Videre tenker vi å lage interface i fellesskap, slik at alle er enige om hvilken funksjonalitet klassene skal ha. Da er det lettere å sette opp oppgaver på Kanban-boardet og det blir mer tydelig for den enkelte hva han skal gjøre. 

Vi prøvde litt parprogrammering på øvelsesoppgavene, men ble ikke helt komfortable med det. Vi tenker likevel at vi kan bytte på å implementere interface og skrive tester slik at det ikke er den som skriver metodene som også skriver testene (i allefall bør det være noen i tillegg til den som skriver metodene som skriver tester).

## Få oversikt over forventet produkt (A3.2)

### Minimum Viable Product (MVP)
1. Vise spillbrettet
2. Vise spilleren på spillbrettet
3. Kunne bruke tastene til å flytte spilleren
4. En enkel fiende spilleren kan bekjempe
5. Spilleren må ha hit points
6. Spilleren må kunne ta skade og dø
7. Spilleren må kunne gå til et nytt rom
8. En teller som viser hvilket nivå/rom nummer(level) spilleren er på
9. Startskjerm når spillet kjøres
10. Game Over skjerm
11. Mulighet til å starte på nytt

## Brukerhistorier

1. Som spiller så ønsker jeg å ha muligheten til å kunne forbedre spill karakteren min slik at jeg kan overvinne sterkere fiender senere i spillet. 

2. Som spiller ønsker jeg at det skal bli mer utfordrene etterhvert som jeg kommer lengre inn i spillet slik at spillet ikke blir for lett/kjedelig.

3. Som spilldesigner ønsker jeg muligheten til at nivåene skal være annerledes og endre seg etter hvert "nivå" slik at det skal bli mer tydelig for spilleren at han har kommet seg lenger i spillet.

4. Som programmerer ønsker jeg at det skal være lett å legge til fiender og endre på "stats" hos fienden. Dette gjør det mye letter å videreutvikle spillet.

5. Som spiller ønsker jeg at spillet skal være lett å starte slik at jeg slipper å bruke mye tid på å komme igang.

6. Som spiller ønsker jeg at jeg kan bevege karakteren min slik at jeg kan unngå at fiender skader meg.

7. Som utvikler i en gruppe ønsker jeg å ha et klassediagram slik at jeg får oversikt over strukturen i koden.

8. Som spiller ønsker jeg å kunne angripe fiendene slik at jeg kan overvinne dem.

9. Som utvikler ønsker jeg at det er lett å skille områdene spilleren kan bevege seg på fra hindringer og vegger slik at det er enklere å teste at spillet fungerer som det skal

10. Som spiller ønsker jeg at det er en visuell effekt når jeg tar skade slik at jeg ser når fiender skader meg

## Kode(A4)
Vi har nesten et helt fungerende MVP spill, denne koden ble laget før vi laget en git repository så vi har et fungerende som vi har vist til gruppeleder. 

Måten vi har lyst å sette opp koden til spillet vil vi bruke en loop som gjør at spillet oppdaterer seg 60 ganger i løpet av et sekund. Hver gang denne "ticker" så vil dette "tegne" brettet på nytt. En slik loop vil gjøre at selve spillet vil føles behagelig å spille og ha svært lite input lag.

En enum fil med objekter som gjør at vi kan instansiere flere objecter av samme type uten at de skal være bundet. Som la oss si vi tar skade på en fiende så fungerer ikke spillet optimalt om de har en felles HP-bar.



## Oppsumering (A5)

* Hva som gikk bra

De som har satt seg inn i libGDX er stort sett fornøyd, lett å lære seg og virker som funksjonalitetene strekker til konseptet. Dette er for øyeblikket hjemmelekse for alle å sette seg inn i for å oppnå en bred forståelse. 


* Hva som ikke gikk helt forventet

Git skal tilsynelatende fungere bra, men det tar tid å vende seg til for de fleste og forstå hvordan de ulike kommandoene skal behandles. 
Vi har brukt tid på å prøve oss fram, er enda ikke helt komfortable med bruken av det, spesielt merge og konseptet med mergerequest.


Og hva som ikke virket i det hele tatt
Ingenting spesielt som ikke har funket i det hele tatt. Det har hendt at vi har surret til git merge og har endt opp med å slette hele filsystemet på pc-en for å så clone repositoryet på nytt. 


* Nye verktøy eller aktiviteteter gruppen vil prøve ut iløpet av neste obligatoriske oppgave

Som sagt, libGDX har fått god omtale i teamet og vi skal ytterligjøre kunnskapene rundt det fremover.
Kunnskapene rundt git skal også forbedres.  
