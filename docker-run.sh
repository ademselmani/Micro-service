#!/bin/bash

# Colors for better output
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
NC='\033[0m' # No Color

print_header() {
    echo -e "${YELLOW}"
    echo "====================================================="
    echo "  Microservices Docker Management Script"
    echo "====================================================="
    echo -e "${NC}"
}

print_help() {
    echo -e "${GREEN}Usage:${NC}"
    echo "./docker-run.sh [command]"
    echo ""
    echo -e "${GREEN}Available commands:${NC}"
    echo "  start      - Start all services"
    echo "  stop       - Stop all services"
    echo "  restart    - Restart all services"
    echo "  status     - Show status of containers"
    echo "  logs       - Show logs from all services"
    echo "  build      - Rebuild all images"
    echo "  clean      - Remove all containers and volumes"
    echo "  help       - Show this help message"
    echo ""
}

start_services() {
    echo -e "${GREEN}Starting all services...${NC}"
    docker-compose up -d
    echo ""
    echo -e "${GREEN}Services started. Access URLs:${NC}"
    echo "Discovery Service: http://localhost:8761"
    echo "Gateway: http://localhost:8078"
    echo "Chombre Service: http://localhost:8089"
    echo "Chombre Swagger UI: http://localhost:8089/swagger-ui.html"
    echo "H2 Console: http://localhost:8089/h2-console"
}

stop_services() {
    echo -e "${GREEN}Stopping all services...${NC}"
    docker-compose down
}

restart_services() {
    echo -e "${GREEN}Restarting all services...${NC}"
    docker-compose down
    docker-compose up -d
}

show_status() {
    echo -e "${GREEN}Services status:${NC}"
    docker-compose ps
}

show_logs() {
    echo -e "${GREEN}Services logs:${NC}"
    docker-compose logs -f
}

build_services() {
    echo -e "${GREEN}Building all services...${NC}"
    docker-compose build --no-cache
}

clean_all() {
    echo -e "${RED}WARNING: This will remove all containers and volumes.${NC}"
    read -p "Are you sure you want to continue? (y/n) " -n 1 -r
    echo
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        docker-compose down -v
        echo -e "${GREEN}All containers and volumes removed.${NC}"
    fi
}

# Main execution
print_header

case "$1" in
    start)
        start_services
        ;;
    stop)
        stop_services
        ;;
    restart)
        restart_services
        ;;
    status)
        show_status
        ;;
    logs)
        show_logs
        ;;
    build)
        build_services
        ;;
    clean)
        clean_all
        ;;
    help|*)
        print_help
        ;;
esac 