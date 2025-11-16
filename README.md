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
- beaconrange.admin

