# Book Social Network - Corrections Appliquées

## Problèmes Identifiés et Corrigés

### 1. ❌ Problème dans `BeansConfig.java`

**Problème :** La méthode `passwordEncoder()` manquait l'annotation `@Bean`.
**Correction :** Ajout de l'annotation `@Bean` et du bean `AuthenticationManager`.

### 2. ❌ Erreur dans `AuthenticationService.java`

**Problème :** Le `lastName` était assigné deux fois au lieu d'être assigné correctement.
**Correction :**

```java
.firstName(request.getFirstname())
.lastName(request.getLastname())  // ✅ Corrigé
```

### 3. ❌ Import incorrect dans `JwtFilter.java`

**Problème :** Import de `java.net.http.HttpHeaders` au lieu de `org.springframework.http.HttpHeaders`.
**Correction :** Suppression de l'import incorrect (non utilisé).

### 4. ❌ Import incorrect dans les entités

**Problème :** Import de `jakarta.annotation.Generated` au lieu de `jakarta.persistence.GeneratedValue`.
**Correction :** Suppression des imports incorrects.

### 5. ❌ Sauvegarde de l'utilisateur commentée

**Problème :** `userRepository.save(user);` était commenté dans `AuthenticationService`.
**Correction :** Décommentage de la ligne pour sauvegarder l'utilisateur.

### 6. ❌ Initialisation des rôles manquante

**Problème :** Les rôles USER et ADMIN n'étaient pas initialisés dans la base de données.
**Correction :** Ajout de `DataInitializer.java` pour créer automatiquement les rôles.

## Démarrage de l'Application

### Prérequis

- Java 17
- Docker et Docker Compose
- PostgreSQL (via Docker)

### Étapes

1. **Démarrer les services Docker :**

   ```bash
   ./start-dev.sh
   ```

   Ou manuellement :

   ```bash
   docker-compose up -d
   ```

2. **Vérifier les services :**

   - PostgreSQL : `localhost:5432`
   - MailDev : http://localhost:1080

3. **Démarrer l'application Spring Boot :**

   ```bash
   ./mvnw spring-boot:run
   ```

4. **Tester l'API :**
   - Swagger UI : http://localhost:8080/api/v1/swagger-ui.html
   - Base URL : http://localhost:8080/api/v1

### Endpoints Disponibles

- `POST /api/v1/auth/register` - Inscription d'un nouvel utilisateur
- Autres endpoints protégés par JWT

### Test d'Inscription

```bash
curl -X POST http://localhost:8080/api/v1/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "firstname": "John",
    "lastname": "Doe",
    "email": "john.doe@example.com",
    "password": "password123"
  }'
```

## Configuration Email

L'application utilise MailDev pour les tests d'emails en développement :

- Interface Web : http://localhost:1080
- SMTP : localhost:1025

## Base de Données

La base de données PostgreSQL est configurée avec :

- Host : localhost:5432
- Database : book_social_network
- Username : username
- Password : password

## Avertissements Résolus

Les avertissements de dépréciation dans `BeansConfig.java` sont normaux avec Spring Boot 3.x mais n'affectent pas le fonctionnement de l'application.

## Prochaines Étapes

1. Ajouter l'authentification et la génération de JWT
2. Implémenter l'activation de compte par email
3. Ajouter la gestion des livres et des évaluations
4. Implémenter les tests unitaires
