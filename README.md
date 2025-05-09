# Exercice 4 : Jeu de dés

## 1. Objets à mocker dans les tests

Pour tester la méthode `jouer` de la classe `Jeu`, nous devons mocker les objets suivants :

- **Banque** : Car elle gère l'état financier du jeu et nous voulons contrôler son comportement (solvabilité, crédit, débit) sans dépendre d'une implémentation réelle.
- **Joueur** : Car il gère l'état financier du joueur et nous voulons contrôler son comportement (mise, crédit, débit) sans dépendre d'une implémentation réelle.
- **De1 et De2** : Car ils génèrent des valeurs aléatoires et nous voulons contrôler les résultats des lancers pour tester différents scénarios.

## 2. Scénarios de test (classes d'équivalence)

1. **Jeu fermé** : Vérifier que le jeu lance une exception lorsque le joueur essaie de jouer sur un jeu fermé.
2. **Joueur insolvable** : Vérifier que le jeu ne fait rien lorsque le joueur n'a pas assez d'argent pour miser.
3. **Perte** : Vérifier que le joueur perd sa mise lorsque la somme des dés n'est pas égale à 7.
4. **Gain** : Vérifier que le joueur gagne deux fois sa mise lorsque la somme des dés est égale à 7 et que la banque est solvable.
5. **Gain avec banque insolvable** : Vérifier que le joueur gagne deux fois sa mise lorsque la somme des dés est égale à 7, mais que la banque devient insolvable et que le jeu se ferme.

## 4. Test du jeu fermé

Le test du jeu fermé est un **test d'état** car il vérifie l'état du jeu (fermé) et le comportement attendu (lancement d'une exception) en fonction de cet état. Il ne vérifie pas les interactions avec les autres objets.

## 5. Test du joueur insolvable

Pour tester que le jeu ne touche pas aux dés lorsque le joueur est insolvable, nous utilisons la méthode `verify(de1Mock, never()).lancer()` et `verify(de2Mock, never()).lancer()` de Mockito. Cela nous permet de vérifier que les méthodes `lancer()` des dés n'ont jamais été appelées.

Ce test est un **test d'interactions** car il vérifie les interactions entre le jeu et les autres objets (joueur, banque, dés) et s'assure que certaines interactions ne se produisent pas.

## 7. Différence entre les tests avec mock et avec implémentation réelle

Le test avec l'implémentation réelle de la banque (`JeuTestAvecBanqueReelle`) est différent du test avec mock (`JeuTest`) car :

1. **État réel** : Le test avec l'implémentation réelle vérifie l'état réel de la banque (fond, solvabilité) avant et après l'appel à la méthode `jouer`.
2. **Comportement réel** : Le test avec l'implémentation réelle utilise le comportement réel de la banque pour déterminer si elle est solvable, alors que le test avec mock simule ce comportement.
3. **Intégration** : Le test avec l'implémentation réelle teste l'intégration entre la classe `Jeu` et l'implémentation réelle de `Banque`, alors que le test avec mock isole la classe `Jeu` des autres composants.

Le test avec mock est plus unitaire et se concentre sur le comportement de la classe `Jeu` en isolation, tandis que le test avec l'implémentation réelle est plus proche d'un test d'intégration et vérifie le comportement du système dans son ensemble. 