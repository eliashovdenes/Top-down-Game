# INF112 - Prosjekt Top Down Squad

## Default branch er Develepor
* Vi gjorde Develepor til default branch fordi vi ville unngå merge konflikter på bakgrunn av dårlig tid.

## Medlemmer
Team: Sørkanten (Gruppe 8/Team 1)
* Casper Karlsen
* Bjørn Hagen
* Magnus Sponnich Brørby
* Elias Hovdenes
* Hans-Christian Lønne

## Om spillet
Vi har laget et Rouge Like 2D spill hvor du ser brettet ovenfra og har hentet inspirasjon fra [The Legend of Zelda (1986)](https://en.wikipedia.org/wiki/The_Legend_of_Zelda). Spillet består av tre maps:
- Et start map hvor det ikke er noen fiender, men du kan gå videre til shopen eller arenaen
- En arena hvor du må slåss mot fiender
- Et hus/shop hvor du kan kjøpe oppgraderinger

 Fiendene vil bli gradvis sterkere når du avanserer i spillet. Målet med spillet er å overleve lengst mulig/komme til høyest mulig level. Spilleren får experience points når han dreper fiender og kan på den måten gå opp i level. Når spilleren går opp i level får han også ability points som han kan bruke i shopen for å oppgradere våpen, få mer maxHitPoints og oppgradere movementspeed. Veien ut av arenaen er stengt helt til alle fiendene er beseiret. Når fiendene dør har de en sjanse til å legge fra seg en health potion som healer spilleren når han beveger seg oppå den.

## Bygging og kjøring av spillet
For å lage jar-filen. gå til top-down-squad mappen og kjør kommandoen: mvn clean package .
Start jar-filen ved å gå til top-down-squad mappen og kjør kommanden: (på mac) java -jar ./target/Southgame-1-fat.jar.
(på windows) - bytt ut (/) med (\) i kommandoen.
Eller manøvrer til main.java og kjør spillet der. 

## Keybinds
### Bevegelse: 
- Høyre: "D"
- Venstre: "A"
- Opp: "W"
- Ned: "S"
- Løping: "Left Shift"
### Angrep: 
- Lynangrep: "enter" 
- Pilangrep: "space"
### Øvrige keybinds
* Pause spillet: "Escape"
* Butikk: "TAB"

## Kjente feil
- Når spilleren kolliderer med en fiende så forsvinner de andre fiendene i et lite øyeblikk.

## Credits

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
