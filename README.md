BeaconRange

BeaconRange est un plugin Paper/Spigot qui permet d’ajuster le rayon d’effet des balises (beacons) selon leur niveau (tier).

Sommaire
- Fonctionnalités
- Prérequis
- Installation
- Configuration
- Commandes
- Permissions
- Construction depuis les sources
- Compatibilité
- Dépannage

Fonctionnalités
- Définir un rayon d’effet personnalisé pour chaque niveau de balise (Tier 1 à 4)
- Consulter et modifier les valeurs en jeu via une commande
- Fichier de configuration persistant

Prérequis
- Serveur Paper (recommandé) ou Spigot compatible avec l’API 1.21.x
- Java 17 ou supérieur

Installation
1. Téléchargez/compilez le JAR du plugin.
2. Placez-le dans le dossier plugins de votre serveur.
3. Démarrez/redémarrez le serveur pour générer le fichier config.yml.

Configuration
Le fichier plugins/BeaconRange/config.yml contient les rayons par niveau:

```
Range:
  Tier1: 20
  Tier2: 30
  Tier3: 40
  Tier4: 50
```

- Tier1..Tier4 correspondent aux niveaux de la balise.
- La valeur est le rayon d’effet en blocs.

Commandes
- /beaconrange get tier<1|2|3|4>
  - Affiche le rayon configuré pour le tier donné
  - Exemple: /beaconrange get tier3

- /beaconrange set tier<1|2|3|4> <rayon>
  - Définit le rayon pour le tier donné
  - Exemple: /beaconrange set tier2 48

Remarque: Écrivez tier sans espace (tier1, tier2, etc.).

Permissions
- beaconrange.admin — autorise l’utilisation des commandes get et set.

Construction depuis les sources
Le projet utilise Gradle.
- Windows: gradlew.bat build
- Linux/macOS: ./gradlew build
Le JAR sera généré dans build/libs.

Compatibilité
- api-version (plugin.yml): 1.21.10
- Serveurs testés: Paper 1.21.x (Paper est recommandé; le plugin suggère Paper via PaperLib).

Dépannage
- La commande est inconnue:
  - Vérifiez que le plugin est bien chargé (/plugins) et que plugin.yml déclare la commande beaconrange.
  - Contrôlez vos permissions.
- Le rayon ne change pas:
  - Vérifiez les valeurs dans config.yml (Range > Tier1..Tier4).
  - Consultez la console pour d’éventuelles erreurs au démarrage.

Licence
Ce projet est sous licence MIT (voir le fichier LICENSE).
