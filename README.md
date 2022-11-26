# Požičovňa áut PABT



Požičovňa áut PABT. Cieľom môjho projektu je program, ktorý by sa dal využiť pri prevádzke autopožičovne.  Na začiatku si uživatel určí, či bude ďalej pokračovať ako Employee alebo Customer. 


Bezpečnosť -> údaje, ktoré zákazník zadá budú zabezpečené tak, aby sa k ním nedostal nikto cudzí.

Spoľahlivosť -> Pri nedodržaní termínu vrátenia vozidla je osoba penalizovaná.




# FINAL ODOVZDANIE - DOKUMENTÁCIA
## Zámer projektu:
Jedná sa aplikáciu požičovne áut s názvom PABT. Aplikácia, ktorá by sa dala využiť pri prevádzke auto požičovne. Používateľ si môže prenajať auto, pozrieť si svoju objednávku, prípadne auto vrátiť skôr. Keď sa prihlási zamestnanec, tak má k dispozícii zoznamy všetkých áut, požičaných a dostupných áut, zákazníkov a objednávok. Admin účet zamestnanca môže pridávať nových zamestnancov.


##   Priebeh programu:
#### Ako zákazník
Ako ID / login zadám číslo OP, vložím ďalšie údaje vrátane sumy, ktorú mám k dispozícii. Vyberiem si z ponuky áut a na ako dlho si chcem dané auto požičať. Ukáže sa mi zhrnutie objednávky a potvrdím objednanie. Počas platnej objednávky si môžem skontrolovať svoju objednávku, prípadne ju skoršie vrátiť. Pokiaľ auto (objednávku) vrátim po uplynutí doby prenájmu, nevráti sa mi záloha a moje číslo OP je bude tzv. BanListe.

#### Ako zamestnanec
Použijem svoj login a heslo na prihlásenie sa do systému. Môžem si prezrieť všetky dostupné zoznamy. Ak sa prihlásim ako admin, môžem vytvoriť login a heslo pre nových zamestnancov.

## Zatial zaregistrovaní zamestnanci

    login: login   heslo: a
    login: swf     heslo: leia
    login: swm     heslo: luke
    login: joujou  heslo: bardejou
    ADMIN:
    login: admin   heslo: admin


## Zatial zaregistrovaní zákazníci

    ID: AA123456
    ID: BB123456
    ID: CC123456
    ID: late1
    ID: late2


Tie posledné dva sú na otestovanie prípadu, keď zákazník ide vrátiť auto po stanovenom dátume.

A ešte aj ID: skuska , toto ID je už na Banliste.

S pozdravom,

Adam Baran-Tomik
