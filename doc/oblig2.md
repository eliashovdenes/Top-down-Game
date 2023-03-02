## Brukerhistorier, akseptansekriterier og arbeidsoppgaver til MVP

1. Som spiller ønsker jeg en startmeny slik at jeg kan starte spillet
	Gitt at vi har en startmeny så skal:
		1. Vi ha en enum med alle game states
		2. Vi skille mellom start meny og active game
		3. Vise menyen på skjermen
		4. Ha en keyListener som registrerer når spilleren trykker på start
		5. Forandre game state i modellen
		
2. Som spiller ønsker jeg å se spillbrettet på skjermen slik at jeg kan se hvor fiendene er og hvor jeg kan bevege karakteren min
	Gitt at vi har startet et nytt spill, så skal spillbrettet vises på skjermen
		
	Arbeidsoppgaver:
		1. Vi må ha et grid som representerer brettet
		2. Gridet må ha en størrele
		
3. Som utvikler ønsker jeg å se karakteren min på skjermen slik at jeg kan se hvor jeg er og kan gjøre valg
	Gitt at vi har startet et nytt spill, så skal karakteren vises på skjermen
	
	Arbeidsoppgaver:
		1. Vi må ha en spiller-klasse
		2. Karakteren må ha en posisjon
		3. Karakteren må tegnes på skjermen
		
4. Som spiller ønsker jeg at jeg kan bevege karakteren min ved å trykke på tastene slik at jeg kan unngå at fiender skader meg.
	Gitt at vi har startet et nytt spill, brettet vises og karakteren vises, så skal karakteren kunne flyttes:
	1. Nord ved å trykke på "w"
	2. West ved å trykke på "a"
	3. Øst ved å trykke på "d"
	4. Sør ved å trykke på "s"
	
	Arbeidsoppgaver:
		1. Vi må ha en actionListener som registrerer tastetrykk
		2. Vi må ha en metode som tester at spilleren holder seg på brettet (ikke går out of bounds)
		3. Vi må ha en move() metode som flytter spilleren i riktig rettning
		4. Vi må ha en enum med retninger karakteren kan flyttes i
		5. Modellen må oppdateres med den nye posisjonen
		6. View må tegne karakteren i den nye posisjonen
		
5. Som utvikler ønsker jeg at det er lett å skille områdene spilleren kan bevege seg på fra hindringer og vegger slik at det er enklere å teste at spillet fungerer som det skal
	Gitt at vi har startet et nytt spill og karakteren kan flyttes, så skal:
	1. Brettet vises med vegger og hindringer
	2. Karakteren ikke kunne passere vegger og hindringer
	
	Arbeidsoppgaver:
		1. Spillbrettet må vise ulike tiles
		2. Vi må skille mellom tiles karakteren kan bevege seg over og tiles som karakteren ikke kan passere
		3. Karakteren, vegger og hindringer må ha kollisjonsbokser
		4. Vi må ha en isLegalMove() metode som sjekker om karakteren har lov til å flytte seg i riktig rettning
		5. Modellen må ha informasjon om de ulike tiles-ene og hvor de er
		6. View må vite hva som skal tegnes hvor og hvordan tiles ser ut
