# Sujet d'évaluation: LesBonsTuyaux

> Vous souhaitez plagier Dealabs et créer une application similaire présentant des bons plans entrés par des utilisateurs.

Fourni:
- La base de données au format JSON;
- Le squelette de l'application

Vous simulerez une API via l'outil `json-server` (`json-server --watch bdd.json`).

Attendue: Une application présentant:
- La liste des bons plans récupérés depuis l'API
    - Afficher pour chaque bon plan son titre, le code, l'utilisateur qui a ajouté l'offre et la date d'expiration de cette dernière
- Un formulaire permettant d'ajouter un bon plan
    - Les données obligatoires sont les suivantes: **titre**, **nom d'utilisateur**, **code promo**, **date d'expiration**
    - Vous pourrez ajouter optionnellement un lien vers une image

Bonus:
- Gestion des commentaires:
    - Afficher les commentaires des bon plans
    - Pour chaque bon plan, présenter un champ permettant d'ajouter un commentaires et gérer l'ajout dans la base de ce commentaire

Vous serez noté sur votre capacité à **écrire des composants Vue** et à **écrire des formulaires**. *Ne vous perdez pas dans des détails de CSS* !
