#!/bin/bash

# Script pour démarrer l'environnement de développement

echo "🚀 Démarrage de l'environnement de développement Book Social Network"

# Vérifier si Docker est en cours d'exécution
if ! docker info > /dev/null 2>&1; then
    echo "❌ Docker n'est pas en cours d'exécution. Veuillez démarrer Docker Desktop."
    exit 1
fi

echo "📦 Démarrage des services Docker..."
docker-compose up -d

echo "⏳ Attente du démarrage des services..."
sleep 10

echo "✅ Services démarrés :"
echo "   - PostgreSQL : localhost:5432"
echo "   - MailDev : http://localhost:1080"

echo "🔧 Vous pouvez maintenant démarrer l'application Spring Boot avec :"
echo "   ./mvnw spring-boot:run"

echo ""
echo "📧 Interface de test email : http://localhost:1080"
echo "🗄️  Base de données : postgresql://localhost:5432/book_social_network"
echo ""
echo "Pour arrêter les services : docker-compose down"
