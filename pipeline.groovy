pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                // Клонируем репозиторий по SSH
                git 'git@github.com:iXimik/ans.git'
            }
        }
        stage('Run Ansible Playbook') {
            steps {
                ansiblePlaybook(
                    playbook: 'playbook.yml',
                    inventory: 'inventory.ini',
                    extras: '-u iXimik -k' // -k для запроса пароля SSH
                )
            }
        }
    }
}
