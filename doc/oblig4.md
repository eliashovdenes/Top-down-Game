# ProsjektRapport

## Medlemmer
Team: Sørkanten (Gruppe 8/Team 1)
* Casper Karlsen
* Bjørn Hagen
* Magnus Sponnich Brørby
* Elias Hovdenes
* Hans-Christian Lønne

## Konsept

Vi har laget et Rouge Like 2D spill hvor du ser brettet ovenfra og har hentet inspirasjon fra [The Legend of Zelda (1986)](https://en.wikipedia.org/wiki/The_Legend_of_Zelda). Spillet består av tre maps:
- Et start map hvor det ikke er noen fiender, men du kan gå videre til shopen eller arenaen
- En arena hvor du må slåss mot fiender
- Et hus/shop hvor du kan kjøpe oppgraderinger

 Fiendene vil bli gradvis sterkere når du avanserer i spillet. Målet med spillet er å overleve lengst mulig/komme til høyest mulig level. Spilleren får experience points når han dreper fiender og kan på den måten gå opp i level. Når spilleren går opp i level får han også ability points som han kan bruke i shopen for å oppgradere våpen, få mer maxHitPoints og oppgradere movementspeed. Veien ut av arenaen er stengt helt til alle fiendene er beseiret. Når fiendene dør har de en sjanse til å legge fra seg en health potion som healer spilleren når han beveger seg oppå den.

## Beskrivelse av innholdet i spillet
* Spillfigur som kan beveges i åtte retninger (nord, sør, øst, vest, samt diogonalt i alle retninger)
* Todimensjonal verden:
    * Topdown - vi ser karakteren ovenfra
    * Avgrenset spillområde med vegger som spilleren ikke kan passere
    * Bygget opp av blokker med en fast størrelse i et rutenett. Spilleren og fiendene beveger seg oppå rutenettet
    * Noen blokker kan spilleren bevege seg over, mens andre hindrer spilleren (som for eksempel vegger og vann)
    
* Fiender som beveger seg og skader spilleren ved berøring
* Fiender som kan skyte prosjektiler på spilleren
* Spilleren skader fiender ved å skyte prosjektiler på dem
* Når spilleren har overvunnet fiendene i arenaen kan han gå ut av arenaen igjen
* Fiendene blir sterkere når spilleren går opp i level
* Spillet har ingen slutt, i stedet er målet å komme til høyest mulig level. Spilleren går opp i level av å drepe fiender
* Spilleren kan plukke opp health potions som fiendene mister når de dør.
* Spilleren kan kjøpe oppgraderinger i shopen
* Spillet har en start meny hvor du kan:
	* Starte nytt spill
	* Se instuksjonene til spillet
	* Credits

## Velg og tilpass en prosess for teamet

Vi har valgt å ha to fysiske møter per uke og discordmøter etter behov. I tillegg bruker vi discord-chatten til å holde hverandre oppdatert og hjelpe hverandre.  
Møtetidspunkter:
* Onsdager  kl 14:00 VilVite
* Torsdager kl 10:15 VilVite (den oppsatte gruppetimen)

I tillegg har vi hatt ekstra møte på fredagen før oblig innleveringer

Vi har brukt kanbanboard i Trello til å organisere arbeidet. Vi har tatt utgangspunkt i brukerhistoriene og satt opp oppgaver som vi fordelte. Det gjorde at vi fikk oversikt over hva som skal gjøres og hvem som skulle gjøre hva. 

Koden og alle dokumentene er samlet på gitlab. Vi har laget en egen folder (meetingminutes) hvor vi samler møtereferatene. Klassediagrammer og annen dokumentasjon er også samlet i doc folderen i gitlab.

Vi har jobbet mye med parprogrammering i møtene for å løse problemer vi har møtt på når vi har arbeidet hver for oss mellom møtene.

## Bygging og kjøring av spillet
får å lage jar-filen. gå til top-down-squad mappen og kjør kommandoen: mvn clean package .
Start jar-filen ved å gå til top-down-squad mappen og kjør kommanden: (på mac) java -jar ./target/Southgame-1-fat.jar.
(på windows) - bytt ut (/) med (\) i kommandoen.
Eller manøvrer til main.java og kjør spillet der. 

## Teknisk dokumentasjon

Kodestrukturen er vist i klassediagrammet: SouthgameDiagramFinal.png

Screens inneholder alle skjermene:
- MainMenyScreen
- InstuctionsScreen
- CreditScreen
- GameOverScreen
- Shop
- View

View klassen er hovedskjermen til spillet. Det er her verdenen tegnes med spiller, fiender, prosjektiler og alle andre objekter. Vi har ikke klart å skille modellen og view helt fordi mange av klassene er avhengig av å ha et TiledMap og det var vanskelig å skille dem fullstendig fra hverandre i libGDX. Men vi har flyttet tegningen av map-et ut av map-klassene og til view slik at vi kan lage map og alle objektene som trenger map uten å måtte tegne map på skjermen. På den måten har vi kunnet teste mye mer av koden med JUnit tester.

View henter inn MonsterInterface, PlayerInterface, AbstractGameObject, ProjectileInterface, MapInterface og ItemImpl som den bruker til å tegne objektene på skjermen. I view lager vi også MonsterFactories som lager fiendene (Monsters).

AbstractGameObject inneholder alle feltvariablene og metodene som er felles for Monster, Player og Prosjectiles. I tillegg implementerer klassene et interface som beskriver hvordan implementasjonen deres. På den måten kan vi gi interfaces til view i stedet for klassene. Dette har gjort det veldig enkelt å legge til nye fiender og nye prosjektiler.

MapInterface og ItemImpl beskriver henholdsvis hva et map og en item skal være. I spillet har vi bare en item: HealthPotion, men stukturen gjør det enkelt å legge til flere items senere hvis vi ønsker det.

Controlleren tar imot inputs fra brukeren og sender det til SouthGame og View slik at vi kan oppdatere modellen.


##### Hvordan fungerer rollene i teamet? 


Det har ikke vært noen forandring innenfor rollene frem mot siste oblig. Jo lengre vi kommer inn i prosjektet jo mer får vi bruk for roller og oppgaver.
Siden dette er siste iterason av prosjektrapporten kommer et retroperspektiv på utførelsene av rollene. 

**Magnus: TEAMLEAD og GitMaster**

Ansvarlig for individene i gruppen. At alle er involvert og opplever at de utvikles i faget. Drive gruppen videre, hjelper til å beslutte hvis det er utfordrende. Sørge for at frister blir imøtekommet og eventuelt ta tak i ting som ikke fungerer som ønsket. Ha kontroll på GIT slik at vi bruker verktøyet fornuftig. 

###### Hvordan gikk det?

Som team-lead gjorde Magnus en god jobb med å holde fast i de overordnede målene slik at vi har vært 'on track' til å levere produktet til kunden. Han opptrådde inkluderende overfor alle, gav feedback på arbeidet som ble gjort (flink å gi skryt!). Han  er flink til å involvere i beslutninger og gi ansvar til medlemmene slik at alle fikk eierskap til prosjektet. Arrangerte pils,pizza og kode-kveld som var en brak-suksess. Som GIT-MASTER hadde han kunnskapen til å veilede igjennom diverse utfordringer som gruppemedlemmene hadde (selvom jeg tror det var han selv som hadde de største utfordringene knyttet til GIT :joy:.)

	
**Casper: Kommunikasjonsansvarlig**

Ansvar for at vi holder oss til møtepunktene. At vi snakker til hverandre på en god måte og bygger relasjoner med alle på teamet. Han har også ansvar for kontakt ut mot kunden. 

###### Hvordan gikk det?

Som kommunikasjonsansvarlig har Casper vist en utmerket evne til å organisere og formidle informasjon. På en effektiv måte, har han sørget for at prosjektgruppen var godt informert og kunne jobbe bra sammen. At verktøyene vi bruker for å holde kontakt fungerte som de skal. Han viste også en sterk forståelse av prosjektets mål og krav, og var i stand til å kommunisere dette klart og tydelig til teamet. På det relasjonelle plan var han flink til å se og var inkluderende overfor alle i gruppen, som bidro til et positivt arbeidsklima. Jeg er dog rimelig sikker på at den eneste som greier å komme tidsnok til møter er Hans Christian. 

**Bjørn: Dokumentasjonsansvarlig og Arkitekt**

Sørge for at både prosjektet er tilstrekkelig dokumentert med møtereferater og at koden er tilstrekkelig dokumentert med javadoc.
Ansvaret for arkitekturen på koden, Slik at den er fin og brukervennlig.

###### Hvordan gikk det?

Som dokumentasjonsansvarlig holdt Bjørn gruppen med møtereferater fra hvert eneste møte igjennom hele prosjektet. I samsvar med feedback fra obliger ble møtereferatene ,GIT-meldinger, commit-meldinger mer forklarende, presise og som regel på samme språk (mangfold er viktig for oss!). Han var tidlig ivrig på å få på plass en kode-arkitektur som gjorde utvidelse og videreutvikling av spiller enklere og påberopte seg selv arkitektrollen. En refaktorering gjorde at vi kunne levere et prosjekt som er mer i samsvar med SOLID, Abstract Object og Game Entity prinsipper. Bjørn var en ivrig arbeider som jobbet helt til han fikk til det han ønsket, selvom det tok han mange timer.

**Hans-Chr: Testansvarlig, trelloMaster**

Sørger for at alle i gruppen skriver robuste tester til koden de implementerer. I tillegg har et overordnet blikk på at vi benytter av oss Trello til å planlegge arbeidsoppgavene våre.

###### Hvordan gikk det?

Som test-ansvarlig var det Hans-Christian fikk oss igjennom nåløyet med å lykkes å få til å lage headlessApplication objekter som lot oss teste alle klasser som var avhengig av klasser fra libgdx-biblioteket. En nøktern personlighet med sterk teknisk forståelse, som holdt gruppen jordnær og geleidet oss mot oppgaven når vi forsvant inn i koden. Som trelloMaster fikk han medlemmene til å anvende seg bruk av trello til å planlegge og velge neste oppgaver. 

**Elias: Produktutvikler, Mapdesigner**

Ansvar for å drive produktet framover slik at vi møter produksjonskrav. Designe map etter prosjektets behov ved bruk av Tiled program.

###### Hvordan gikk det?

Som produktutvikler jobbet Elias tett med alle gruppemedlemmene på forskjellige tidspunkt. Han jobbet med alle aspektene ved produktet, testet det grundig (av og til holdt han på til langt på natt). Det var under disse natt-timene han fant gamebreaking bugs og fikset dem. Hans tekniske forståelse var instrumental til et godt basisprodukt som han var med på å videreutvikle til det ferdige produktet. Som mapdesigner leverte han det vi måtte ønske og gjerne litt til. Råflotte maps med kollisjon, hus, gjerder osv.






#### Har vi erfaringer team-messig eller mtp prosjektmetodikk som er verdt å nevne? 	

Vi har hatt noen team-messige erfaringer knyttet tekniske utfordinger med testing og mye frustrasjon rundt dette. I tillegg har det vært tøft for medlemmene å balansere arbeidet opp mot andre krevende fag. Heldigvis har vi jobbet jevnt og trutt og har hatt med oss de tekniske og personlige egenskapene til å løse det. Test-problemene ble løst i en heftig parprogrammerings-runde! 

**Prosjektmetodikk:** 
Vår prosjektmetodikk har agile-elementer fra både Kanban og Scrum. Vi har et Kanban-brett i Trello, som vi har brukt til å planlegge arbeidsoppgavene. Fra scrum har vi at vært møte har startet med status og samtale om uken som har vært og hva vi skal gjøre i dag. I tillegg har vi strukturert kodingen i 'sprints' som har vært fra torsdag til torsdag, hvor vi avtaler ting som skal implementerer. Vi har fulgt en iterativ og inkrementell prosjektmetodikk med flere sykluser av design, implementasjon, refaktorering.

Link til trello: https://trello.com/invite/b/XnJilbbl/ATTI386a43a55a5bb7167986ea59bb11a91cCD52C3AF/development-oblig4-050523




#### Prosjektverktøy: 

-Kanban-brett: Trello har vi brukt aktivt. Det funkerte bra for oss. Underveis i prosjektet ble det lagt inn arbeidsoppgaver, som medlemmer plukket og jobbet med. Ikke alle var like flink til dette. Selvom ikke alle var flink til å bruke Trello så var de flink til å si hva de skulle gjøre muntlig mår gruppen var samlet.


-Vi har benyttet oss mye av parprogrammering i gruppetimer og når vi treffes utenom gruppetimen hver onsdag. Spesielt på de litt 'tyngre' oppgavene som å lage maps i TILED, headlessApplication testing. Vi bruker grupperom med tv til å vise frem kode og så parkoder vi alle sammen på gruppen. Ofte bare 2 og 2 også.

-Gitlab blir brukt til versjons-kontroll-system.

-Discord er det verktøyet vi bruker mest for å kommunisere. Her kommuniserer alt fra ideer til hva vi ønsker å lage. Discord har funket veldig bra, vi bruker det helst for å skrive, men vi har også muligheten for muntlig kommunikasjon. Dette har vært et hjelpemiddel som har gjort det veldig lett for oss å skrive til hverandre. Kommunikasjonen i gruppen hadde vært veldig dårlig om det ikke var for discord.

-Scrum: Vi var ganske selvorganiserte, som jobbet iterativt i sprints mellom gruppemøter. Startet møtene med daily stand ups (vi reiste oss ikke), hvor vi snakket om hva vi hadde holdt på med og hva vi tenker er veien videre.. 





#### Liker vi valgene vi har tatt underveis?

Ja, valgene vi har tatt er vi fornøyde med. Alltid lett å sitte i ettertid å tenke at vi skulle gjort sånn og sånn, men alt i alt hadde vi ikke kunnskapen til å ta de valgene da. Ref. prosjekt-fremgangsmåte, rollefordeling etc har det vært helt supert. Hadde vi begynt på prosjektet på nytt, med den kunnskapen vi nå har, så hadde ikke så mye blitt endret.




#### Hvordan er gruppedynamikken? Uenigheter?

Gruppen har veldig fin dynamikk. Vi har alle lyst til å møte opp og jobbe med prosjektet. Dette er noe som skaper motivasjon for alle som er med i gruppen. Om vi øsnker å gjøre ting annerledes så er alle åpne for hverandres meninger og det har ikke vært noen konflikter. Alle er åpne for god kritikk og klare for å endre det de selv har gjort. Dette har vært med å skape en utrolig fint arbeidsmiljø som har ført til at det er motiverende å jobbe med prosjektet.




#### Hvordan har kommunikasjon fungert for oss?

Det har fungert bra. Vi har brukt mye discord-serveren vår utenom de ukentlige møtene våre. Mellom-menneskelig har det vært gjensidig respekt og profesjonell kommunikasjon. Latteren sitter løst så kan ikke klage da!




#### Kort retrospektiv om hva som er bra og hva som kan forbedres. Spes.Oblig4

**Hva som er bra:**
- Vi har lagt inn tilstrekkelig innsats slik at prosjektet har utviklet seg kontinuerlig over tid. Alle har møtt på gruppemøter 2 til 3 ganger i uken som definitivt har bidratt til denne prosjektutviklingen. 
- I møter og i vår egen discordserver har vi gitt masse positiv feedback når medlemmer deler det de har jobbet med og lagt inn i prosjektet. Vi har også flittig hjulpet hverandre når vi har hatt utfordringer. Rett og slett heier hverandre fram.
- Prosjektet har 'gått seg litt til' underveis, som har gitt rom for individuell kreativitet. Det har skapt eierskap hos gruppemedlemmene. Det kunne vært utfordrende hvis noen har en veldig spesifikk visjon om hvordan ting skal se ut til slutt.
- Engasjement og samarbeid i gruppen er fortsatt bra.
- Individuelle prestasjoner de siste ukene før innelevering har vært superb. Mange timer med arbeid som er lagt ned av alle gruppemedlemmene.
- Tekniske nivået i gruppen var jevnt.

**Hva hadde vi gjort annerledes:**

**Fra oblig2 har vi kort oppsummert at vi burde:**
- Se på semesteroppgaveteksten tidligere etter hver innlevering og jobbe med den mer strukturert. 
**Dette har blitt bedre. Vi var tidlig i gang med å jobbe mot neste frist.**

- Oppgaver kan være enda mer spesifikt fordelt slik at det er klarere for den enkelte hva han skal gjøre. For eksempel: "Implementer Player klassen" blir for vagt, vi må bli enige om hvilke metoder og funksjonalitet Player skal ha. 
**Dette har vi også lyktes med. Oppgaver vi snakker om og utfører nå er mye mer detaljert.**

- Jobbe mer samkjørt, committe og merge oftere. Flere kan jobbe sammen på samme branch i stedet for at alle arbeider på hver sin branch. Dette gjør også at de som arbeider med den samme delen av klassen også må samarbeide tettere. 
**Dette har også blitt bedre. Teamet vet hva andre holder på med i større grad og jobber med samme brancher. Commits, merging etc blir kommunisert og skjer oftere.** 

**Fra oblig3 har vi kort oppsummert at vi burde:** 
- Være flinkere med å bruke Trello.
**Noen var nok mer innpå Trello enn andre, men det ble bedre.**

- Bedre avklarte forventninger i forbindelse med ansvarsfordeling. Hva vil det si å være en som ansvar for produktutvikling, egentlig? Eller TeamLead for den slag skyld. **Ansvarene ble mer satt og vi hadde tydeligere forventninger til hverandre etter å pratet om det. Da kunne vi avdekket eventuelle usikkerheter og støttet hverandre, som hadde medført til at vi kunne utført rollene bedre. Alt som er utydelig er vanskeligere å ta tak i.**

- Treffe hverandre i sosialt øyemed.
**Vi traff hverandre i sosial øyemed! Vi hadde oss en runde hjemme hos TeamLead Magnus, men det ble jo kodet en del så da lures det på om det blir et treff etter vi har levert en gang i mai?**


Vi kunne også ha satt en tydligere plan på struktur og arkitektur i prosjektet, slik at vi ikke måtte bygge det opp på nytt midt inni. Kanskje vi kunne prøvd oss på test-driven-development med å lage tester med forventet oppførsel til klassene vi har tenkt å implemtere? 

Ellers sitter vi igjen med et spill som er gøy, som man har lyst til å videreutvikle med ny funksjonalitet. Det har vært utrolig lærerikt, så hvis vi kunne begynne på nytt hadde vi nok hatt en kraftig runde med hvem gjør hva, hvem har ansvar for hva også kunne vi satt i gang med å lage spillet i en fei. Det hadde nok gått ganske fortere. Hvis det er lov å snakke litt kode har vi nok en del optimaliseringsmuligheter for å redusere lag (forhåndslaste objekter for eksempel.). Kanskje også skille model/view. 



# Krav og spesifikasjon

Siden oblig 3 har vi arbeidet mye med å skrive tester. Vi hadde problemer med at testene ikke fant filene. Det viste seg at vi hadde filene i feil folder. Vi flyttet også render() metoden ut av map-ene og til View, slik at vi kunne lage map objekter uten å tegne dem. Dette gjorde at vi kunne teste mange flere metoder siden vi trenger map til å lage Player og Enemy objekter.

Når det gjelder selve spillet så har vi prioritert å forbedre gameplay ved å forbedre oppførselen til fiendene, legge til skalering og legge til RedBoss som spilleren møter på level2 og 6.
Siden sist har vi:
- Lagt til HealthPotion som fiender kan legge fra seg når de dør
- Lagt til skalering av fiender basert på level
	- De får flere HitPoints
	- De beveger seg raskere
	- Prosjektilene til RedEnemy gjør mer skade
	- BlueEnemy gjør mer skade når spilleren kolliderer med han
- Lagt til RedBoss på level 2 og level 6:
	- RedBoss følger etter spilleren og gjør mye skade når de kolliderer
	- På level 6 kan RedBoss skyte prosjektiler på spilleren i tillegg
- Forbedret oppførselen til fiendene:
	- BlueEnemy følger etter spilleren
	- RedEnemy beveger seg i en tilfeldig retning
	- RedBoss følger etter spilleren
- RedEnemy skyter prosjektiler i fire retninger
- Forbedret menyene
	- Instructions forklarer hvordan spillerer kan styre karakteren og oppgradere våpenene
	- Credits krediterer dem som har laget grafikken og lyden vi har brukt samt navnene på alle i gruppen
- Forbedret shopen
	- Shopen ser mye penere ut
	- Viser hvor mange ability points spilleren har å kjøpe upgrades for
	- Viser hvilke abilities som er tilgjengelig og hva de koster
- Lagt til flere lydeffekter
- Lagt til musikk
- Spilleren kan dø og kommer til Game Over skjermen og kan starte spillet på nytt
- Flyttet monster listen ut av map-ene og til View. MonsterFactories lages og brukes nå i View.
- Prosjektilene har en maxrange og blir fjernet fra listen for å spare ressurser
- Spilleren blir gjennomsiktig og kan ikke ta skade i ett sekund etter han har tatt skade.
- Spilleren får tilbake maxHitpoints når han levler opp

### MVP

Vi hadde følgende krav til MVP

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

Vi hadde MVP på plass til oblig2. Til oblig3 prioritere vi å refaktorere. Kodenstrukturen ble mye bedre, men fiendene beveget seg ikke lenger og spilleren kunne ikke dø. Dette har vi nå fått på plass. Vi har kommet forbi MVP og har fokusert på å gjøre spillet mer brukervennelig. Spillet har nå to fiender med ulik oppførsel og en boss. 


### Brukerhistorier, akseptansekriterier og arbeidsoppgaver vi har jobbet med

Vi har blitt ferdig med alle brukerhistoriene vi hadde i oblig3. I tillegg har vi laget flere brukerhistorier med akseptanserkriterier og arbeidsoppgaver som vi også har blitt ferdig med. Brukerhistoriene nedenfor er de vi har jobbet og blitt ferdig med siden oblig3:

**1. Som fiende ønsker jeg å bli sterkere i løpet av spillet slik at det blir vanskligere for spilleren å drepe meg**

* Akseptansekriterier:
	1. Fiender skal skalere og få mer hitpoints og gjøre mer skade utover i spillet
	
* Arbeidsoppgaver:
	1. Vi implementere en måte å skalere hitpoints til fiendene
	2. Vi implementere en måte å skalere skaden fiendene gjør


**2. Som utvikler ønsker jeg at spilleren skal ta skade når han kolliderer med fiender slik at spillet blir mer utfordrende for spilleren**

* Akseptansekriterier:
	1. Spilleren skal ta skade når spilleren kolliderer med en fiende
	2. Spilleren skal ta ulik skade basert på level og hvilken fiende han kolliderer med
	3. Når spilleren tar skade, skal spilleren ikke kunne ta skade igjen en liten stund for å unngå at spilleren tar kontinuerlig skade når han kolliderer med en fiende
	
* Arbeidsoppgaver:
	1. Implementere kollisjons-sjekk
	2. Implementere metode som gjør spilleren uskadelig en kort periode etter han tar skade
	3. Lage feltvariabler som sier hvor mye skade en fiende gjør på spilleren når de kolliderer


**3. Som spiller ønsker jeg at fiendene skal ha bevegelsesmønster/oppførsel slik at de ikke bare står stille, da blir spillet mer utfordrende og mer underholdende å spille**

* Akseptansekriterier:
	1. Fidende skal ha en oppførsel og bevege seg på skjermen
	
* Arbeidsoppgaver:
	1. Implementere oppførsel/bevegelsesmønster for hver enkel fiende
	2. Sjekke at fiendene beveger seg naturlig og ikke setter seg fast


**4. Som spiller ønsker jeg å få poeng som jeg kan bruke til å oppgradere karakteren min slik at jeg kan utvikle spillkarakteren min**

* Akseptansekriterier:
	1. Spilleren skal få poeng/penger nå han dreper fiender
	2. Poengene kan brukes i butikken for å oppgradere prosjektiler og maxHitpoints
	3. Oppgraderingene skal ha en kostnad
	
* Arbeidsoppgaver:
	1. Lage en metode som gir spilleren poeng
	2. Implementere kostnad på oppgraderingene
	3. Lage metode som sjekker om spilleren har nok poeng til å kjøpe en upgrade

**5. Som spiller ønsker jeg at spillet har bosser jeg kan slåss mot slik at spillet blir mer underholdende å spille**

* Akseptansekriterier:
	1. På noen level skal det være en boss i arenaen i stedet for de vanlige fiendene
	2. Bossen skal ha en oppførsel/bevegelsesmønster
	3. Bossen skal ha de samme egenskapene som fiendene, men være sterkere
	
* Arbeidsoppgaver:
	1. Lage en boss-klasse
	2. Implementere oppførsel til bossen
	3. Spawne bossen i arenaen i stedet for vanlige fiender på gitte levels

**6. Som spiller ønsker jeg at fiendene skal kunne legge fra seg health potion når de dør slik at jeg kan heale skade**

* Akseptansekriterier:
	1. Fiender skal kunne droppe health potion
	2. Health potion må være synlig på skjermen
	3. Spilleren skal få mer hitpoints når han kolliderer med health potion
	4. Health potion skal forsvinne etter spilleren går på den
	
* Arbeidsoppgaver:
	1. Lage Health Potion klassen
	2. Enemies må ha en drop chance
	3. Legge til bilde for health potion
	4. Sjekke kollision mellom spilleren og health potion
	5. Lage en metode som healer spilleren


**7. Som utvikler ønsker jeg at noen av fiendene skal kunne skyte prosjektiler på spilleren slik at spilleren må ha flere ting å følge med på i spillet**

* Akseptansekriterier:
	1. En av fiendene skal skyte prosjektiler
	2. Prosjektilene til fienden skal gjøre skade på spilleren når det treffer han
	3. Prosjektiler skal forsvinne når de treffer spilleren
	
* Arbeidsoppgaver:
	1. Lag metoder i fiende klassene som lager prosjektil objekter som fienden skyter
	2. Sjekke kollisjon mellom prosjektilene og spilleren
	3. Fjerne prosjektiler som treffer spilleren eller har nådd max range fra projectile listen

**8. Som spiller ønsker jeg å bli udødelig en liten stud etter jeg tar skade slik at jeg ikke mister alle hitpointsene mine på veldig kort tid hvis jeg blir truffet av fiender mange ganger på kort tid**

* Akseptansekriterier:
	1. Spilleren skal ikke kunne ta skade i en kort periode etter han tar skade
	2. Spilleren skal kunne ta skade som normalt igjen etter denne perioden er slutt
	3. Det skal være en visuell effekt som viser at spilleren er udødelig
	
* Arbeidsoppgaver:
	1. Lage metode som gjør spilleren udødelig
	2. Lage metode som gjør spilleren dødelig igjen
	3. Gjøre spilleren gjennomsiktig når han er udødelig
	4. Vise spilleren normalt igjen når han er dødelig igjen


### Forbedringer
Vi er veldig fornøyd med hvordan spillet fungerer nå, men vi har også ideer om hvordan vi kunne bygget på og forbedret spillet. Arenaen kunne endret seg utover i spillet. Vi ville ha lagt til flere fiender, flere bosser og lagt til flere typer oppførsel på fiender. Det er vanskelig å skalere spillet riktig. Spillet skal være utfordrende nok til at spilleren opplever mestring, men ikke så vanskelig at spilleren opplever det som umulig å avansere videre. Oppgraderingen må også balanseres slik at spilleren kan bruke ulike strategier/builds som har forskjellige styrker og svakheter. 

Når det gjelder selve koden, så ønsket vi å splitte modellen og view mer, men dette var vanskelig å få til når vi brukte libGDX og TiledMaps. Skulle vi gått tilbake og gjort prosjektet en gang til, så er nok dette det vi ville fokusert mest på fra starten av. Vi har lært mye underveis og tenker vi skulle ha klart å skille modell og view bedre nå. Etter vi refaktorerte koden, ble resten av implasjonen mye lettere. Det vi har lært fra dette er at fundamentet vi bygger resten av prosjektet på er veldig viktig.


### Bugs

* Når spilleren kolliderer med/står oppå en fiende, så blir mange fiender unsynlige/blir ikke tegnet. De kommer tilbake igjen når spilleren ikke lenger står oppå en fiende.



### Hvordan styre karateren i spillet
* Du styrer karateren med "w", "a", "s", "d"
* Skyter pil med space-tasten
* skyter lyn med Enter-tasten
* Åpner og lukker oppgraderings-meny med "TAB" (kan kun gjøres i shopen)
* Løper raskere ved å holde inne "L"

## Produkt og kode:
### Dette har vi fikset siden sist:

###### Vi har fikset bevegelse på fiender.
* Før så endte de blå fiendene med å alltid gå opp i høyre hjørne, dette har vi fikset med at de blå fiendene nå går etter spilleren. Tidligere så følgte de røde fiendene etter spilleren, men dette har vi nå byttet ut med tilfeldige bevegelser pluss at di skyter i fire retninger.
###### Vi har fikset pause.
* Spillet kan nå pauses ved å trykke på "esc" og denne er nå sentrert.
###### Spiller kan nå oppgradere alt som er tilgjengelig i shop.
* Spiller kan nå oppgradere maxHitpoints, pil, strømkule og løpehastighet.
###### Vi har oppdatert alle menyer (screens).
* Finere layout og design på meny-, credits-, instructions-, death- og shop-skjermer.
###### Vi har lagt til lyder på pil og strømkule.
* Når pil og strømkule treffer fiende så spilles det av en lyd som indikerer at fienden har blitt truffet
###### Vi har lagt til lyd/musikk i start-menyen, arenaen, hus og startmappet.
* Musikk i start-menyen, arenaen og huset. Lyd i startmappet. Vi har fikset slik at musikken ikke overlapper hverandre.
###### Implementert at prosjektiler forsvinner når de treffer fiender.
* Nå forsvinner prosjektilene når de treffer fiender.
###### Vi har sotte begrensing på prosjektiler.
* Nå kan ikke prosjektiler både fra fiender og spiller gå evig, nå stopper de etter en viss tid.
###### Vi har lagt til en ny fiende.
* Lagt til en boss som dukker opp etter visse level. Denne bossen har mer liv og gjør mer skade enn de andre fiendene. Bossen blir også sterkere utifra hvilken level spilleren er på.


### Hva har dere gjort bra?

* Vi har vært gode til å bli enige om hva det er vi ønsker å lage. Vi brukte mye tid i begynnelsen til å teste oss fram og lære hva vi skulle gjøre og hvordan vi skulle gjøre det før vi i det hele tatt begynte med prosjektet. 

* Når vi har fordelt oppgaver så har folk tatt ansvar på de oppgavene og gjort det som må gjøres. Det er såklart vært noen ganger hvor ting ikke har blitt gjort til akkuratt tid det ble satt, men blir alltid gjort CA til den tiden. Så generelt i gruppen har alle vært flinke til å ta initiativ og ta eierskap til oppgavene de tar og får.  

* Vi har vært flinke med å begrense kreativiteten vår for å fokusere på oppgaven: Altså vi stoppet oss selv fra å bare kode kode kode og heller refakturerte/gjorde ting klart til obligen. Det sier mye om hvor ivrige hele gruppen er på å skape et skikkelig produkt.

* Vi har vært flinke til å hjelpe hverandre når noen har hatt problemer. Vi har også vært flinke til å spørre om hjelp når vi har hatt problemer.

* Vi har vært flinke til å bruke git og gitlab. Vi har vært flinke til å committe og pushe ofte. Vi har også vært flinke til å bruke branches og pull requests.

* Vi har vært flinke til å bruke Trello. Det har gitt oss god oversikt og hjulpet oss med posjektmetodikken vår.

* Vi har vært flinke til å bruke Discord. Vi har brukt det til å kommunisere med hverandre og til å hjelpe hverandre. Vi har også brukt det til å ha møter.


### Hva vi hadde gjort annerledes hvis vi begynte på nytt?

* Endret fremgangen de første dagene. Kanskje droppet å sitte foran pcen, men heller kjørt noe bli kjent aktiviteter. Derretter sette av at én person lager første "skjelettet". Opplevde at det ble lite framgang når vi ventet på skjelettet.

* Vi skulle ha bestemt oss for arkitekturen med en gang istedenfor å måtte endre på alt midt i det hele. Det tok tid å, for det første, få programmet til å virke som det gjorde før "renovasjonen", og for det andre, til å få hele gruppen til å forstå seg på den nye strukturen. 

* Blitt enige om kommentarer til git tidligere, ikke blande språk.

* Vi skulle vært tydeligere ovenfor hverande om hva vi ville spillet skulle inneholde. Vi ble enige om et konsept, men det var mange implementasjonsvalg vi måtte ta underveis og medlemmene hadde ulike ideer om hva de ville spillet skulle være. Noen ville ha mer story-line med npc-er spilleren kunne snakke med og quester, mens andre i gruppen var mer fokusert på combat-aspektet. Vi løste det på en fin måte ved å sette oss ned, legge alle ideene på bordet og bli enig om hva som var viktigst å få på plass først (som er det vi har beskrevet i MVP delen). Vi ble enige om at story-line delen ville ta for mye tid og det var ikke noe vi trengte for å levere på spillkonseptet. 

### Manuelle tester

* trykk på "new game" i main menu for å starte spillet.

* beveg deg mot et tre (eller andre gjenstander som er naturlig at du ikke kan gå forbi) og se at spilleren stopper, og fremdeles kan bevege seg i alle andre retninger der det ikke ligger et objekt.

* trykk på alle tastene som gitt i brukermanualen og sjekk at alle knapper gjør som de skal.

* forsøk å kollidere å gå inn i hulen, og se at du kommer til et nytt map. Her kan du forsøke å være borti fiendene som er blå og rød, og da vil du til slutt få en "You died"-skjerm når du er tom for liv.

* forsøk også å angripe fienden mens du holder inne space- eller enter-tasten. Når prosjektilene da kolliderer med fienden skal fienden miste hp (healthpoints) og til slutt død. Når du har drept alle fiender skal du kunne gå ut gjennom huleutgang øverst på mappet.

* forsøk å gå inn døren til huset og se at mappet bytter til et mindre map, inne her skal du kunne trykke på tab-tasten og en "shop"-skjerm skal dukke opp. På denne skjermen skal du kunne bruke ability poeng til å oppgradere pil, strømkule, maksimal hp (healthpoints) og løpehastighet. Spilleren får mer og mer ability poeng etter hvor flere fiender som blir drept. Arenaen der du slåss mot fiender skal også bli vanskeligere og vanskeligere utifra hva level spilleren er.


## Bildet på klassediagrammet
![image.png](SouthgameDiagramFinal.png)

## Credits

Credits er også i LICENSE.md filen

**Sound**
- arena-2.mp3 (Magnus Brørby)
- bow-release.mp3 (quicksounds.com https://quicksounds.com/library/sounds/bow)
- dead.mp3 (mixkit.com)
- deep_south-night-sounds-115466.mp3 https://pixabay.com/sound-effects/search/night/
- electric-shock.mp3 (mixkit.com)
- HouseMusic.mp3 (Elias Hovdenes)
- killed.mp3 (mixkit.com)
- KnappeLyd.mp3 (Minecraft Mojang)
- start.mp3 (mixkit.com)
- takehit.mp3 (lyd sample av Magnus Brørby)

**Entity pictures**
- RedEnemy: spriters resource, leninglo https://www.spriters-resource.com/custom_edited/thelegendofzeldacustoms/sheet/74297/
- BlueEnemy: spriters resource, leninglo https://www.spriters-resource.com/custom_edited/thelegendofzeldacustoms/sheet/74297/
- RedBoss: spriters resource, leninglo https://www.spriters-resource.com/custom_edited/thelegendofzeldacustoms/sheet/115582/
- Player pictures: barubary, spriters resource https://www.spriters-resource.com/game_boy_advance/thelegendofzeldatheminishcap/sheet/6369/

**Projectile pictures**
- Arrow: 
- Lightning: Lightning pngitem.com
- red projectile: (Hans-Christian Lønne)

**Map assets**
- tileset: isaiah658 opengameart.org
- map(sammensatt av tilesettet): (Elias Hovdenes)

**Item pictures**
- HealthPotion: (Potions:  Bonsaiheldin https://opengameart.org/content/rpg-potions-16x16)

**Screen Backgrounds**
- credits.png (Magnus Brørby)
- instructions.png (Magnus Brørby)
- mainmenu.png (Magnus Brørby)
- shop.png (Magnus Brørby)