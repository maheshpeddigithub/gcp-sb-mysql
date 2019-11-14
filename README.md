1. created MySQL instance in GCP Cloud SQL

2. created Firewall to allow port 3306

3. added network config with <laptop_ip>/32 for created mysql instance

4. updated GCP MySQL IP address in application.properties

% mvn spring-boot:run