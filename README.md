# technozone_bff

## Start Containers Locally

1. **Create Network:**

   To create a Docker network, use the following command:
   ```bash
   docker network create tz-network

2. **Start Database:**

   To start mongodb container, use the following command:
   ```bash
   docker run -d -p 27017:27017 --name mongodb --network tz-network mongodb/mongodb-community-server:5.0.6-ubuntu2004

3. **Start MW:**

   To start spring boot API container, use the following command:
   ```bash
   docker run -d -p 8080:8080 --name tz-bff --network tz-network sujitkuswain9/technozone-bff:latest

4. **Start FE:**

   To start spring boot API container, use the following command:
   ```bash
   docker run -d -p 80:80 --name tz-fe --network tz-network sujitkuswain9/technozone-fe:latest